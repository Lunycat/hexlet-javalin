@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <p>${page.getUser().getId()}</p>
    <p>${page.getUser().getName()}</p>
    <p>${page.getUser().getEmail()}</p>
    <p><a href="/users">Вернуться</a></p>
`)
