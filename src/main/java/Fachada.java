import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import componentes.Color;
import componentes.Prenda;
import eventos.Evento;
import repositorio.Repositorio;
import spark.*;
import usuario.Usuario;

public class Fachada {
	//La base de datos se llama "ati1txh3yqvapdna" ya que asi viene por defecto la que nos da JawsDB Maria
	private static final String PERSISTENCE_UNIT_NAME = "ati1txh3yqvapdna";
	private static EntityManagerFactory emFactory;	
	private static Repositorio repositorio;	
	private static EntityManager entityManager;
	//private Usuario usuarioLogueado = new Usuario();	
	//public String usarnameLoggedIn = ""; // current logged in username

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
	
    /*boolean removeSessionAttrLoggedOut(Request _request) {
        Object loggedOut = _request.session().attribute("loggedOut");
        _request.session().removeAttribute("loggedOut");
        return loggedOut != null;
    }

    public static String removeSessionAttrLoginRedirect(Request _request) {
        String loginRedirect = _request.session().attribute("loginRedirect");
        _request.session().removeAttribute("loginRedirect");
        return loginRedirect;
    }*/
	
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
		Query query = entityManager.createQuery("SELECT p FROM Usuario p WHERE nombre= '"+userName+"' ", Usuario.class);
		return (Usuario) query.getResultList().get(0);
	}
	
	public void registrarUsuarioCon(String inputtedFirstName, String inputtedLastName, String inputtedEmail, 
			String inputtedUsername, String inputtedPassword){
		
		if (usuarioExiste(inputtedUsername)) {
			// No permitir registrar
		}

		/*else {		
			try{					
				Query resultado=  entityManager.createQuery("SELECT p FROM Usuario p WHERE userName = '"+ inputtedUsername+"' ");
				if(resultado.getResultList().size()>0){						
					usuarioLogueado = entityManager.createQuery("SELECT p FROM Usuario p WHERE userName = '"+ inputtedUsername+"' ",
					usuario.Usuario.class).getResultList().get(0);
				}						
			}
						
		catch(ArrayIndexOutOfBoundsException excepcion)
	    {
	        // ???
	    }*/		
	
		//Query query = entityManager.createQuery("SELECT p FROM Usuario p WHERE  nombre= '"+inputtedUsername+"' ", Usuario.class);
		//usuarioLogueado = (Usuario) query.getResultList().get(0);
		
		Usuario unUsuario = new Usuario(inputtedUsername);
		unUsuario.setNombre(inputtedFirstName);
		unUsuario.setApellido(inputtedLastName);
		unUsuario.setMail(inputtedEmail);
		unUsuario.setPassword(inputtedPassword);			
		repositorio.usuario().persistir(unUsuario);	
	}
	
	//Si existe, usarnameLoggedIn = inputtedUsername
	public boolean chequearSiExiste(String inputtedUsername, String inputtedPassword) {	
		Usuario usuarioBuscado = repositorio.usuario().buscarPorUsuarioContrasenia(inputtedUsername, inputtedPassword);
		return (usuarioBuscado != null);					
	}
	
	public boolean usuarioExiste(String inputtedUsername) {
		Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE nombre= '"+ inputtedUsername+"'  ");
		List<String> list = query.getResultList();
		return ( list.size()>0);
	}		
 
	public List<String> devolverTodosLosGuardarropas(Request request) {
		String usuarioConectado = this.buscarUserNameConectado(request);
		Query queryIDUsuario = entityManager.createQuery("SELECT id FROM Usuario WHERE userName = '" + usuarioConectado +"'  ");
		List<String> idDuenio = queryIDUsuario.getResultList();
	    Query queryGuardarropas = entityManager.createQuery("SELECT DISTINCT Nombre FROM Guardarropa WHERE usuario_id = '" + idDuenio.toString().substring(1, 4) +"'  ");
	    List<String> list = queryGuardarropas.getResultList();
		return list;
	}
	
	public List<String> devolverTodasLasPrendas(String inputtedguardarropas) {		
	    Query query1 = entityManager.createQuery(
	            "SELECT id FROM Guardarropa g WHERE g.Nombre = :custName")
	            .setParameter("custName", inputtedguardarropas);
	    Query query2 = entityManager.createQuery("SELECT DISTINCT nombre FROM prenda WHERE guardarropa = '"+query1.setMaxResults(1).getSingleResult() +"'" );
		List<String> list = query2.getResultList();
		return list;
	}
	
	public List<String> devolverTodosLosTipoDePrendas() {
	    Query query = entityManager.createQuery("SELECT DISTINCT nombre FROM TipoDePrenda");
		List<String> list = query.getResultList();
		return list;
	}
	
	public List<String> devolverTodosLosMateriales() {
	    Query query = entityManager.createQuery("SELECT DISTINCT nombre FROM Material");
		List<String> list = query.getResultList();
		return list;
	}
	
	public List<String> devolverTodosLasTramas() {
	    Query query = entityManager.createQuery("SELECT DISTINCT nombre FROM trama");
		List<String> list = query.getResultList();
		return list;
	}
	
	public List<String> devolverTodosLosUsuarios() {
	    Query query = entityManager.createQuery("SELECT DISTINT nombre FROM usuario");
		List<String> list = query.getResultList();
		return list;
	}

	public void persistimeEstaPrenda(String nombre, String tipoDePrenda, String material, String colorHEX,	String trama, String guardarropa) {		

		//convertimos strings a objetos	
		componentes.TipoDePrenda unTipo= repositorio.tipo().buscarTipoDePrendaPorNombre(tipoDePrenda);
		Color unColor = this.hex2Rgb(colorHEX);
		componentes.Material unMaterial= repositorio.material().buscarMaterialPorNombre(material);
		componentes.Trama unaTrama= repositorio.trama().buscarTramaPorNombre(trama);
		Prenda unaPrenda = new Prenda(nombre, unTipo, unMaterial, unColor, unaTrama );		
        System.out.println(unaPrenda);				
		repositorio.prenda().persistir(unaPrenda);		
	}
	
	private Color hex2Rgb(String hex) {
		int r= Integer.valueOf(hex.substring(1,3),16);
		int g= Integer.valueOf(hex.substring(3,5),16);
	    int b= Integer.valueOf(hex.substring(5,7),16);
		return new Color(r,g,b);
	}

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

	public void modificarPercepcion(String percepcionCabeza, String percepcionCuello, String percepcionTorso,
			String percepcionManos, String percepcionPiernas, String percepcionCalzado,Request request) 
	{
		Usuario usuarioLogueado = this.buscarUsuarioPorUsername(buscarUserNameConectado(request));
		usuarioLogueado.getPercepcion().modificarPercepcionCabeza(Integer.parseInt(percepcionCabeza));
		usuarioLogueado.getPercepcion().modificarPercepcionCuello(Integer.parseInt(percepcionCuello));	
		usuarioLogueado.getPercepcion().modificarPercepcionTorso(Integer.parseInt(percepcionTorso));
		usuarioLogueado.getPercepcion().modificarPercepcionManos(Integer.parseInt(percepcionManos));
		usuarioLogueado.getPercepcion().modificarPercepcionPiernas(Integer.parseInt(percepcionPiernas));
		usuarioLogueado.getPercepcion().modificarPercepcionCalzado(Integer.parseInt(percepcionCalzado));
		repositorio.usuario().actualizar(usuarioLogueado);
	}
	
	public List<String> devolverTodosLosEventos() {
		Query query = entityManager.createQuery("SELECT DISTINCT descripcion FROM Evento");
	    List<String> list = query.getResultList();
		return list;
	}
	
	public List<String> devolverTodasLosDetalles(String inputtedEvento) {
	    Query query1 = entityManager.createQuery(
	            "SELECT id FROM Evento e WHERE e.descripcion = :custName")
	            .setParameter("custName", inputtedEvento);
	    Query query2 = entityManager.createQuery("SELECT fechaEvento, repeticion FROM Evento WHERE descripcion = '"+query1.setMaxResults(1).getSingleResult() +"'" );
		List<String> list = query2.getResultList();
		return list;
	}

}
