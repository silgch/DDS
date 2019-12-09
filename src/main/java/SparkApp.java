import java.util.HashMap;
import java.util.List;
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
            new ModelAndView(model, "templates/home.html")
        );
    });
    
    
    get("/register", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/register.html")
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
                new ModelAndView(model, "templates/register.html")
        );
    });    
    
    
    get("/login",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/login.html")
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
        
        System.out.println("User: "+inputtedUsername + " Pass: "+inputtedPassword); 
        
        fachada.chequearSiExiste(inputtedUsername,inputtedPassword);
        
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/login.html")
        );
    }); 
    
    
    get("/guardarropas", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        List<String> guardarropas = fachada.devolverTodosLosGuardarropas();
        model.put("guardarropas", guardarropas);
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/guardarropas.html")
        );
    });
    
    post("/guardarropas", (request, res) -> {
    	Map<String, Object> model = new HashMap<>();
    	String inputtedguardarropa = request.queryParams("guardarropa");
        request.session().attribute("guardarropa", inputtedguardarropa);
        model.put("guardarropa", inputtedguardarropa);     
        
        List<String> prendas = fachada.devolverTodasLasPrendas(inputtedguardarropa);
        
        model.put("guardarropa", inputtedguardarropa);
        model.put("prendas", prendas);
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/prendas.html")
        );
    });

    
    get("/new-prenda",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        List<String> tipoDePrendas = fachada.devolverTodosLosTipoDePrendas();
        List<String> materiales = fachada.devolverTodosLosMateriales(); 
        List<String> tramas = fachada.devolverTodosLasTramas(); 
        model.put("tipoDePrendas", tipoDePrendas);
        model.put("materiales", materiales);
        model.put("tramas", tramas);        
        
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/new_prenda.html")                     
        );
    });
    
    post("/new-prenda",(request, response) -> {  	
    	Map<String, Object> model = new HashMap<>();
    	String nombre = request.queryParams("nombre");
        String tipoDePrenda = request.queryParams("tipoDePrenda");
        String material = request.queryParams("material");
        String R = request.queryParams("R");
        String G = request.queryParams("G");
        String B = request.queryParams("B");
        String trama = request.queryParams("trama");
        request.session().attribute("nombre", nombre);
        request.session().attribute("tipoDePrenda", tipoDePrenda);
        request.session().attribute("material", material);
        request.session().attribute("R", R);
        request.session().attribute("G", G);
        request.session().attribute("B", B);
        request.session().attribute("trama", trama);
        
        fachada.persistimeEsta(nombre,tipoDePrenda,material,R,G,B,trama);
        
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/new-prenda.html")
        );
    }); 
    
    
    get("/new-event",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        List<String> usuarios = fachada.devolverTodosLosUsuarios();
        List<String> guardarropas = fachada.devolverTodosLosGuardarropas();
        model.put("users", usuarios);
        model.put("guardarropas", guardarropas);
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/new_event.html")                     
        );
    });
    
    post("/new-event",(request, response) -> {  	
    	Map<String, Object> model = new HashMap<>();
    	String usuario = request.queryParams("usuario");
        String guardarropa = request.queryParams("guardarropa");
        String place = request.queryParams("place");
        String description = request.queryParams("description");
        String when = request.queryParams("when");

        request.session().attribute("usuario", usuario);
        request.session().attribute("guardarropa", guardarropa);
        request.session().attribute("place", place);
        request.session().attribute("description", description);
        request.session().attribute("when", when);
        
        System.out.println(usuario+guardarropa+place+description+when);
        fachada.persistimeEsteEvento(usuario,guardarropa,place,description,when);
        
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/sugerencia.html")
        );
    }); 
    
    get("/sugerencia",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        List<String> sugerencia = fachada.devolverUnaSugerenciaParaUltimoEvento();
        model.put("sugerencia", sugerencia);
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/sugerencia.html")                     
        );
    });
    
    
    get("/calendar",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/calendar.html")                     
        );
    });
    
   }
  
  static int getHerokuAssignedPort() {
      ProcessBuilder processBuilder = new ProcessBuilder();
      if (processBuilder.environment().get("PORT") != null) {
          return Integer.parseInt(processBuilder.environment().get("PORT"));
      }
      return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
  }
  
  
}

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