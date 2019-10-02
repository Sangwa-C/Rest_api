import spark.template.handlebars.HandlebarsTemplateEngine;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import exceptions.ApiException;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "home.hbs");
        },new HandlebarsTemplateEngine());

        get("/dep_form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "dep_form.hbs");
        },new HandlebarsTemplateEngine());

        post("/dep_list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String dname = request.queryParams("dname");
            String ddescription = request.queryParams("ddescription");
            int nemployees = Integer.parseInt(request.queryParams("nemployees"));

            Departments newDepartments= new Departments(dname,ddescription,nemployees);

            model.put("dname", dname);
            model.put("ddescription", ddescription);
            model.put("nemployees", nemployees);

            newDepartments.save();
            response.redirect("/dep_list");
            return new ModelAndView(model, "dep_list.hbs");
        }, new HandlebarsTemplateEngine());


        get("/dep_list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Departments> department = Departments.getThemAll();
            model.put("department", department);
            return new ModelAndView(model, "dep_list.hbs");
        },new HandlebarsTemplateEngine());

        get("/News_form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "News_form.hbs");
        },new HandlebarsTemplateEngine());

        post("/news_list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String header = request.queryParams("header");
            String content = request.queryParams("content");
            String author = request.queryParams("author");

            News newNews= new News(header,content, author);

            model.put("header", header);
            model.put("content", content);
            model.put("author", author);

            newNews.save();
            return new ModelAndView(model, "news_list.hbs");
        }, new HandlebarsTemplateEngine());

        get("/news_list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<News> news = News.getThemAll();
            model.put("news", news);
            return new ModelAndView(model, "news_list.hbs");
        },new HandlebarsTemplateEngine());



        get("/Users_form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Users> users = Users.getThemAll();
            model.put("Users", users);
            return new ModelAndView(model, "Users_form.hbs");
        },new HandlebarsTemplateEngine());

        get("/Users_list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Users> users = Users.getThemAll();
            model.put("Users", users);
            return new ModelAndView(model, "Users_list.hbs");
        },new HandlebarsTemplateEngine());


        post("/Users_form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            String title = request.queryParams("title");
            String duty = request.queryParams("duty");

            Users newUser= new Users(name,title, duty);

            model.put("name", name);
            model.put("title", title);
            model.put("duty", duty);

            newUser.save();
            return new ModelAndView(model, "Users_form.hbs");
        }, new HandlebarsTemplateEngine());



    }
}
