@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(content = @`
    <form action="/users" method="get">
        <label>
            Поиск:
            <input type="search" required name="term" value="${page.getTerm()}">
        </label>
        <input type="submit" value="Искать">
    </form>

    <h1>Пользователи</h1>

    @for(var user : page.getUsers())
        <div>
            <p><a href="/users/${user.getId()}">${user.getName()} ${user.getEmail()}</a></p>
        </div>
    @endfor
`)
