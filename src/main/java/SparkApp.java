import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class SparkApp {

    public static void main(String[] args) throws Exception {
        staticFileLocation("/public");
        Fachada fachada = Fachada.getInstance();    
        port(getHerokuAssignedPort());        

        get("/", (request, response) -> {            
            System.out.println(fachada.buscarUserNameConectado(request));
            fachada.chequearQueHayaAlguienConectado(request, response);           
            Map<String, Object> model = new HashMap<>();
            return ViewUtil.render(request, model, "templates/home.html");
        });
        
        get("/home", (request, response) -> {            
            System.out.println(fachada.buscarUserNameConectado(request));
            fachada.chequearQueHayaAlguienConectado(request, response);           
            Map<String, Object> model = new HashMap<>();
            return ViewUtil.render(request, model, "templates/home.html");
        });   
        
        get("/register", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return ViewUtil.render(request, model, "templates/register.html");
        });
        
        post("/register",(request, response) -> {   	
            Map<String, Object> model = new HashMap<>();
            String inputtedFirstName = request.queryParams("first_name");
            String inputtedLastName = request.queryParams("last_name");
            String inputtedUsername = request.queryParams("user");
            String inputtedEmail = request.queryParams("email");
            String inputtedPassword = request.queryParams("pass");
            
            if (fachada.usuarioExiste(inputtedUsername)) {
            	model.put("registrationFailed", true);
            	return ViewUtil.render(request, model, "templates/register.html");
    		}
            request.session().attribute("user", inputtedUsername);
            model.put("user", inputtedUsername);            
            //System.out.println(inputtedUsername + inputtedPassword);         
            fachada.registrarUsuarioCon(inputtedFirstName,inputtedLastName,inputtedEmail,inputtedUsername,inputtedPassword);
            return ViewUtil.render(request, model, "templates/home.html");
        });            
        
        get("/login",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("loggedOut", ViewUtil.removeSessionAttrLoggedOut(request));
            model.put("loginRedirect", ViewUtil.removeSessionAttrLoginRedirect(request));
            return ViewUtil.render(request, model, "templates/login.html");
        });    
        
        post("/login",(request, response) -> {        	
            Map<String, Object> model = new HashMap<>();
            String inputtedUsername = request.queryParams("user");
            String inputtedPassword = request.queryParams("pass");                        
            //System.out.println("User: "+inputtedUsername + " Pass: "+inputtedPassword);           
            boolean existe = fachada.chequearSiExiste(inputtedUsername,inputtedPassword);
            if(!existe) {            	
            	model.put("authenticationFailed", true);
            	return ViewUtil.render(request, model, "templates/login.html");
            }                       
            model.put("authenticationSucceeded", true);
            request.session().attribute("user", inputtedUsername);

            if (request.queryParams("loginRedirect") != null) {
                response.redirect(request.queryParams("loginRedirect"));
            }
            return ViewUtil.render(request, model, "templates/home.html");
        });
        
        post("/logout",(request, response) -> {
            request.session().removeAttribute("user");
            request.session().attribute("loggedOut", true);
            response.redirect("/login");
            return null;
        }); 
        
        put("/detallesEventos", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return ViewUtil.render(request, model, "templates/detallesEventos.html");
        });       
        
        get("/guardarropas", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> guardarropas = fachada.devolverTodosLosGuardarropas(request);
            model.put("guardarropas", guardarropas);
            return ViewUtil.render(request, model, "templates/guardarropas.html");
        });
        
        post("/guardarropas", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String inputtedguardarropa = request.queryParams("guardarropa");
            request.session().attribute("guardarropa", inputtedguardarropa); 
            
            List<String> prendas = fachada.devolverTodasLasPrendas(inputtedguardarropa);
           
            model.put("guardarropa", inputtedguardarropa);
            model.put("prendas", prendas);            

            return ViewUtil.render(request, model, "templates/prendas.html");
        });
        
        get("/new-prenda",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> tipoDePrendas = fachada.devolverTodosLosTipoDePrendas();
            List<String> materiales = fachada.devolverTodosLosMateriales(); 
            List<String> tramas = fachada.devolverTodosLasTramas(); 
            List<String> guardarropas = fachada.devolverTodosLosGuardarropas(request); 
            model.put("tipoDePrendas", tipoDePrendas);
            model.put("materiales", materiales);
            model.put("tramas", tramas);
            model.put("guardarropas", guardarropas);  

            return ViewUtil.render(request, model, "templates/new_prenda.html");
        });
        
        post("/new-prenda",(request, response) -> {  	
            Map<String, Object> model = new HashMap<>();
            String nombre = request.queryParams("nombre");
            String tipoDePrenda = request.queryParams("tipoDePrenda");
            String material = request.queryParams("material");
            String colorHEX = request.queryParams("colorHEX");
            String trama = request.queryParams("trama");
            String guardarropa = request.queryParams("guardarropa");
            request.session().attribute("nombre", nombre);
            request.session().attribute("tipoDePrenda", tipoDePrenda);
            request.session().attribute("material", material);
            request.session().attribute("colorHEX", colorHEX);
            request.session().attribute("trama", trama);
            request.session().attribute("guardarropa", guardarropa);
            
            fachada.persistimeEstaPrenda(nombre,tipoDePrenda,material,colorHEX,trama,guardarropa);            

            return ViewUtil.render(request, model, "templates/new_prenda.html");
        });        
        
        get("/new-event",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> guardarropas = fachada.devolverTodosLosGuardarropas(request);
            model.put("guardarropas", guardarropas);
            return ViewUtil.render(request, model, "templates/new_event.html");

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
            fachada.persistimeEsteEvento(guardarropa,place,description,when,request);            

            return ViewUtil.render(request, model, "templates/sugerencia.html");
        }); 
        
        get("/sugerencia",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> sugerencia = fachada.devolverUnaSugerenciaParaUltimoEvento();
            model.put("sugerencia", sugerencia);

            return ViewUtil.render(request, model, "templates/sugerencia.html");
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
            fachada.modificarPercepcion(percepcionCabeza,percepcionCuello,percepcionTorso,percepcionManos,percepcionPiernas,percepcionCalzado,request);
            return ViewUtil.render(request, model, "templates/sugerencia.html");
        });
        
        
       /* get("/calendar",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Query ids = (Query) fachada.todosLosIDSDeEventos();
            model.put("ids", ids); 

            return ViewUtil.render(request, model, "templates/calendar.html");

        }); */
        
        get("/calendar", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> eventos = fachada.devolverTodosLosEventos();
            model.put("eventos", eventos);

            return ViewUtil.render(request, model, "templates/calendar.html");            
        });
        
        post("/calendar", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String inputtedEvento = request.queryParams("evento");
            request.session().attribute("evento", inputtedEvento); 
            
            List<String> detalles = fachada.devolverTodasLosDetalles(inputtedEvento);
           
            model.put("evento", inputtedEvento);
            model.put("detalles", detalles);            

            return ViewUtil.render(request, model, "templates/detallesEventos.html");
        });
        
        get("*",ViewUtil.notFound);
    
    }
    
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;   
  
    } 
  
}  