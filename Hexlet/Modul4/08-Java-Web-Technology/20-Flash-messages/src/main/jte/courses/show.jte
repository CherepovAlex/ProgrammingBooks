@import io.hexlet.dto.courses.CoursePage
@import io.hexlet.NamedRoutes
@import java.time.format.DateTimeFormatter
@param CoursePage page

@template.layout.page(
    content = @`
        <h1>Данные курса</h1>
            <div>
                <a href="${NamedRoutes.editCoursePath(page.getCourse().getId())}" class="btn btn-warning">Редактировать</a>
                <a href="${NamedRoutes.coursesPath()}" class="btn btn-secondary">Назад к списку</a>
            </div>
            <div class="col-lg-8 mx-auto p-4 py-md-5">
                <main>
                    <h1>${page.getCourse().getName()}</h1>
                    <p>${page.getCourse().getDescription()}</p>
                    <p><a href="${NamedRoutes.coursesPath()}">К списку курсов</a></p>
                    <p><a href="${NamedRoutes.homePath()}">На главную</a></p>
                </main>
            </div>
            <div class="card-footer">
                    <form action="${NamedRoutes.deleteCoursePath(page.getCourse().getId())}" method="post">
                        <button type="submit" class="btn btn-danger">Удалить курс</button>
                    </form>
            </div>
    `,
        footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 Course Manager | Просмотр курса</p>
        </div>
    `
)
