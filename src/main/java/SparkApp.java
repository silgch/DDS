import java.util.HashMap;
import java.util.List;
import java.util.Map;


import eventos.Evento;

import static spark.Spark.*;

public class SparkApp {

    public static void main(String[] args) throws Exception {
        staticFileLocation("/public");
        Fachada fachada = Fachada.getInstance();    
        port(getHerokuAssignedPort());        

        get("/", (request, response) -> {
            fachada.chequearQueHayaAlguienConectado(request, response);           
            Map<String, Object> model = new HashMap<>();
            return ViewUtil.render(request, model, "templates/home.vm");
        });
        
        get("/home", (request, response) -> {            
            //System.out.println(fachada.buscarUserNameConectado(request));
            fachada.chequearQueHayaAlguienConectado(request, response);           
            Map<String, Object> model = new HashMap<>();
            return ViewUtil.render(request, model, "templates/home.vm");
        });   
        
        get("/register", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return ViewUtil.render(request, model, "templates/register.vm");
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
            	return ViewUtil.render(request, model, "templates/register.vm");
    		}
            request.session().attribute("user", inputtedUsername);
            model.put("user", inputtedUsername);        
            fachada.registrarUsuarioCon(inputtedFirstName,inputtedLastName,inputtedEmail,inputtedUsername,inputtedPassword);
            return ViewUtil.render(request, model, "templates/home.vm");
        });            
        
        get("/login",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("loggedOut", ViewUtil.removeSessionAttrLoggedOut(request));
            model.put("loginRedirect", ViewUtil.removeSessionAttrLoginRedirect(request));
            return ViewUtil.render(request, model, "templates/login.vm");
        });    
        
        post("/login",(request, response) -> {        	
            Map<String, Object> model = new HashMap<>();
            String inputtedUsername = request.queryParams("user");
            String inputtedPassword = request.queryParams("pass");                        
            //System.out.println("User: "+inputtedUsername + " Pass: "+inputtedPassword);           
            boolean existe = fachada.chequearSiExiste(inputtedUsername,inputtedPassword);
            if(!existe) {            	
            	model.put("authenticationFailed", true);
            	return ViewUtil.render(request, model, "templates/login.vm");
            }                       
            model.put("authenticationSucceeded", true);
            request.session().attribute("user", inputtedUsername);

            if (request.queryParams("loginRedirect") != null) {
                response.redirect(request.queryParams("loginRedirect"));
            }
            return ViewUtil.render(request, model, "templates/home.vm");
        });
        
        post("/logout",(request, response) -> {
            request.session().removeAttribute("user");
            request.session().attribute("loggedOut", true);
            response.redirect("/login");
            return null;
        }); 
        
        put("/detallesEventos", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return ViewUtil.render(request, model, "templates/detallesEventos.vm");
        });       
        
        get("/guardarropas", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> guardarropas = fachada.devolverTodosLosGuardarropas(request);
            guardarropas.add("[Crear Nuevo Guardarropas]");
            model.put("guardarropas", guardarropas);
            return ViewUtil.render(request, model, "templates/guardarropas.vm");
        });
        
        post("/guardarropas", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String inputtedguardarropa = request.queryParams("guardarropa");
            if(inputtedguardarropa.equals("[Crear Nuevo Guardarropas]")){
            	fachada.crearGuardarropasAlPibe(request);
            	response.redirect("/guardarropas");
                return null;
            }
            request.session().attribute("guardarropa", inputtedguardarropa);            
            List<String> prendas = fachada.devolverTodasLasPrendas(inputtedguardarropa);           
            model.put("guardarropa", inputtedguardarropa);
            model.put("prendas", prendas);
            return ViewUtil.render(request, model, "templates/prendas.vm");
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

            return ViewUtil.render(request, model, "templates/new_prenda.vm");
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

            return ViewUtil.render(request, model, "templates/home.vm");
        });        
        
        get("/new-event",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> guardarropas = fachada.devolverTodosLosGuardarropas(request);
            model.put("guardarropas", guardarropas);
            return ViewUtil.render(request, model, "templates/new_event.vm");

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
            String eventoID = fachada.persistimeEsteEvento(guardarropa,place,description,when,request); 
            
            request.session().attribute("eventoID", eventoID);
            
            List<String> sugerencia = fachada.devolverUnaSugerenciaParaEvento(eventoID, request);
            model.put("sugerencia", sugerencia);
            
            return ViewUtil.render(request, model, "templates/sugerencia.vm");
        }); 
        
        get("/sugerencia",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String eventoID = request.session().attribute("eventoID");
            
            if (eventoID==null)System.out.println("Alguien puede pensar en los niños??");

            List<String> sugerencia = fachada.devolverUnaSugerenciaParaEvento(eventoID, request);
            model.put("sugerencia", sugerencia);
            
            return ViewUtil.render(request, model, "templates/sugerencia.vm");
        });
        
        post("/sugerencia",(request, response) -> {  	
            Map<String, Object> model = new HashMap<>();
            
            String sugerenciaAceptada = request.queryParams("sugerenciaAceptada");      
            
            if(sugerenciaAceptada == "FALSE") {
            	response.redirect("/sugerencia");
                return null;
            }            
           
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
            
            String eventoID = request.session().attribute("eventoID");
            
            //System.out.println("eventoID:"+eventoID);
      
            fachada.aceptarSugencia(eventoID, request);
            fachada.modificarPercepcion(percepcionCabeza,percepcionCuello,percepcionTorso,percepcionManos,percepcionPiernas,percepcionCalzado,request);
            
            return ViewUtil.render(request, model, "templates/home.vm");
        });
  
        get("/calendar", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Iterable<Evento> eventos = fachada.devolverTodosLosEventos(request);
            model.put("eventos", eventos);
            return ViewUtil.render(request, model, "templates/calendar.vm");            
        });
        
        post("/calendar", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String idSugerencia = request.queryParams("sugerencia");
            request.session().attribute("sugerencia", idSugerencia);            
            List<String> prendas = fachada.devolverTodasLasPrendasDeSugerencia(idSugerencia);           
            model.put("guardarropa", "Sugerencia con ID: "+ idSugerencia);
            model.put("prendas", prendas); 
            return ViewUtil.render(request, model, "templates/prendas.vm");           

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