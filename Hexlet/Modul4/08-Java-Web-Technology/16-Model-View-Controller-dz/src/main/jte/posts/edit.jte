@import io.hexlet.dto.posts.EditPostPage
@import io.hexlet.util.NamedRoutes
@param EditPostPage page

@template.layout.page(
    content = @`
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1>Редактирование поста</h1>
            <a href="${NamedRoutes.postsPath()}" class="btn btn-secondary">Назад к списку</a>
        </div>
        @if(page.getErrors() != null)
            <div class="mb-3">
                <ul>
                    @for(var validator : page.getErrors().values())
                        @for(var error : validator)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif
        <form action="${NamedRoutes.postPath(page.getPost().getId())}" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Наименование</label>
                <input type="text"
                    class="form-control"
                    id="name"
                    name="name"
                    value="${page.getName()}"
                    required>
            </div>

            <div class="mb-3">
                <label for="body" class="form-label">Описание</label>
                <textarea
                    class="form-control"
                    id="body"
                    name="body"
                    required>${page.getBody()}</textarea>
            </div>

            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button type="submit" class="btn btn-primary me-md-2">Сохранить изменения</button>
                <a href="${NamedRoutes.postsPath()}" class="btn btn-outline-secondary">Отмена</a>
            </div>
        </form>
    `
)