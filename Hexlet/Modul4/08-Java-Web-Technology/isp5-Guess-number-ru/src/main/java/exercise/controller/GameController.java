package exercise.controller;

import exercise.dto.GuessPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;

import java.util.Random;

import static io.javalin.rendering.template.TemplateUtil.model;

public class GameController {

    // BEGIN (write your solution here)
    public static void index(Context ctx) {
        ctx.render("index.html");
    }

    public static void start(Context ctx) {
        // Генерирует случайное число от 1 до 100 (secretNumber).
        var secretNumber = new Random().nextInt(1, 100);
        //Получает количество попыток из формы (по умолчанию 8, если не указано).
        var maxAttempts = ctx.formParamAsClass("attempts", Integer.class)
                .getOrDefault(8);
        ctx.sessionAttribute("maxAttempts", maxAttempts);   // максимальное число попыток
        ctx.sessionAttribute("secretNumber", secretNumber); // загаданное число
        ctx.sessionAttribute("attempts", 0); // счётчик попыток
        var message = "Lets start!";
        // Создает объект GuessPage с начальными параметрами.
        var page = new GuessPage(0, maxAttempts, false, message);
        // Рендерит шаблон "guess.html", передавая объект страницы.
        ctx.render("guess.html", model("page", page));

    }

    public static void guess(Context ctx) {
        // Обрабатывает попытку угадать число. Получает ответ пользователя из формы.
        int answer = ctx.formParamAsClass("usersAnswer", Integer.class).getOrDefault(0);
        // Извлекает из сессии:
        int secretNumber = ctx.sessionAttribute("secretNumber");
        int attempts = ctx.sessionAttribute("attempts");
        int maxAttempts = ctx.sessionAttribute("maxAttempts");
        // Увеличивает счетчик попыток на 1.
        attempts++;
        // Определяет результат:
        ctx.sessionAttribute("attempts", attempts);
        String message;
        boolean isWin = false;
        //Если угадал - сообщение о победе
        //Если попытки закончились - сообщение о проигрыше с показом числа
        //Иначе - подсказка (больше/меньше)
        if (answer == secretNumber) {
            message = "Congratulations! You win!";
            isWin = true;
        } else if (attempts >= maxAttempts) {
            message = "You're out of tries. The number you guessed was " + secretNumber;
        } else if (answer < secretNumber) {
            message = "The guessed number is greater than yours";
        } else {
            message = "The guessed number is less than yours";
        }
        // Создает объект GuessPage с обновленными параметрами.
        var page = new GuessPage(attempts, maxAttempts, isWin, message);
        // Рендерит шаблон "guess.html" с новыми данными.
        ctx.render("guess.html", model("page", page));
    }
    // Сбрасывает игру.
    public static void reset(Context ctx) {
        // Удаляет из сессии все атрибуты игры:
        ctx.consumeSessionAttribute("maxAttempts");
        ctx.consumeSessionAttribute("secretNumber");
        ctx.consumeSessionAttribute("attempts");
        // Перенаправляет пользователя на стартовую страницу.
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
