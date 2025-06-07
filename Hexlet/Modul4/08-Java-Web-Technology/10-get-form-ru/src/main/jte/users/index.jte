@import io.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <h1>Пользователи</h1>
        <form action="/users">
            <input type="search" placeholder="Search" aria-label="Search" aria-describedby="search-addon" name="term" value="${page.getTerm()}" />
            <input type="submit" value="Search">
        </form>
        <table>
            @for(var user : page.getUsers())
                <tr>
                    <td>
                        ${user.getId()}
                    </td>
                    <td>
                        ${user.getFirstName()}
                    </td>
                    <td>
                        ${user.getLastName()}
                    </td>
                </tr>
            @endfor
        </table>
    `
)