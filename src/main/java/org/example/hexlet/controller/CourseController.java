package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;
import static org.apache.commons.lang3.StringUtils.capitalize;

public class CourseController {

    public static void index(Context ctx) {
        String term = ctx.queryParam("term");
        String header = "Курсы по программированию";
        List<Course> courses = CourseRepository.search(term);
        CoursesPage page = new CoursesPage(courses, header, term);
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        BuildCoursePage page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void show(Context ctx) {
        String term = ctx.queryParam("term");
        long id = ctx.pathParamAsClass("id", Long.class).get();
        Course course = CourseRepository.find(id).orElse(null);

        if (course == null) {
            throw new NotFoundResponse("Курс не найден");
        }

        CoursePage page = new CoursePage(course, term);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static void create(Context ctx) {
        try {
            String name = ctx.formParamAsClass("name", String.class)
                    .check(v -> v.length() > 3, "Короткое название")
                    .get();
            String description = ctx.formParamAsClass("description", String.class)
                    .check(v -> v.length() > 10, "Короткое описание")
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
    }
}