@import io.hexlet.dto.users.UserPage
@import io.hexlet.NamedRoutes
@param UserPage page

@template.layout.page(
    content = @`
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1>Редактирование пользователя</h1>
            <a href="${NamedRoutes.userPath(page.getUser().getId())}" class="btn btn-secondary">Назад к пользователю</a>
        </div>

        <form action="${NamedRoutes.updateUserPath(page.getUser().getId())}" method="post">
            <input type="hidden" name="_method" value="patch">

            <div class="mb-3">
                <label for="name" class="form-label">Имя</label>
                <input type="text"
                       class="form-control"
                       id="name"
                       name="name"
                       value="${page.getUser().getName()}"
                       required>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email"
                       class="form-control"
                       id="email"
                       name="email"
                       value="${page.getUser().getEmail()}"
                       required>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Новый пароль</label>
                <input type="password"
                       class="form-control"
                       id="password"
                       name="password">
                <div class="form-text">Оставьте пустым, если не хотите менять пароль</div>
            </div>

            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button type="submit" class="btn btn-primary me-md-2">Сохранить изменения</button>
                <a href="${NamedRoutes.userPath(page.getUser().getId())}" class="btn btn-outline-secondary">Отмена</a>
            </div>
        </form>
    `,
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 User Manager | Редактирование пользователя</p>
        </div>
    `
)