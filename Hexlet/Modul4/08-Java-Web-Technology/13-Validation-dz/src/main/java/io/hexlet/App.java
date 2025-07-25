package io.hexlet;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import java.util.List;

import io.hexlet.model.Article;
import io.hexlet.dto.articles.ArticlesPage;
import io.hexlet.dto.articles.BuildArticlePage;
import io.hexlet.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            var page = new BuildArticlePage();
            ctx.render("articles/build.jte", model("page", page));
        });

        app.post("/articles", ctx -> {
           var title = ctx.formParam("title").trim();
           var content = ctx.formParam("content").trim();

           try {
               title = ctx.formParamAsClass("title", String.class)
                       .check(value -> value.length() > 2, "Название не должно быть короче двух символов")
                       .check(value -> !ArticleRepository.existsByTitle(value), "Статья с таким названием уже существует")
                       .get();
               content = ctx.formParamAsClass("content", String.class)
                       .check(value -> value.length() > 10, "Статья должна быть не короче 10 символов")
                       .get();
               var article = new Article(title, content);
               ArticleRepository.save(article);
               ctx.redirect("/articles");
           } catch (ValidationException e) {
               ctx.status(422);
               var page = new BuildArticlePage(title, content, e.getErrors());
               ctx.render("articles/build.jte", model("page", page));
           }
        });
        // END
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
