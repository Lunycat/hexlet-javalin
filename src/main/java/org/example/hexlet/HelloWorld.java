package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {

    static {
        CourseRepository.save(new Course("Java", "Programming on Java"));
        CourseRepository.save(new Course("PHP", "Программирование на PHP"));
        CourseRepository.save(new Course( "C++", "Программирование на C++"));

        UserRepository.save(new User("4el1235", "evdeev@mail.ru", "dsadsad"));
        UserRepository.save(new User("egor", "egor242@mail.ru", "dasdsa"));
        UserRepository.save(new User("Valentin", "sigmaboy@gmail.ru", "hghgfbdvxc"));
    }


    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/courses", ctx -> {
            String term = ctx.queryParam("term");
            String header = "Курсы по программированию";
            List<Course> courses = CourseRepository.search(term);
            CoursesPage page = new CoursesPage(courses, header, term);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            String term = ctx.queryParam("term");
            long id = ctx.pathParamAsClass("id", Long.class).get();
            Course course = CourseRepository.find(id).orElse(null);

            if (course == null) {
                throw new NotFoundResponse("Курс не найден");
            }

            CoursePage page = new CoursePage(course, term);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            long id = ctx.pathParamAsClass("id", Long.class).get();
            User user = UserRepository.find(id).orElse(null);

            if (user == null) {
                throw new NotFoundResponse("Пользователь не найден");
            }

            String html =
                    "<h1>" + user.getId() + "</h1>" +
                    "<p>" + user.getName() + "</p>";

            PolicyFactory policy = new HtmlPolicyBuilder()
                    .allowElements("a")
                    .allowUrlProtocols("https")
                    .allowAttributes("href").onElements("a")
                    .requireRelNofollowOnLinks()
                    .toFactory();

            String safeHtml = policy.sanitize(html);
            ctx.contentType("text/html");
            ctx.result(safeHtml);
        });

        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello " + name + "!");
        });

        app.start(7070);
    }
}
