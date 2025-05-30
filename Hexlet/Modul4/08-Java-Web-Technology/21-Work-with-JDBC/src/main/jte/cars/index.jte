@import io.hexlet.dto.cars.CarsPage
@import io.hexlet.util.NamedRoutes
@param CarsPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <h1>All cars</h1>
                <div class="mb-3">
                    <a href="${NamedRoutes.buildCarPath()}">Create new car</a>
                </div>

                <table class="table table-striped">
                    @for(var car : page.getCars())
                        <tr>
                            <td>
                                ${car.getId()}
                            </td>
                            <td>
                                <a href="${NamedRoutes.carPath(car.getId())}">${car.getMake()}</a>
                            </td>
                            <td>
                                ${car.getModel()}
                            </td>
                        </tr>
                    @endfor
                </table>
            </main>
        </div>
    `
)
