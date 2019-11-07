import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import componentes.Prenda;
import repositorio.Repositorio;
import spark.Request;

public class Fachada {

	private static final String PERSISTENCE_UNIT_NAME = "DDS";
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
        System.out.println("Inizializando la fachada...");
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		entityManager = emFactory.createEntityManager();
		repositorio = new Repositorio(entityManager);
        System.out.println("Ahora puede realizar consultas a la base de datos");
	}    

	public static void finalizar() {
		repositorio.cerrar();
		emFactory.close();
	}	

	
    boolean removeSessionAttrLoggedOut(Request _request) {
        Object loggedOut = _request.session().attribute("loggedOut");
        _request.session().removeAttribute("loggedOut");
        return loggedOut != null;
    }

    public static String removeSessionAttrLoginRedirect(Request _request) {
        String loginRedirect = _request.session().attribute("loginRedirect");
        _request.session().removeAttribute("loginRedirect");
        return loginRedirect;
    }

	public List<String> devolverTodosLosGuardarropas() {
	    Query query = entityManager.createQuery("SELECT DISTINCT Nombre FROM Guardarropa");
		List<String> list = query.getResultList();
		return list;
	}
	
	public List<String> devolverTodosLosTipoDePrendas() {
	    Query query = entityManager.createQuery("SELECT DISTINCT nombre FROM TipoDePrenda");
		List<String> list = query.getResultList();
		return list;
	}
	public List<String> devolverTodosLosMateriales() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> devolverTodosLasTramas() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> devolverTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
	public void registrarUsuarioCon(String inputtedEmail, String inputtedUsername, String inputtedPassword) {
		// TODO Auto-generated method stub
		
	}
	public void chequearSiExiste(String inputtedUsername, String inputtedPassword) {
		//Nota: inputtedUsername es un campo donde el usuario puede elegir loguearse con mail o nombreDeUsuario 
		// => Puede ser cualquiera de los dos
		// TODO Auto-generated method stub
	}
	public List<String> devolverTodosLosNombresDeGuardarropas() {
		// TODO Auto-generated method stub
		return null;
	}
	public void persistimeEsta(String nombre, String tipoDePrenda, String material, String r, String g, String b,
			String trama) {
		
		//Prenda unaRemeraBlancaLisa = new Prenda("Remera Blanca lisa", remera, algodon, colorBlanco, lisa );
		// TODO Auto-generated method stub
		
	}
	public void persistimeEsteEvento(String usuario, String guardarropa, String place, String description,
			String when) {
		// TODO Auto-generated method stub
		
	}
	public List<String> devolverUnaSugerenciaParaUltimoEvento() {
		 List<String> lista = new ArrayList<>(); 
		 lista.add("Remera Roja a lunares"); 
		 lista.add("Pantalon Negro"); 
		 lista.add("Zapatillas Converse"); 		
	return lista;
	}
	
	public List<String> devolverTodasLasPrendas(String inputtedguardarropas) {		
	    Query query1 = entityManager.createQuery("SELECT id FROM Guardarropa WHERE Nombre = '"+inputtedguardarropas+"'");	    
	    Query query2 = entityManager.createQuery("SELECT DISTINCT nombre FROM prenda WHERE guardarropa = '"+query1.setMaxResults(1).getSingleResult() +"'" );
		List<String> list = query2.getResultList();
		return list;
	}	
	
}
