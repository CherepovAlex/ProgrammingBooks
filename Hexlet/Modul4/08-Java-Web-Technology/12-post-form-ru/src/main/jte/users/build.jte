@template.layout.page(
    content = @`
        <form action="/users" method="post">
            <div>
                <label>
                Name
                <input type="text" name="firstName" />
                </label>
            </div>
            <div>
                <label>
                Last Name
                <input type="text" name="lastName" />
                </label>
            </div>
            <div>
                <label>
                Email
                <input type="email" required name="email" />
                </label>
            </div>
            <div>
                <label>
                Пароль
                <input type="password" required name="password" />
                </label>
            </div>
            <input type="submit" value="Submit" />
        </form>
    `
)