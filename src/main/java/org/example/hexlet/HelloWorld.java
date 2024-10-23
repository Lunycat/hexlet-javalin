package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import java.util.ArrayList;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/courses/{id}", ctx -> {
            int id = ctx.pathParamAsClass("id", Integer.class).get();
            List<Course> courses = new ArrayList<>(List.of(
                    new Course("Java", "Programming on Java"),
                    new Course("PHP", "Программирование на PHP"),
                    new Course("C++", "Программирование на C++")));
            String header = "Курсы по программированию";
            CoursesPage page = new CoursesPage(courses, header);
            ctx.render("courses/show.jte", model("page", page, "id", id));
        });
        
        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello " + name + "!");
        });

        app.start(7070);
    }
}
