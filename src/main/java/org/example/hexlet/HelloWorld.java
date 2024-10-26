package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
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

        app.get("/courses/build", ctx -> {
            BuildCoursePage page = new BuildCoursePage();
            ctx.render("courses/build.jte", model("page", page));
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

        app.get("/users", ctx -> {
            String term = ctx.queryParam("term");
            List<User> users = UserRepository.search(term);
            UsersPage page = new UsersPage(users, term);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get("/users/build", ctx -> {
            BuildUserPage page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            String term = ctx.queryParam("term");
            long id = ctx.pathParamAsClass("id", Long.class).get();
            User user = UserRepository.find(id).orElse(null);

            if (user == null) {
                throw new NotFoundResponse("Курс не найден");
            }

            UserPage page = new UserPage(user, term);
            ctx.render("users/show.jte", model("page", page));
        });

        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello " + name + "!");
        });

        app.post("/users", ctx -> {
            String name = capitalize(ctx.formParam("name").trim());
            String email = ctx.formParam("email").trim().toLowerCase();

            try {
                String passwordConfirmation = ctx.formParam("passwordConfirmation");
                String password = ctx.formParamAsClass("password", String.class)
                        .check(v -> v.equals(passwordConfirmation), "Пароли не совпадают!")
                        .check(v -> v.length() > 6, "Недостаточная длина пароля!")
                        .get();

                User user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect("/users");
            } catch (ValidationException e) {
                BuildUserPage page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", model("page", page));
            }

        });

        app.post("/courses", ctx -> {
            String name = ctx.formParam("name").trim();
            String description = ctx.formParam("description").trim();

            try {
                name = ctx.formParamAsClass("name", String.class)
                        .check(v -> v.length() > 3, "Короткое название")
                        .get();
                description = ctx.formParamAsClass("description", String.class)
                        .check(v -> v.length() > 10, "Короткое описание")
                        .get();

                Course course = new Course(name, description);
                CourseRepository.save(course);
                ctx.redirect("/courses");
            } catch (ValidationException e) {
                BuildCoursePage page = new BuildCoursePage(capitalize(name), description, e.getErrors());
                ctx.render("courses/build.jte", model("page", page));
            }
        });

        app.start(7070);
    }
}
