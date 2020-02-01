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

	private Usuario buscarUsuarioPorUsername(String userName){
		String statement = String.format("SELECT id FROM Usuario WHERE userName = '%s'", userName);
		Long id = Long.valueOf(listToString(listAndCast(statement)));
        System.out.println("id: "+id);
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
		String statement_Guardarropas = "SELECT DISTINCT Nombre FROM Guardarropa WHERE usuario_id = "+ listToString(idDuenio);
	    return listAndCast(statement_Guardarropas);
	}	
	
	private List<String> listAndCast(String statement) {
	    Query queryIDUsuario = entityManager.createQuery(statement);
		@SuppressWarnings("unchecked")
		List<String> list = queryIDUsuario.getResultList();
	    return list;
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
	    Query idGuardarropas = entityManager.createQuery(String.format("SELECT id FROM Guardarropa g WHERE g.Nombre = '%s'",inputtedguardarropas));
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
	    String statement = (String.format("SELECT DISTINCT nombre FROM %s",columna));
		return listAndCast(statement);
	}

	public void persistimeEstaPrenda(String nombre, String tipoDePrenda, String material, String colorHEX,	String trama, String guardarropa) {
		//System.out.println("Guardarropas:" + guardarropa);
		//convertimos strings a objetos	
		TipoDePrenda unTipo= convertirStringAObjeto(TipoDePrenda.class, "TipoDePrenda", tipoDePrenda);
		Color unColor = this.hex2Rgb(colorHEX);
		Material unMaterial= convertirStringAObjeto(Material.class, "Material", material);
		Trama unaTrama= convertirStringAObjeto(Trama.class, "trama", trama);
		Prenda unaPrenda = new Prenda(nombre, unTipo, unMaterial, unColor, unaTrama );
		System.out.println(unaPrenda);
		Guardarropa unGuardarropa = convertirStringAObjeto(Guardarropa.class, "Guardarropa", guardarropa);
		//try {
			unGuardarropa.agregarAGuardarropas(unaPrenda);
			repositorio.prenda().persistir(unaPrenda);
		/*	
		} catch (Exception e) {
			System.out.println("LPQTP");
		}*/					
	}
	
	private <T> T convertirStringAObjeto(Class<T> entityClass, String columnaSQL, String aConvertir) {
		String statement = String.format("SELECT id FROM %s WHERE nombre = '%s'", columnaSQL, aConvertir);
		Long id = Long.valueOf(listToString(listAndCast(statement)));
        //System.out.println("id: "+id);
		return entityManager.find(entityClass, id);
	}
	
	private Color hex2Rgb(String hex) {
		int r= Integer.valueOf(hex.substring(1,3),16);
		int g= Integer.valueOf(hex.substring(3,5),16);
	    int b= Integer.valueOf(hex.substring(5,7),16);
		return new Color(r,g,b);
	}

	//Para trabajar con eventos

	public void persistimeEsteEvento( String guardarropa, String place, String description, String when, Request request) {
		LocalDate fecha = LocalDate.parse(when);		
		Usuario usuarioLogueado = this.buscarUsuarioPorUsername(buscarUserNameConectado(request));
		Evento unEvento = new Evento(fecha, description, usuarioLogueado, place);
		repositorio.evento().persistir(unEvento);		
	}

	public List<String> devolverUnaSugerenciaParaUltimoEvento() {
		 List<String> lista = new ArrayList<>(); 
		 // TODO Actualmente está super hardcodeado
		 lista.add("Remera Roja a lunares"); 
		 lista.add("Pantalon Negro"); 
		 lista.add("Zapatillas Converse");
		return lista;
	}
	
	public void aceptarSugencia(List<String> sugerencia) {
		//TODO		
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
	
	public List<String> devolverTodosLosEventos() {
		String statement = ("SELECT DISTINCT descripcion FROM Evento");
	    return this.listAndCast(statement);
	}
	
	public List<String> devolverTodasLosDetalles(String inputtedEvento) {
	    Query query1 = entityManager.createQuery(String.format("SELECT id FROM Evento e WHERE e.descripcion = '%s'",inputtedEvento));
	    String statement = ("SELECT fechaEvento, repeticion FROM Evento WHERE descripcion = " + query1.setMaxResults(1).getSingleResult());
		return this.listAndCast(statement);
	}

}
