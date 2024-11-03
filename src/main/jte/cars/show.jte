@import org.example.hexlet.dto.cars.CarPage
@param CarPage page

@template.layout.page(content = @`
    <p>${page.getCar().getId()}</p>
    <p>${page.getCar().getMake()}</p>
    <p>${page.getCar().getModel()}</p>
`)
