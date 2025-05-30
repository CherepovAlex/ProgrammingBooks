@import io.hexlet.dto.cars.BuildCarPage
@param BuildCarPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <form action="/cars" method="post">
                <div class="mb-3">
                    <label class="form-label">
                        Make
                        <input type="text" class="form-control" name="make" value="${page.getMake()}" />
                    </label>
                </div>
                <div class="mb-3">
                    <label class="form-label">
                        Model
                        <input type="text" class="form-control" name="model" value="${page.getModel()}" />
                    </label>
                </div>
                <input type="submit" class="btn btn-primary" value="Save" />
            </form>
        </div>
    `,
)
