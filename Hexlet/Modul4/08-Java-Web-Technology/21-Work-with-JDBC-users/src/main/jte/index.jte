@import io.hexlet.dto.users.MainPage
@import io.hexlet.util.NamedRoutes
@param MainPage page

@template.layout.page(
    content = @`
        @if(page.getCurrentUser() != null)
            Welcome, ${page.getCurrentUser()}.
            <div>
                <a href="${NamedRoutes.usersPath()}">Go to Users</a>
            </div>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="hidden" name="_method" value="DELETE">
                <button type="submit">Log out</button>
            </form>
            If you want to logout, delete cookie JSESSIONID from browser or button Log Out.
        @else
            <a href="${NamedRoutes.buildSessionPath()}">Log in</a>
        @endif
    `,
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 User Manager</p>
        </div>
    `
)
