import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import componentes.Color;
import componentes.Material;
import componentes.Prenda;
import componentes.TipoDePrenda;
import componentes.Trama;
import eventos.Evento;
import eventos.Sugerencia;
import guardarropas.Guardarropa;
import repositorio.Repositorio;
import spark.*;
import usuario.Usuario;

public class Fachada {
	//La base de datos se llama "ati1txh3yqvapdna" ya que asi viene por defecto la que nos da JawsDB Maria
	private static final String PERSISTENCE_UNIT_NAME = "ati1txh3yqvapdna";
	private static EntityManagerFactory emFactory;	
	private static Repositorio repositorio;	
	private static EntityManager entityManager;
    
	// Cause Fachada is a Singleton 
    private static Fachada single_instance = null;
    private Fachada(){
    	this.inicializar();
    }
    
    public static Fachada getInstance(){ 
        if (single_instance == null) 
            single_instance = new Fachada();
        return single_instance; 
    }	
	
	private void inicializar(){
        //System.out.println("Inizializando la fachada...");
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		entityManager = emFactory.createEntityManager();
		repositorio = new Repositorio(entityManager);
        //System.out.println("Ahora puede realizar consultas a la base de datos");
	}    

	public static void finalizar() {
		repositorio.cerrar();
		emFactory.close();
	}
	
	//PARA LOGIN/REGISTER
	
	public void chequearQueHayaAlguienConectado(Request request, Response response) {
        if (request.session().attribute("user") == null) {
            request.session().attribute("loginRedirect", request.pathInfo());
            response.redirect("login");
        }        
	}
	
	public String buscarUserNameConectado(Request request) {
		return request.session().attribute("user");			
	}

	public Usuario buscarUsuarioPorUsername(String userName){
		String statement = String.format("SELECT id FROM Usuario WHERE userName = '%s'", userName);
		Long id = Long.valueOf(listToString(listAndCast(statement)));
        //System.out.println("id: "+id);
		return entityManager.find(Usuario.class, id);		
	}
	
	public void registrarUsuarioCon(String inputtedFirstName, String inputtedLastName, String inputtedEmail, 
		String inputtedUsername, String inputtedPassword) {
			Usuario unUsuario = new Usuario(inputtedUsername);
			unUsuario.setNombre(inputtedFirstName);
			unUsuario.setApellido(inputtedLastName);
			unUsuario.setMail(inputtedEmail);
			unUsuario.setPassword(inputtedPassword);			
			repositorio.usuario().persistir(unUsuario);	
	}
	
	public boolean chequearSiExiste(String inputtedUsername, String inputtedPassword) {	
		Usuario usuarioBuscado = repositorio.usuario().buscarPorUsuarioContrasenia(inputtedUsername, inputtedPassword);
		return (usuarioBuscado != null);					
	}
	
	public boolean usuarioExiste(String inputtedUsername) {
		String statement = String.format("SELECT nombre FROM Usuario WHERE nombre = '%s'", inputtedUsername);
		List<String> list = listAndCast(statement);
		return (list.size()>0);
	}		
 
	public List<String> devolverTodosLosGuardarropas(Request request) {
		String usuarioConectado = this.buscarUserNameConectado(request);
		String statement_userID = String.format("SELECT id FROM Usuario WHERE userName = '%s'", usuarioConectado);
		List<String> idDuenio = listAndCast(statement_userID);
		String statement_Guardarropas = "SELECT DISTINCT nombre FROM Guardarropa WHERE usuario_id = "+ listToString(idDuenio);
	    return listAndCast(statement_Guardarropas);
	}	
	
	private List<String> listAndCast(String statement) {
		try {
	    Query queryIDUsuario = entityManager.createQuery(statement);
		@SuppressWarnings("unchecked")
		List<String> list = queryIDUsuario.getResultList();
		return list;
		}catch (Exception e){
			System.out.println("Exception: "+e);
			return null;
		}	
		
	}
	
	private String listToString(List<String> list) {
		//int size = list.toString().length() - 1;
		//return list.toString().substring(1, size);
		return String.valueOf(list.get(0));
	}
	
	public void crearGuardarropasAlPibe(Request request) {
		String usuarioConectado = this.buscarUserNameConectado(request);
		String cantidadGuardarropas = Integer.toString(devolverTodosLosGuardarropas(request).size());
        String nuevoNombreDelGuardarropas = String.format("Guardarropas %s %s", usuarioConectado, cantidadGuardarropas);
		Usuario usuarioLogueado = this.buscarUsuarioPorUsername(buscarUserNameConectado(request));
		Guardarropa guardarropa = new Guardarropa();
		guardarropa.setNombre(nuevoNombreDelGuardarropas);
		usuarioLogueado.agregarGuardarropa(guardarropa);
		repositorio.guardarropa().persistir(guardarropa);
	}
	
	public List<String> devolverTodasLasPrendas(String inputtedguardarropas) {
	    Query idGuardarropas = entityManager.createQuery(String.format("SELECT id FROM Guardarropa g WHERE g.nombre = '%s'",inputtedguardarropas));
	    String statement = ("SELECT DISTINCT nombre FROM prenda WHERE guardarropa = " + idGuardarropas.setMaxResults(1).getSingleResult());
		return listAndCast(statement);
	}
	
	public List<String> devolverTodosLosTipoDePrendas() {
		return devolverTodosLos("TipoDePrenda");
	}
	
	public List<String> devolverTodosLosMateriales() {
	    return devolverTodosLos("Material");
	}
	
	public List<String> devolverTodosLasTramas() {
	    return devolverTodosLos("trama");
	}
	
	public List<String> devolverTodosLosUsuarios() {
		return devolverTodosLos("usuario");
	}
	
	private List<String> devolverTodosLos(String columna) {
	    String statement = (String.format("SELECT DISTINCT nombre FROM %s ORDER BY nombre ASC",columna));
		return listAndCast(statement);
	}

	public void persistimeEstaPrenda(String nombre, String tipoDePrenda, String material, String color_1, String color_2, String trama, String guardarropa) {
		//System.out.println("Guardarropas:" + guardarropa);
		//convertimos strings a objetos	
		TipoDePrenda unTipo= convertirStringAObjeto(TipoDePrenda.class, "TipoDePrenda", tipoDePrenda);
		Color unColor1 = this.hex2Rgb(color_1);
		
		Material unMaterial= convertirStringAObjeto(Material.class, "Material", material);
		Trama unaTrama= convertirStringAObjeto(Trama.class, "trama", trama);
		
		Prenda unaPrenda = null;
		
        System.out.println("color_2:"+color_2);

		
		if(color_2!=null) {
			Color unColor2 = this.hex2Rgb(color_2);
			unaPrenda = new Prenda(nombre, unTipo, unMaterial, unColor1, unColor2, unaTrama );
		}else {
			unaPrenda = new Prenda(nombre, unTipo, unMaterial, unColor1, unaTrama );
		}
		
		Guardarropa unGuardarropa = convertirStringAObjeto(Guardarropa.class, "Guardarropa", guardarropa);
		//try {
			unGuardarropa.agregarAGuardarropas(unaPrenda);
			repositorio.prenda().persistir(unaPrenda);
		/*	
		} catch (Exception e) {
			System.out.println("LPQTP");
		}*/					
	}
	
	@SuppressWarnings("unused")
	private byte[] convertingAnInputStreamToAByteArray_thenCorrect(InputStream initialStream) 
			  throws IOException {
			    //InputStream initialStream = new ByteArrayInputStream(new byte[] { 0, 1, 2 });
			 
			    byte[] targetArray = new byte[initialStream.available()];
			    initialStream.read(targetArray);
			    
			    return targetArray;
			}
	
	private <T> T convertirStringAObjeto(Class<T> entityClass, String columnaSQL, String aConvertir) {
		String statement = String.format("SELECT id FROM %s WHERE nombre = '%s'", columnaSQL, aConvertir);
		Long id = Long.valueOf(listToString(listAndCast(statement)));
		return entityManager.find(entityClass, id);
	}
	
	private Color hex2Rgb(String hex) {
		int r= Integer.valueOf(hex.substring(1,3),16);
		int g= Integer.valueOf(hex.substring(3,5),16);
	    int b= Integer.valueOf(hex.substring(5,7),16);
		return new Color(r,g,b);
	}

	//Para trabajar con eventos

	public String persistimeEsteEvento(String guardarropaNombre, String place, String description, String when, Request request) {
		LocalDate fecha = LocalDate.parse(when);
		String username = buscarUserNameConectado(request);
		Usuario usuarioLogueado = this.buscarUsuarioPorUsername(username);
		Guardarropa guardarropa = this.buscarGuardarropa(guardarropaNombre,username);
	
		Evento unEvento = new Evento(fecha, description, usuarioLogueado, place, guardarropa);

		repositorio.evento().persistir(unEvento);
		return unEvento.getID();
	}
	
	private Guardarropa buscarGuardarropa(String guardarropa, String userName){
		String statement = String.format("SELECT id FROM Usuario WHERE userName = '%s'", userName);
		Long id_user = Long.valueOf(listToString(listAndCast(statement)));
		
		String statement2 = String.format("SELECT id FROM Guardarropa WHERE usuario_id = '%s' and nombre = '%s'", id_user, guardarropa);
		Long id_guardarropa = Long.valueOf(listToString(listAndCast(statement2)));		

		Guardarropa guardarropa_final = entityManager.find(Guardarropa.class, id_guardarropa);
		String statement3 = String.format("SELECT p FROM prenda p WHERE p.guardarropa.id = '%s' ", id_guardarropa);

		List<Prenda> prendas = entityManager.createQuery(statement3, Prenda.class).getResultList();
		
		guardarropa_final.setPrendas(prendas);
		 
		return guardarropa_final;
	}
	
	 

	public List<Prenda> devolverUnaSugerenciaParaEvento(String eventoID, Request request) throws Exception {
        
		Evento evento = this.eventoID_A_Evento(eventoID);

        //System.out.println("Evento: "+evento);

		//List<String> lista = new ArrayList<>();
		Usuario usuarioLogueado = this.buscarUsuarioPorUsername(buscarUserNameConectado(request));
		List<Prenda> prendas = usuarioLogueado.pedirSugerencia2(evento);
		 
		/*for (Prenda prenda : prendas) {
			lista.add(prenda.getNombre()); 
		}
		return lista;*/
		return prendas;
	}
	
	public Evento eventoID_A_Evento(String eventoID) {	      
		return entityManager.find(Evento.class, Long.parseLong(eventoID));
	}
	
	/*public List<String> devolverUnaSugerenciaParaUltimoEvento(Request request) throws Exception {
		List<String> lista = new ArrayList<>();
		Usuario usuarioLogueado = this.buscarUsuarioPorUsername(buscarUserNameConectado(request));
		List<Prenda> prendas = usuarioLogueado.pedirSugerenciaUltimoEvento();
		 
		for (Prenda prenda : prendas) {
			lista.add(prenda.getNombre()); 
		}
		return lista;
	}*/
	
	
	public void aceptarSugencia(String eventoID, Request request) {
		Usuario usuarioLogueado = this.buscarUsuarioPorUsername(buscarUserNameConectado(request));
		Evento evento = this.eventoID_A_Evento(eventoID);
		evento.setSugerencia(new Sugerencia(usuarioLogueado.sugerenciaTemporal));
		repositorio.evento().actualizar(evento);
	}

	public void modificarPercepcion(String cabeza, String cuello, String torso, String manos, String piernas, String calzado, Request request) {
		Usuario usuarioLogueado = this.buscarUsuarioPorUsername(buscarUserNameConectado(request));
		usuarioLogueado.getPercepcion().modificarPercepcionCabeza(Integer.parseInt(cabeza));
		usuarioLogueado.getPercepcion().modificarPercepcionCuello(Integer.parseInt(cuello));	
		usuarioLogueado.getPercepcion().modificarPercepcionTorso(Integer.parseInt(torso));
		usuarioLogueado.getPercepcion().modificarPercepcionManos(Integer.parseInt(manos));
		usuarioLogueado.getPercepcion().modificarPercepcionPiernas(Integer.parseInt(piernas));
		usuarioLogueado.getPercepcion().modificarPercepcionCalzado(Integer.parseInt(calzado));
		repositorio.usuario().actualizar(usuarioLogueado);
	}
	
	
	public List<Evento> devolverTodosLosEventos(Request request) {
		String usuarioConectado = this.buscarUserNameConectado(request);
		String statement_userID = String.format("SELECT id FROM Usuario WHERE userName = '%s'", usuarioConectado);
		List<String> idDuenio = listAndCast(statement_userID);
		String statement_Eventos = "SELECT DISTINCT id FROM Evento WHERE usuario_id = "+ listToString(idDuenio);
		Query queryIDUsuario = entityManager.createQuery(statement_Eventos);
		List<Evento> list_event = new ArrayList<>(); 
		for (Object i : queryIDUsuario.getResultList() ) {
			list_event.add(entityManager.find(Evento.class, i)); 
		}
		return list_event;
	}
	
	
	public List<String> devolverTodasLosDetalles(String inputtedEvento) {
	    Query query1 = entityManager.createQuery(String.format("SELECT id FROM Evento e WHERE e.descripcion = '%s'",inputtedEvento));
	    String statement = ("SELECT fechaEvento, repeticion FROM Evento WHERE descripcion = " + query1.setMaxResults(1).getSingleResult());
		return this.listAndCast(statement);
	}

	public List<String> devolverTodasLasPrendasDeSugerencia(String idSugerencia) {
	    String statement = ("SELECT DISTINCT prenda.nombre FROM sugerencia s join s.prendas_de_sugerencia as prenda WHERE s.id = " + idSugerencia);
	    return listAndCast(statement);
	}
	
	public List<Prenda> devolverTodasLasPrendasDeSugerencia2(String idSugerencia) {
	    String statement = ("SELECT DISTINCT prenda.id FROM sugerencia s join s.prendas_de_sugerencia as prenda WHERE s.id = " + idSugerencia);
		Query queryIDUsuario = entityManager.createQuery(statement);
		List<Prenda> list_prenda = new ArrayList<>(); 
		for (Object i : queryIDUsuario.getResultList() ) {
			list_prenda.add(entityManager.find(Prenda.class, i)); 
		}
		return list_prenda;
	    
	    
	    
	    
	}

	public List<Prenda> devolverTodasLasPrendasDeGuardarropas(String inputtedGuardarropa) {
		Query idGuardarropas = entityManager.createQuery(String.format("SELECT id FROM Guardarropa g WHERE g.nombre = '%s'",inputtedGuardarropa));
	    String statement_Guardarropa = ("SELECT DISTINCT id FROM prenda WHERE guardarropa = " + idGuardarropas.setMaxResults(1).getSingleResult());
		Query queryIDUsuario = entityManager.createQuery(statement_Guardarropa);
		List<Prenda> list_prenda = new ArrayList<>(); 
		for (Object i : queryIDUsuario.getResultList() ) {
			list_prenda.add(entityManager.find(Prenda.class, i)); 
		}
		return list_prenda;
	}  
	

}
