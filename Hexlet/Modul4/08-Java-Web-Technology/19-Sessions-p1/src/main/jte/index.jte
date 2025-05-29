@import io.hexlet.dto.MainPage
@import io.hexlet.NamedRoutes
@param MainPage page

<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hello World!</title>
    </head>
    <body>
        <main>
            <h1>Привет, Мир!</h1>
            @if(page.getCurrentUser() != null)
                Добро пожаловать, ${page.getCurrentUser()}.
                <form action="${NamedRoutes.sessionsPath()}" method="post">
                    <input type="hidden" name="_method" value="DELETE">
                    <button type="submit">Выйти</button>
                </form>
                Чтобы разлогиниться, удалите куку JSESSIONID из браузера или кнопка выйти.
            @else
                <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
            @endif
        </main>
    </body>
</html>