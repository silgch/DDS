import org.apache.velocity.app.*;
import org.eclipse.jetty.http.*;
import spark.*;
import java.util.*;

public class ViewUtil {

    // Renders a template given a model and a request
    // and see if a user is logged in
    public static String render(Request request, Map<String, Object> model, String path) {
        model.put("currentUser", request.session().attribute("user"));
        return strictVelocityEngine().render(new ModelAndView(model, path));
    }
    
    //not sure how this is used 
    private static VelocityTemplateEngine strictVelocityEngine() {
        VelocityEngine configuredEngine = new VelocityEngine();
        configuredEngine.setProperty("runtime.references.strict", true);
        configuredEngine.setProperty("resource.loader", "class");
        configuredEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return new VelocityTemplateEngine(configuredEngine);
    }

    public static Route notFound = (Request request, Response response) -> {
        response.status(HttpStatus.NOT_FOUND_404);
        return render(request, new HashMap<>(), "templates/notFound.vm");
    };


}
