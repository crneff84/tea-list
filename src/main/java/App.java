import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Tea> teas = request.session().attribute("teas");
      if(teas != null){
        Collections.sort(teas, new Comparator<Tea>() {
            @Override
            public int compare(Tea tea1, Tea tea2) {
                return tea1.getName().compareTo(tea2.getName());
            }
        });
      }
      model.put("teas", teas);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Tea> teas = request.session().attribute("teas");
      String sortby = request.queryParams("sortby");
      if(teas != null){
        if(sortby.equals("name")){
          Collections.sort(teas, new Comparator<Tea>() {
              @Override
              public int compare(Tea tea1, Tea tea2) {
                  return tea1.getName().compareTo(tea2.getName());
              }
          });
        } else if(sortby.equals("type")){
          Collections.sort(teas, new Comparator<Tea>() {
              @Override
              public int compare(Tea tea1, Tea tea2) {
                  return tea1.getType().compareTo(tea2.getType());
              }
          });
        } else {
          Collections.sort(teas, new Comparator<Tea>() {
              @Override
              public int compare(Tea tea1, Tea tea2) {
                  return tea1.getRating().compareTo(tea2.getRating());
              }
          });
        }
      }
      model.put("teas", teas);
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
      Integer rating = Integer.parseInt(request.queryParams("rating"));
      String steep = request.queryParams("steep");

      Tea tea = new Tea(name, type, rating, steep);
      teas.add(tea);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
