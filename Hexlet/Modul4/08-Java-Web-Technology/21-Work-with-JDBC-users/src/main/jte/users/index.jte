@import io.hexlet.dto.users.UsersPage
@import io.hexlet.util.NamedRoutes
@import java.time.format.DateTimeFormatter
@param UsersPage page

@template.layout.page(
    content = @`
        @if(page.getCurrentUser() != null)
            <h1>Welcome, ${page.getCurrentUser()}</h1>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" value="Logout">
            </form>
        @endif

        @if(page.getFlash() != null)
            <div class="alert alert-${page.getFlashType() != null ? page.getFlashType() : "success"}">
                ${page.getFlash()}
            </div>
        @endif

        <h1>Users</h1>
        <a href="${NamedRoutes.buildUserPath()}">Add User</a>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Created At</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                @for(var user : page.getUsers())
                    <tr>
                        <td>${user.getId()}</td>
                        <td>${user.getName()}</td>
                        <td>${user.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE)}</td>
                        <td>
                            <a href="${NamedRoutes.userPath(user.getId())}">View</a>
                            <a href="${NamedRoutes.editUserPath(user.getId())}">Edit</a>
                            <form action="${NamedRoutes.deleteUserPath(user.getId())}" method="post" style="display:inline;">
                                <input type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                @endfor
            </tbody>
        </table>
    `,
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 User Manager</p>
        </div>
    `
)