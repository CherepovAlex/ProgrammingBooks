package exercise.controller;


import exercise.dto.products.ProductsPage;
import exercise.dto.products.ProductPage;
import exercise.repository.ProductsRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import java.sql.SQLException;

public class ProductsController {

    public static void index(Context ctx) throws SQLException {
        var limit = ctx.queryParamAsClass("limit", Integer.class).getOrDefault(Integer.MAX_VALUE);
        var products = ProductsRepository.getEntitiesLimited(limit);
        var page = new ProductsPage(products);
        ctx.json(page);
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var product = ProductsRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Product not found"));

        var page = new ProductPage(product);
        ctx.json(page);
    }
}
