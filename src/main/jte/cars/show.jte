@import org.example.hexlet.dto.cars.CarPage
@import org.example.hexlet.util.NamedRoutes

@param CarPage page

@template.layout.page(content = @`
    <p>${page.getCar().getId()}</p>
    <p>${page.getCar().getMake()}</p>
    <p>${page.getCar().getModel()}</p>

    <a href="${NamedRoutes.carsPath()}" class="btn btn-primary" role="button" data-bs-toggle="button">Назад</a>
`)
