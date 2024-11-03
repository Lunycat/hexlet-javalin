package org.example.hexlet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.controller.CarController;
import org.example.hexlet.repository.BaseRepository;
import org.example.hexlet.controller.CourseController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UserController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.NamedRoutes;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class App {

    private static Javalin getApp() throws SQLException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        InputStream url = App.class.getClassLoader().getResourceAsStream("schema.sql");
        String sql = new BufferedReader(new InputStreamReader(url))
                .lines()
                .collect(Collectors.joining("\n"));

        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }

        BaseRepository.dataSource = dataSource;

        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.render("index.jte", model("page", page));
        });

        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);

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

        app.get(NamedRoutes.carsPath(), CarController::index);
        app.get(NamedRoutes.buildCarPath(), CarController::build);
        app.get(NamedRoutes.carPath("{id}"), CarController::show);
        app.post(NamedRoutes.carsPath(), CarController::create);

        return app;
    }

    public static void main(String[] args) throws SQLException {
        Javalin app = getApp();
        app.start(7070);
    }
}
