@import io.hexlet.util.NamedRoutes

@template.layout.page(
    content = @`
        <h1>Главная страница</h1>
        <div class="mx-auto p-4 py-md-5">
          <main>
                <a href="${NamedRoutes.coursesPath()}">Все курсы</a>
          </main>
        </div>
    `,
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 Course Manager | Управление курсами</p>
        </div>
    `
)