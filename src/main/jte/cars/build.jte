@import org.example.hexlet.dto.cars.BuildCarPage
@import org.example.hexlet.util.NamedRoutes

@param BuildCarPage page

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

    <form action="${NamedRoutes.carsPath()}" method="post">
        <div>
            <label>
                Название марки
                <input type="text" required name="make" value="${page.getMake()}">
            </label>
        </div>
        <div>
            <label>
                Название модели
                <input type="text" required name="model" value="${page.getModel()}">
            </label>
        </div>
        <input type="submit" value="Добавить машину">
    </form>
`)