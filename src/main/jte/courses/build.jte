@import org.example.hexlet.dto.courses.BuildCoursePage
@import org.example.hexlet.util.NamedRoutes

@param BuildCoursePage page

@template.layout.page(content = @`
    @if(page.getFlash() != null)
        <div class="alert alert-danger" role="alert">
            ${page.getFlash()}
        </div>
    @endif

    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="${NamedRoutes.coursesPath()}" method="post">
        <div>
            <label>
                Название курса
                <input type="text" required name="name" value="${page.getName()}">
            </label>
        </div>
        <div>
            <label>
                Описание курса
                <input type="text" required name="description" value="${page.getDescription()}">
            </label>
        </div>
        <input type="submit" value="Добавить курс">
    </form>
`)