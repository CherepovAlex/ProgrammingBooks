@import io.hexlet.dto.posts.PostPage
@import io.hexlet.util.NamedRoutes
@param PostPage page

@template.layout.page(

    content = @`
        <div class="mb-3">
            <h1>${page.getPost().getName()}</h1>
        </div>

        <div class="mb-3">
            ${page.getPost().getBody()}
        </div>
    `,
)
