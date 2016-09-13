import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teas", request.session().attribute("teas"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teas", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Tea> teas = request.session().attribute("teas");
      if(teas == null){
        teas = new ArrayList<Tea>();
        request.session().attribute("teas", teas);
      }
      String name = request.queryParams("name");
      String type = request.queryParams("type");
      int rating = Integer.parseInt(request.queryParams("rating"));
      String steep = request.queryParams("steep");

      Tea tea = new Tea(name, type, rating, steep);
      teas.add(tea);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
