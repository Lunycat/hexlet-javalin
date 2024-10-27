package org.example.hexlet.controller;

import io.javalin.http.Context;

import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;
import static org.apache.commons.lang3.StringUtils.capitalize;

public class UserController {

    public static void index(Context ctx) {
        String term = ctx.queryParam("term");
        List<User> users = UserRepository.search(term);
        UsersPage page = new UsersPage(users, term);
        ctx.render("users/index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        BuildUserPage page = new BuildUserPage();
        ctx.render("users/build.jte", model("page", page));
    }

    public static void show(Context ctx) {
        String term = ctx.queryParam("term");
        long id = ctx.pathParamAsClass("id", Long.class).get();
        User user = UserRepository.find(id).orElse(null);

        if (user == null) {
            throw new NotFoundResponse("Курс не найден");
        }

        UserPage page = new UserPage(user, term);
        ctx.render("users/show.jte", model("page", page));
    }

    public static void create(Context ctx) {
        try {
            String name = capitalize(ctx.formParam("name").trim());
            String email = ctx.formParam("email").trim().toLowerCase();
            String passwordConfirmation = ctx.formParam("passwordConfirmation");
            String password = ctx.formParamAsClass("password", String.class)
                    .check(v -> v.equals(passwordConfirmation), "Пароли не совпадают!")
                    .check(v -> v.length() > 6, "Недостаточная длина пароля!")
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
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new UserPage(user, null);
        ctx.render("users/edit.jte", model("page", page));
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }
}