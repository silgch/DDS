import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	public String[] devolverTodasLasPrendas() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] devolverTodosLosGuardarropas() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] devolverTodosLosTipoDePrendas() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] devolverTodosLosMateriales() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] devolverTodosLasTramas() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] devolverTodosLosUsuarios() {
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
}
