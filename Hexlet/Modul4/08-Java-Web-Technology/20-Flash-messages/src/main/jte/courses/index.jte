@import io.hexlet.util.NamedRoutes
@import io.hexlet.dto.courses.CoursesPage
@import java.time.format.DateTimeFormatter
@param CoursesPage page

@template.layout.page(
    page = page,
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <h1>Все курсы</h1>
                <div class="mb-3">
                    <a href="${NamedRoutes.buildCoursesPath()}">Создать новый курс</a>
                </div>
                @if(page.getCourses().isEmpty())
                 <p>Пока не добавлено ни одного курса</p>
                    @else
                         @for(var course : page.getCourses())
                            <tr>
                                <div>
                                    <td><h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2></td>
                                    <td><p>${course.getDescription()}</p></td>
                                    <td>
                                        <a href="${NamedRoutes.coursePath(course.getId())}">Просмотр</a>
                                        <a href="${NamedRoutes.editCoursePath(course.getId())}">Редактировать</a>
                                        <form action="${NamedRoutes.deleteCoursePath(course.getId())}" method="post">
                                            <button type="submit">Удалить</button>
                                        </form>
                                    </td>
                                </div>
                            </tr>
                        @endfor
                @endif
            </main>
        </div>
    `,
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 Course Manager | Список курсов</p>
        </div>
    `
)