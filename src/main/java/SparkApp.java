import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class SparkApp {

  public static void main(String[] args) {
    staticFileLocation("/public");

    get("/home", (request, response) -> {
      return new ModelAndView(new HashMap(), "templates/home.vtl");
    }, new VelocityTemplateEngine());

    get("/images", (request, response) -> {
      return new ModelAndView(new HashMap(), "templates/images.vtl");
    }, new VelocityTemplateEngine());
    
    get("/login", (request, response) -> {
        return new ModelAndView(new HashMap(), "templates/login.vtl");
      }, new VelocityTemplateEngine());
    
    get("/register", (request, response) -> {
        return new ModelAndView(new HashMap(), "templates/register.vtl");
      }, new VelocityTemplateEngine());
    

  }
}