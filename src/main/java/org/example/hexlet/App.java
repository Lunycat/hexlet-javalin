package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.controller.CourseController;
import org.example.hexlet.controller.UserController;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
import java.util.List;
import static io.javalin.rendering.template.TemplateUtil.model;
import static org.apache.commons.lang3.StringUtils.capitalize;

public class App {

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

        app.get("/", ctx -> ctx.render("layout/page.jte"));

        app.get(NamedRoutes.coursesPath(), CourseController::index);
        app.get(NamedRoutes.buildCoursePath(), CourseController::build);
        app.get(NamedRoutes.coursePath("{id}"), CourseController::show);
        app.post(NamedRoutes.coursesPath(), CourseController::create);

        app.get(NamedRoutes.usersPath(), UserController::index);
        app.get(NamedRoutes.buildUserPath(), UserController::build);
        app.get(NamedRoutes.userPath("{id}"), UserController::show);
        app.post(NamedRoutes.usersPath(), UserController::create);
        app.get(NamedRoutes.editUserPath("{id}"), UserController::edit);
        app.post(NamedRoutes.userPath("{id}"), UserController::update);

        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello " + name + "!");
        });

        app.start(7070);
    }
}
