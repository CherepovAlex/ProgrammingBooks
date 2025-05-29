@import io.hexlet.dto.users.LoginPage
@import io.hexlet.util.NamedRoutes
@param LoginPage page

@template.layout.page(
    content = @`
        @if(page.getError() != "")
            <div class="mb-3">
                ${page.getError()}
            </div>
        @endif
        <div class="mx-auto p-4 py-md-5">
            <form action="${NamedRoutes.sessionsPath()}" method="post">
                <div class="mb-3">
                    <label class="form-label">
                    name
                    <input type="text" class="form-control" name="name" value="${page.getName()}" />
                    </label>
                </div>
                <div class="mb-3">
                    <label class="form-label">
                    password
                    <input type="password" class="form-control" name="password" />
                    </label>
                </div>
                <input type="submit" class="btn btn-primary" value="Enter" />
            </form>
        </div>
    `,
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 User Manager | Login Page</p>
        </div>
    `,
    page = null
)
