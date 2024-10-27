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

public class App {

    static {
        CourseRepository.save(new Course("Java", "Programming on Java"));
        CourseRepository.save(new Course("PHP", "���������������� �� PHP"));
        CourseRepository.save(new Course( "C++", "���������������� �� C++"));

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

        app.get(NamedRoutes.coursesPath(), ctx -> {
            String term = ctx.queryParam("term");
            String header = "����� �� ����������������";
            List<Course> courses = CourseRepository.search(term);
            CoursesPage page = new CoursesPage(courses, header, term);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get(NamedRoutes.buildCoursePath(), ctx -> {
            BuildCoursePage page = new BuildCoursePage();
            ctx.render("courses/build.jte", model("page", page));
        });

        app.get(NamedRoutes.coursePath("{id}"), ctx -> {
            String term = ctx.queryParam("term");
            long id = ctx.pathParamAsClass("id", Long.class).get();
            Course course = CourseRepository.find(id).orElse(null);

            if (course == null) {
                throw new NotFoundResponse("���� �� ������");
            }

            CoursePage page = new CoursePage(course, term);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.get(NamedRoutes.usersPath(), ctx -> {
            String term = ctx.queryParam("term");
            List<User> users = UserRepository.search(term);
            UsersPage page = new UsersPage(users, term);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get(NamedRoutes.buildUserPath(), ctx -> {
            BuildUserPage page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        app.get(NamedRoutes.userPath("{id}"), ctx -> {
            String term = ctx.queryParam("term");
            long id = ctx.pathParamAsClass("id", Long.class).get();
            User user = UserRepository.find(id).orElse(null);

            if (user == null) {
                throw new NotFoundResponse("���� �� ������");
            }

            UserPage page = new UserPage(user, term);
            ctx.render("users/show.jte", model("page", page));
        });

        app.post(NamedRoutes.usersPath(), ctx -> {
            try {
                String name = capitalize(ctx.formParam("name").trim());
                String email = ctx.formParam("email").trim().toLowerCase();
                String passwordConfirmation = ctx.formParam("passwordConfirmation");
                String password = ctx.formParamAsClass("password", String.class)
                        .check(v -> v.equals(passwordConfirmation), "������ �� ���������!")
                        .check(v -> v.length() > 6, "������������� ����� ������!")
                        .get();

                User user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect(NamedRoutes.usersPath());

            } catch (ValidationException e) {
                String name = ctx.formParam("name");
                String email = ctx.formParam("email");
                BuildUserPage page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", model("page", page));
            }

        });

        app.post(NamedRoutes.coursesPath(), ctx -> {
            try {
                String name = ctx.formParamAsClass("name", String.class)
                        .check(v -> v.length() > 3, "�������� ��������")
                        .get();
                String description = ctx.formParamAsClass("description", String.class)
                        .check(v -> v.length() > 10, "�������� ��������")
                        .get();

                Course course = new Course(name, description);
                CourseRepository.save(course);
                ctx.redirect(NamedRoutes.coursesPath());
                
            } catch (ValidationException e) {
                String name = ctx.formParam("name");
                String description = ctx.formParam("description");
                BuildCoursePage page = new BuildCoursePage(capitalize(name), description, e.getErrors());
                ctx.render("courses/build.jte", model("page", page));
            }
        });

        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello " + name + "!");
        });

        app.start(7070);
    }
}
