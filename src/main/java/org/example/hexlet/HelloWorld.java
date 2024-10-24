package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import java.util.ArrayList;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {

    private static final List<Course> COURSES = new ArrayList<>(List.of(
            new Course(1, "Java", "Programming on Java"),
            new Course(2, "PHP", "Программирование на PHP"),
            new Course(3, "C++", "Программирование на C++")));

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/courses", ctx -> {
            String header = "Курсы по программированию";
            CoursesPage page = new CoursesPage(COURSES, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            int id = ctx.pathParamAsClass("id", Integer.class).get();
            Course course = COURSES.stream()
                    .filter((c) -> id == c.getId())
                    .findFirst()
                    .orElse(null);
            if (course == null) {
                throw new NotFoundResponse("Курс не найден");
            }
            CoursePage page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });


        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello " + name + "!");
        });

        app.start(7070);
    }
}
