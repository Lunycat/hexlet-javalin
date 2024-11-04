@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.util.NamedRoutes

@param CoursePage page

@template.layout.page(content = @`
    <p>${page.getCourse().getId()}</p>
    <p>${page.getCourse().getName()}</p>
    <p>${page.getCourse().getDescription()}</p>

    <a href="${NamedRoutes.coursesPath()}" class="btn btn-primary" role="button" data-bs-toggle="button">Назад</a>
`)
