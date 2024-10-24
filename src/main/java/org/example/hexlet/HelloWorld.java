package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

import java.util.ArrayList;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {

    private static final List<Course> COURSES = new ArrayList<>(List.of(
            new Course(1, "Java", "Programming on Java"),
            new Course(2, "PHP", "Программирование на PHP"),
            new Course(3, "C++", "Программирование на C++")));

    private static final List<User> USERS = new ArrayList<>(List.of(
            new User(1, "4el1235", "evdeev@mail.ru"),
            new User(2, "egor", "egor242@mail.ru"),
            new User(3, "Valentin", "sigmaboy@gmail.ru")
    ));

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
            List<Course> courses;

            if (term != null) {
                courses = COURSES.stream()
                        .filter(c -> c.getDescription().toLowerCase().contains(term.toLowerCase()))
                        .toList();
            } else {
                courses = COURSES;
            }

            CoursesPage page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            int id = ctx.pathParamAsClass("id", Integer.class).get();
            Course course = COURSES.stream()
                    .filter(c -> id == c.getId())
                    .findFirst()
                    .orElse(null);

            if (course == null) {
                throw new NotFoundResponse("Курс не найден");
            }

            CoursePage page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            int id = ctx.pathParamAsClass("id", Integer.class).get();
            User user = USERS.stream()
                    .filter(u -> id == u.getId())
                    .findFirst()
                    .orElse(null);

            if (user == null) {
                throw new NotFoundResponse("Пользователь не найден");
            }

            String html =
                    "<h1>" + user.getId() + "</h1>" +
                    "<p>" + user.getUsername() + "</p>";

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
