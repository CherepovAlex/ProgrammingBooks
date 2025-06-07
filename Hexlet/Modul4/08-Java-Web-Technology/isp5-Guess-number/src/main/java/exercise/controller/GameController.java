package exercise.controller;

import exercise.dto.GuessPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;

import static io.javalin.rendering.template.TemplateUtil.model;

import java.util.Random;

public class GameController {

    // BEGIN (write your solution here)
    private static final String SECRET_NUMBER_ATTRIBUTE = "secretNumber";
    private static final String MAX_ATTEMPTS_ATTRIBUTE = "maxAttempts";
    private static final String CURRENT_ATTEMPT_ATTRIBUTE = "currentAttempt";

    public static void index(Context ctx) {
        ctx.render("index.html");
    }

    public static void start(Context ctx) {
        int attempts = Integer.parseInt(ctx.formParam("attempts"));
        int secretNumber = new Random().nextInt(100) + 1;

        ctx.sessionAttribute(SECRET_NUMBER_ATTRIBUTE, secretNumber);
        ctx.sessionAttribute(MAX_ATTEMPTS_ATTRIBUTE, attempts);
        ctx.sessionAttribute(CURRENT_ATTEMPT_ATTRIBUTE, 0);

        var page = new GuessPage(
            0,
            attempts,
            false,
            "Lets start! Guess the number from 1 to 100"
        );
        ctx.render("guess.html", model("page", page));
    }

    public static void guess(Context ctx) {
        int secretNumber = ctx.sessionAttribute(SECRET_NUMBER_ATTRIBUTE);
        int maxAttempts = ctx.sessionAttribute(MAX_ATTEMPTS_ATTRIBUTE);
        int currentAttempt = ctx.sessionAttribute(CURRENT_ATTEMPT_ATTRIBUTE);

        int userAnswer = Integer.parseInt(ctx.formParam("usersAnswer"));
        currentAttempt++;

        String message;
        boolean isWin = false;

        if (userAnswer == secretNumber) {
            message = "Congratulations! You win!";
            isWin = true;
        } else if (currentAttempt >= maxAttempts) {
            message = "You lose! The number was " + secretNumber;
        } else {
            message = userAnswer < secretNumber
                ? "The number is greater than " + userAnswer
                : "The number is less than " + userAnswer;
            ctx.sessionAttribute(CURRENT_ATTEMPT_ATTRIBUTE, currentAttempt);
        }

        var page = new GuessPage(
            currentAttempt,
            maxAttempts,
            isWin,
            message
        );
        ctx.render("guess.html", model("page", page));
    }

    public static void reset(Context ctx) {
        ctx.sessionAttribute(SECRET_NUMBER_ATTRIBUTE, null);
        ctx.sessionAttribute(MAX_ATTEMPTS_ATTRIBUTE, null);
        ctx.sessionAttribute(CURRENT_ATTEMPT_ATTRIBUTE, null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
