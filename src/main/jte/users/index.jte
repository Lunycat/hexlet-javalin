@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.util.NamedRoutes

@param UsersPage page

@template.layout.page(content = @`
    <form action="/users" method="get">
        <label>
            Поиск:
            <input type="search" name="term" value="${page.getTerm()}">
        </label>
        <input type="submit" value="Искать">
    </form>

    @if(page.getFlash() != null)
        <div class="alert alert-success" role="alert">
            ${page.getFlash()}
        </div>
    @endif
    <h1>Пользователи</h1>

    @for(var user : page.getUsers())
        <div>
            <p><a href="${NamedRoutes.userPath(user.getId())}">${user.getName()}_${user.getEmail()}</a></p>
        </div>
    @endfor
`)
