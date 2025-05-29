@import io.hexlet.dto.users.UserPage
@import io.hexlet.NamedRoutes
@import java.time.format.DateTimeFormatter
@param UserPage page

@template.layout.page(
    content = @`
        <h1>Данные пользователя</h1>
            <div>
                <a href="${NamedRoutes.editUserPath(page.getUser().getId())}" class="btn btn-warning">Редактировать</a>
                <a href="${NamedRoutes.usersPath()}" class="btn btn-secondary">Назад к списку</a>
            </div>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${page.getUser().getName()}</h5>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><strong>ID:</strong> ${page.getUser().getId()}</li>
                        <li class="list-group-item"><strong>Email:</strong> ${page.getUser().getEmail()}</li>
                        <li class="list-group-item"><strong>Дата создания:</strong> ${page.getUser().getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE)}</li>
                    </ul>
            </div>
            <div class="card-footer">
                    <form action="${NamedRoutes.deleteUserPath(page.getUser().getId())}" method="post">
                        <button type="submit" class="btn btn-danger">Удалить пользователя</button>
                    </form>
            </div>
    `,
        footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 User Manager | Users Page</p>
        </div>
    `
)