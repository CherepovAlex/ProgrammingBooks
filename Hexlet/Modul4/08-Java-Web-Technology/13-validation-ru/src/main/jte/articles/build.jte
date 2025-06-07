@import io.hexlet.dto.articles.BuildArticlePage
@param BuildArticlePage page

<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
    </head>
    <body>
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

        <div class="mx-auto p-4 py-md-5">
            <form action="/articles" method="post">
                <div class="mb-3">
                    <label class="form-label">
                        Title
                        <input type="text" class="form-control" name="title" value="${page.getTitle()}" />
                    </label>
                </div>
                <div class="mb-3">
                    <label class="form-label">Content</label>
                    <textarea class="form-control" rows="20" cols="70" type="text" name="content">${page.getContent()}</textarea>
                </div>
                <input type="submit" class="btn btn-primary" value="Submit" />
            </form>
        </div>
    </body>
</html>