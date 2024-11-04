@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.util.NamedRoutes

@param UserPage page

@template.layout.page(content = @`
    <p>${page.getUser().getId()}</p>
    <p>${page.getUser().getName()}</p>
    <p>${page.getUser().getEmail()}</p>

    <a href="${NamedRoutes.usersPath()}" class="btn btn-primary" role="button" data-bs-toggle="button">Назад</a>
`)
