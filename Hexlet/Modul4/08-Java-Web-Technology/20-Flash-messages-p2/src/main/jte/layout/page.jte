@import io.hexlet.util.NamedRoutes
@import io.hexlet.dto.BasePage
@import gg.jte.Content
@param Content content
@param Content footer
@param BasePage page = null

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>User Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
  </head>
  <body>
    @if(page != null && page.getFlash() != null)
      <div class="alert alert-${page.getFlashType() != null ? page.getFlashType() : "success"}">
        ${page.getFlash()}
      </div>
    @endif
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">
        <a class="navbar-brand" href="${NamedRoutes.homePath()}">На главную</a>
      </div>
    </nav>
    <main class="container mt-4">
      ${content}
    </main>
    <footer class="mt-5">
      ${footer}
    </footer>
  </body>
</html>
