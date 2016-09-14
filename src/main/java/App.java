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

    // get("/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   ArrayList<Tea> teas = request.session().attribute("teas");
    //   if(teas != null){
    //     Collections.sort(teas, new Comparator<Tea>() {
    //         @Override
    //         public int compare(Tea tea1, Tea tea2) {
    //             return tea1.getName().compareTo(tea2.getName());
    //         }
    //     });
    //   }
    //   model.put("teas", teas);
    //   model.put("template", "templates/index.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    get("/", (request, response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // post("/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   ArrayList<Tea> teas = request.session().attribute("teas");
    //   String sortby = request.queryParams("sortby");
    //   if(teas != null){
    //     if(sortby.equals("name")){
    //       Collections.sort(teas, new Comparator<Tea>() {
    //           @Override
    //           public int compare(Tea tea1, Tea tea2) {
    //               return tea1.getName().compareTo(tea2.getName());
    //           }
    //       });
    //     } else {
    //       Collections.sort(teas, new Comparator<Tea>() {
    //           @Override
    //           public int compare(Tea tea1, Tea tea2) {
    //               return tea1.getRating().compareTo(tea2.getRating());
    //           }
    //       });
    //     }
    //   }
    //   model.put("teas", teas);
    //   model.put("template", "templates/index.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    post("/teas", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      Type type = Type.find(Integer.parseInt(request.queryParams("typeId")));

      String name = request.queryParams("name");
      Integer rating = Integer.parseInt(request.queryParams("rating"));
      String steep = request.queryParams("steep");
      Tea tea = new Tea(name, rating, steep);

      type.addTea(tea);
      String categoryLink = "/types/" + type.getId();
      model.put("categoryLink", categoryLink);
      model.put("type", type);
      model.put("template", "templates/type-teas-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/types/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/type-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/types", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Type newType = new Type(name);
      model.put("template", "templates/type-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/types", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("types", Type.all());
      model.put("template", "templates/types.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/types/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Type type = Type.find(Integer.parseInt(request.params(":id")));
      model.put("type", type);
      model.put("template", "templates/type.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("types/:id/teas/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Type type = Type.find(Integer.parseInt(request.params(":id")));
      model.put("type", type);
      model.put("template", "templates/type-teas-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/types/:typeId/teas/:teaId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Tea tea = Tea.find(Integer.parseInt(request.params(":teaId")));
      Type type = Type.find(Integer.parseInt(request.params(":typeId")));
      model.put("tea", tea);
      model.put("type", type);
      model.put("template", "templates/tea.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
