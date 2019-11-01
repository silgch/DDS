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

  public static void main(String[] args) {
    staticFileLocation("/public");
    staticFiles.expireTime(600L);

    
    get("/home", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/home.vtl")
        );
    });
    
    get("/images", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/images.vtl")
        );
    });
    
    /*get("/login", (request, response) -> {
        return new ModelAndView(new HashMap(), "templates/login.vtl");
      }, new VelocityTemplateEngine());*/
    
    get("/register", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        return new VelocityTemplateEngine().render(
            new ModelAndView(model, "templates/register.vtl")
        );
    });
    
    get("/login",(request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("user", request.session().attribute("user"));
        return ViewUtil.render(request, model, "templates/login.vtl");
    });    
    
    post("/login",(request, response) -> {
    	System.out.println("poo");  
    	
        Map<String, Object> model = new HashMap<>();
        String inputtedUsername = request.queryParams("user");
        request.session().attribute("user", inputtedUsername);
        model.put("user", inputtedUsername);  
        
        /* acá estarían las funciones para ver si existe el usuario y contraseña en la base de datos */
        
          return ViewUtil.render(request, model, "templates/login");
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