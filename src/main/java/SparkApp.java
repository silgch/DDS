import java.util.HashMap;
import java.util.Map;
import spark.template.velocity.VelocityTemplateEngine;
import spark.*;
import static spark.Spark.*;


public class SparkApp {

  public static void main(String[] args) throws Exception {
    staticFileLocation("/public");
    Fachada fachada = Fachada.getInstance();    
    
    get("/", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/home.vtl")
        );
    });
    
    
    get("/register", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/register.vtl")
        );
    });
    
    post("/register",(request, response) -> {   	
    	Map<String, Object> model = new HashMap<>();
    	String inputtedUsername = request.queryParams("user");
    	request.session().attribute("user", inputtedUsername);
    	model.put("user", inputtedUsername);
    	String inputtedEmail = request.queryParams("email");
    	request.session().attribute("email", inputtedEmail);
    	model.put("email", inputtedEmail);  
    	String inputtedPassword = request.queryParams("pass");
    	request.session().attribute("pass", inputtedPassword);
    	model.put("pass", inputtedPassword); 
		
		System.out.println(inputtedUsername + inputtedPassword); 
        
        fachada.registrarUsuarioCon(inputtedEmail,inputtedUsername,inputtedPassword);
        
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/register.vtl")
        );
    });    
    
    
    get("/login",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/login.vtl")
        );
    });    
    
    post("/login",(request, response) -> {  	
    	Map<String, Object> model = new HashMap<>();
        String inputtedUsername = request.queryParams("user");
        request.session().attribute("user", inputtedUsername);
        model.put("user", inputtedUsername);  
        String inputtedPassword = request.queryParams("pass");
        request.session().attribute("pass", inputtedPassword);
        model.put("pass", inputtedPassword); 
        
        System.out.println(inputtedUsername + inputtedPassword); 
        
        /* acá estarían las funciones para ver si existe el usuario y contraseña en la base de datos */
        fachada.chequearSiExiste(inputtedUsername,inputtedPassword);
        
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/login.vtl")
        );
    }); 
    
    
    get("/guardarropas", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        String[] guardarropas = fachada.devolverTodosLosGuardarropas();
        model.put("guardarropas", guardarropas);
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/guardarropas.vtl")
        );
    });

    
    get("/new-prenda",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        String[] tipoDePrendas = fachada.devolverTodosLosTipoDePrendas();
        String[] materiales = fachada.devolverTodosLosMateriales(); 
        String[] tramas = fachada.devolverTodosLasTramas(); 
        model.put("tipoDePrendas", tipoDePrendas);
        model.put("materiales", materiales);
        model.put("tramas", tramas);        
        
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/new_prenda.vtl")                     
        );
    });
    
    
    get("/new-event",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        String[] usuarios = fachada.devolverTodosLosUsuarios();
        model.put("users", usuarios);
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/new_event.vtl")                     
        );
    });
    
    
    get("/calendar",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/calendar.vtl")                     
        );

    });    
    

    
    /*Fachada fachada = new Fachada();
    model.put("loggedOut", fachada.removeSessionAttrLoggedOut(request));
    model.put("loginRedirect", fachada.removeSessionAttrLoginRedirect(request));*/   
    
    
    /*     if (!UserController.authenticate(getQueryUsername(request), getQueryPassword(request))) {
            model.put("authenticationFailed", true);
            return ViewUtil.render(request, model, "/login");
        }
        model.put("authenticationSucceeded", true);
        request.session().attribute("currentUser", getQueryUsername(request));
        if (getQueryLoginRedirect(request) != null) {
            response.redirect(getQueryLoginRedirect(request));
        } */
    
    
    /*
    post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
   */ 
    

  }  
}