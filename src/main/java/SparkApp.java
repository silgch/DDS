<<<<<<< Updated upstream
import java.util.ArrayList;
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
        port(getHerokuAssignedPort());
        

        get("/", (req, res) -> {
            String path;
            
            if(fachada.hayAlguienConectado()){
            	path = "templates/home.html";
            }else path = "templates/login.html";
            
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(
                new ModelAndView(model, path)
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
            String inputtedFirstName = request.queryParams("first_name");
            request.session().attribute("first_name", inputtedFirstName);
            model.put("first_name", inputtedFirstName);
            String inputtedLastName = request.queryParams("last_name");
            request.session().attribute("last_name", inputtedLastName);
            model.put("last_name", inputtedLastName);
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
            
            fachada.registrarUsuarioCon(inputtedFirstName,inputtedLastName,inputtedEmail,inputtedUsername,inputtedPassword);                

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
            
            boolean existe = fachada.chequearSiExiste(inputtedUsername,inputtedPassword);
            
            String path;
            
            if(existe){
            	path = "templates/home.html";
            }else path = "templates/login.html";
            
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, path)
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
            
            List<String> prendas = fachada.devolverTodasLasPrendas(inputtedguardarropa);
           // String duenio = fachada.devolverDuenioDeGuardarropa(inputtedguardarropa);	
            
            model.put("guardarropa", inputtedguardarropa);
            model.put("prendas", prendas);
            //model.put("duenio", duenio);
            
           // System.out.println("KKK" + duenio); 

            
            return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/prendas.html")
            );
        });

        
        get("/new-prenda",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> tipoDePrendas = fachada.devolverTodosLosTipoDePrendas();
            List<String> materiales = fachada.devolverTodosLosMateriales(); 
            List<String> tramas = fachada.devolverTodosLasTramas(); 
            List<String> guardarropas = fachada.devolverTodosLosGuardarropas(); 
            model.put("tipoDePrendas", tipoDePrendas);
            model.put("materiales", materiales);
            model.put("tramas", tramas);
            model.put("guardarropas", guardarropas);
            
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
            String guardarropa = request.queryParams("guardarropa");
            request.session().attribute("nombre", nombre);
            request.session().attribute("tipoDePrenda", tipoDePrenda);
            request.session().attribute("material", material);
            request.session().attribute("R", R);
            request.session().attribute("G", G);
            request.session().attribute("B", B);
            request.session().attribute("trama", trama);
            request.session().attribute("guardarropa", guardarropa);

            
            fachada.persistimeEstaPrenda(nombre,tipoDePrenda,material,R,G,B,trama);
            
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
            fachada.persistimeEsteEvento(guardarropa,place,description,when);
            
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
        
        post("/sugerencia",(request, response) -> {  	
            Map<String, Object> model = new HashMap<>();
            System.out.println("1 2 3 4 6");
            
            List<String> sugerencia = fachada.devolverUnaSugerenciaParaUltimoEvento();
            List<String> modificacion = new ArrayList<>();            
     
            for (int i = 0; i < sugerencia.size(); i++) {                
            	//request.session().attribute("quantity", modificacion);
            	modificacion.add(request.queryParams("quantity"));
            }
            
            System.out.println("Calificacion: " + modificacion);
            
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
        return 4567;   
  
    } 
  
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.Query;

import eventos.Evento;
import spark.template.velocity.VelocityTemplateEngine;
import spark.*;
import static spark.Spark.*;

public class SparkApp {

    public static void main(String[] args) throws Exception {
        staticFileLocation("/public");
        Fachada fachada = Fachada.getInstance();    
        port(getHerokuAssignedPort());
        

        get("/", (req, res) -> {
            String path;
            
            if(fachada.hayAlguienConectado()){
            	path = "templates/home.html";
            }else path = "templates/login.html";
            
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(
                new ModelAndView(model, path)
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
            String inputtedFirstName = request.queryParams("first_name");
            request.session().attribute("first_name", inputtedFirstName);
            model.put("first_name", inputtedFirstName);
            String inputtedLastName = request.queryParams("last_name");
            request.session().attribute("last_name", inputtedLastName);
            model.put("last_name", inputtedLastName);
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
            
            fachada.registrarUsuarioCon(inputtedFirstName,inputtedLastName,inputtedEmail,inputtedUsername,inputtedPassword);                

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
            
            boolean existe = fachada.chequearSiExiste(inputtedUsername,inputtedPassword);
            
            String path;
            
            if(existe){
            	path = "templates/home.html";
            }else path = "templates/login.html";
            
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, path)
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
            List<String> guardarropas = fachada.devolverTodosLosGuardarropas(); 
            model.put("tipoDePrendas", tipoDePrendas);
            model.put("materiales", materiales);
            model.put("tramas", tramas);
            model.put("guardarropas", guardarropas);
            
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
            String guardarropa = request.queryParams("guardarropa");
            request.session().attribute("nombre", nombre);
            request.session().attribute("tipoDePrenda", tipoDePrenda);
            request.session().attribute("material", material);
            request.session().attribute("R", R);
            request.session().attribute("G", G);
            request.session().attribute("B", B);
            request.session().attribute("trama", trama);
            request.session().attribute("guardarropa", guardarropa);

            
            fachada.persistimeEstaPrenda(nombre,tipoDePrenda,material,R,G,B,trama);
            
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, "templates/new-prenda.html")
            );
        }); 
        
        
        get("/new-event",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> guardarropas = fachada.devolverTodosLosGuardarropas();
            model.put("guardarropas", guardarropas);
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, "templates/new_event.html")                     
            );
        });
        
        post("/new-event",(request, response) -> { 	
            Map<String, Object> model = new HashMap<>();
            String guardarropa = request.queryParams("guardarropa");
            String place = request.queryParams("place");
            String description = request.queryParams("description");
            String when = request.queryParams("when");

            request.session().attribute("guardarropa", guardarropa);
            request.session().attribute("place", place);
            request.session().attribute("description", description);
            request.session().attribute("when", when);
            
            System.out.println(guardarropa+place+description+when);
            fachada.persistimeEsteEvento(guardarropa,place,description,when);
            
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
        
        post("/sugerencia",(request, response) -> {  	
            Map<String, Object> model = new HashMap<>();
            
            List<String> sugerencia = fachada.devolverUnaSugerenciaParaUltimoEvento();
     
            String percepcionCabeza = request.queryParams("percepcionCabeza");
            String percepcionCuello = request.queryParams("percepcionCuello");
            String percepcionTorso = request.queryParams("percepcionTorso");
            String percepcionManos = request.queryParams("percepcionManos");
            String percepcionPiernas = request.queryParams("percepcionPiernas");
            String percepcionCalzado = request.queryParams("percepcionCalzado");
            request.session().attribute("percepcionCabeza", percepcionCabeza);
            request.session().attribute("percepcionCuello", percepcionCuello);
            request.session().attribute("percepcionTorso", percepcionTorso);
            request.session().attribute("percepcionManos", percepcionManos);
            request.session().attribute("percepcionPiernas", percepcionPiernas);
            request.session().attribute("percepcionCalzado", percepcionCalzado);            
      
            fachada.aceptarSugencia(sugerencia);
            fachada.modificarPercepcion(percepcionCabeza,percepcionCuello,percepcionTorso,percepcionManos,percepcionPiernas,percepcionCalzado);
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, "templates/sugerencia.html")
            );
        });
        
        
       /* get("/calendar",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Query ids = (Query) fachada.todosLosIDSDeEventos();
            model.put("ids", ids); 

            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, "templates/calendar.html")                     
            );
        }); */
        
        get("/calendar", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> eventos = fachada.devolverTodosLosEventos();
            model.put("eventos", eventos);
            return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/calendar.html")
            );
        });
        
        post("/calendar", (request, res) -> {
            Map<String, Object> model = new HashMap<>();
            String inputtedEvento = request.queryParams("evento");
            request.session().attribute("evento", inputtedEvento); 
            
            List<String> detalles = fachada.devolverTodasLasPrendas(inputtedEvento);
           
            model.put("evento", inputtedEvento);
            model.put("detalles", detalles);
            
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
        return 4567;   
  
    } 
  
>>>>>>> Stashed changes
}  