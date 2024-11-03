@import org.example.hexlet.dto.users.EditUserPage
@import org.example.hexlet.util.NamedRoutes

@param EditUserPage page

@template.layout.page(content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="${NamedRoutes.userPath(page.getUser().getId())}" method="post">
        <div>
            <label>
                Имя
                <input type="text" required name="name" value="${page.getUser().getName()}"/>
            </label>
        </div>
        <div>
            <label>
                Email
                <input type="email" required name="email" value="${page.getUser().getEmail()}"/>
            </label>
        </div>
        <div>
            <label>
                Пароль
                <input type="password" required name="password"/>
            </label>
        </div>
        <input type="submit" value="Сохранить изменения"/>
    </form>
`)