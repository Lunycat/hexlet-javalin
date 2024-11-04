@import org.example.hexlet.dto.cars.CarsPage
@import org.example.hexlet.util.NamedRoutes

@param CarsPage page

@template.layout.page(content = @`
    <form action="${NamedRoutes.carsPath()}" method="get">
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
    <h1>Машины</h1>

    @for(var car : page.getCars())
        <div>
            <p><a href="${NamedRoutes.carPath(car.getId())}">${car.getMake()}</a></p>
            <p>${car.getModel()}</p>
        </div>
    @endfor

    <a href="${NamedRoutes.buildCarPath()}" class="btn btn-primary" role="button" data-bs-toggle="button">Добавить машину</a>
`)
