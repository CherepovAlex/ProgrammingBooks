@import io.hexlet.dto.courses.BuildCoursePage
@import io.hexlet.util.NamedRoutes
@param BuildCoursePage page

@template.layout.page(
    content = @`
        @if(page.getErrors() != null && !page.getErrors().isEmpty())
            <div class="alert alert-danger">
                <ul>
                    @for(var entry : page.getErrors().entrySet())
                        @for(var error : entry.getValue())
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif
        <form action="${NamedRoutes.coursesPath()}" method="post">
          <div>
            <label>
              Название курса
              <input type="text" name="name" value="${page.getName()}" />
            </label>
          </div>
          <div>
            <label>
              Краткое описание курса
              <textarea name="description">${page.getDescription()}</textarea>
            </label>
          </div>
          <input type="submit" value="Опубликовать" />
        </form>
        `,
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 Course Manager | Создание курса</p>
        </div>
    `
)
