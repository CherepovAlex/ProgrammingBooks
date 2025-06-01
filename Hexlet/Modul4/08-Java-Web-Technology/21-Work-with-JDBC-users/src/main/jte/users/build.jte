@import io.hexlet.dto.users.BuildUserPage
@import io.hexlet.util.NamedRoutes
@param BuildUserPage page

@template.layout.page(
    content = @`
        @if(page.getErrors() != null)
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif
        <form action="${NamedRoutes.usersPath()}" method="post">
          <div>
            <label>
              Имя
              <input type="text" placeholder="name" name="name" value="${page.getName()}" />
            </label>
          </div>
          <div>
            <label>
              Email
              <input type="email" required name="email" value="${page.getEmail()}" />
            </label>
          </div>
          <div>
            <label>
              Пароль
              <input type="password" placeholder="password" required name="password" />
            </label>
          </div>
          <div>
            <label>
              Подтверждение пароля
              <input type="password" required name="passwordConfirmation" />
            </label>
          </div>
          <input type="submit" value="Зарегистрировать" />
        </form>
    `,
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2025 User Manager | Users Page</p>
        </div>
    `
)