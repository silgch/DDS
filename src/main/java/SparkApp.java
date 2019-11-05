import static app.util.RequestUtil.getQueryLoginRedirect;
import static app.util.RequestUtil.getQueryPassword;
import static app.util.RequestUtil.getQueryUsername;

import java.util.HashMap;
import java.util.Map;

import app.user.UserController;
import app.util.ViewUtil;
import spark.template.velocity.VelocityTemplateEngine;
import spark.*;

import java.nio.file.Path;
import java.util.*;
import app.book.*;
import app.index.*;
import app.login.*;
import app.user.*;
import app.util.*;
import static spark.Spark.*;


public class SparkApp {

  public static void main(String[] args) throws Exception {
    staticFileLocation("/public");
    staticFiles.expireTime(600L);
    //Fachada fachada = new Fachada(); 
    
    
    get("/", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/home.vtl")
        );
    });
    
    get("/guardarropas", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        /* getAllFromDB() threw NullPointerException*/
        //model.put("guardarropas", fachada.getAllFromDB());
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/guardarropas.vtl")
        );
    });
    
    get("/register", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/register.vtl")
        );
    });
    
    post("/register",(request, response) -> {
    	System.out.println("poo");  
    	
       Map<String, Object> model = new HashMap<>();
        String inputtedUsername = request.queryParams("user");
        request.session().attribute("user", inputtedUsername);
        model.put("user", inputtedUsername);  
        String inputtedPassword = request.queryParams("pass");
        request.session().attribute("pass", inputtedPassword);
        model.put("pass", inputtedPassword); 
        
        System.out.println(inputtedUsername + inputtedPassword); 
        
        /* acá estarían las funciones para agregar el usuario si no existe */
        
          return ViewUtil.render(request, model, "templates/register");
    });
    
    
    get("/login",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/login.vtl")
        );
    });    
    
    post("/login",(request, response) -> {
    	System.out.println("poo");  
    	
       Map<String, Object> model = new HashMap<>();
        String inputtedUsername = request.queryParams("user");
        request.session().attribute("user", inputtedUsername);
        model.put("user", inputtedUsername);  
        String inputtedPassword = request.queryParams("pass");
        request.session().attribute("pass", inputtedPassword);
        model.put("pass", inputtedPassword); 
        
        System.out.println(inputtedUsername + inputtedPassword); 
        
        /* acá estarían las funciones para ver si existe el usuario y contraseña en la base de datos */
        
          return ViewUtil.render(request, model, "templates/login");
    });
    
    get("/calendar",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/calendar.vtl")                     
        );

    });
    
    get("/new-prenda",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        String[] tipoDePrendas = {}; /*agregar tipoDePrendas, somehow */
        String[] materialesDeTipoDePrenda = {}; /*agregar materialesDeTipoDePrenda, somehow */
        String[] tramas = {}; /*agregar tramas, somehow */
        model.put("tipoDePrendas", tipoDePrendas);
        model.put("materialesDeTipoDePrenda", materialesDeTipoDePrenda);
        model.put("tramas", tramas);        
        
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/new_prenda.vtl")                     
        );
    });
    
    get("/new-event",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        String[] usuarios = {}; /*agregar usuarios, somehow */
        model.put("users", usuarios);
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/new_event.vtl")                     
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