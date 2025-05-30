@import io.hexlet.dto.cars.CarPage
@import io.hexlet.util.NamedRoutes
@param CarPage page

@template.layout.page(

    content = @`
        <div class="mb-3">
            <h1>${page.getCar().getMake()}</h1>
        </div>

        <div class="mb-3">
            ${page.getCar().getModel()}
        </div>
    `,
)
