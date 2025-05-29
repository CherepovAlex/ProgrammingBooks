@import io.hexlet.dto.MainPage
@import io.hexlet.util.NamedRoutes
@param MainPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            @if(page.getName() != null)
                <div class="mb-3">
                    Привет, ${page.getName()}!
                </div>
                <form action="${NamedRoutes.logoutPath()}" method="post">
                    <input type="submit" class="btn btn-primary" value="Выйти" />
                </form>
            @else
                <div>
                    <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
                </div>
            @endif
        </div>
        `
)
