@import io.hexlet.dto.courses.CoursePage
@import io.hexlet.NamedRoutes
@param CoursePage page

@template.layout.page(
    content = @`
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1>Редактирование курса</h1>
            <a href="${NamedRoutes.coursePath(page.getCourse().getId())}" class="btn btn-secondary">Назад к курсу</a>
        </div>

        <form action="${NamedRoutes.updateCoursePath(page.getCourse().getId())}" method="post">
            <input type="hidden" name="_method" value="patch">

            <div class="mb-3">
                <label for="name" class="form-label">Имя</label>
                <input type="text"
                       class="form-control"
                       id="name"
                       name="name"
                       value="${page.getCourse().getName()}"
                       required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Описание</label>
                <textarea
                    class="form-control"
                    id="description"
                    name="description"
                    required>${page.getCourse().getDescription()}</textarea>
            </div>

            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button type="submit" class="btn btn-primary me-md-2">Сохранить изменения</button>
                <a href="${NamedRoutes.coursePath(page.getCourse().getId())}" class="btn btn-outline-secondary">Отмена</a>
            </div>
        </form>
    `,
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 Course Manager | Редактирование курса</p>
        </div>
    `
)