package io.hexlet.controller;

import java.sql.SQLException;
import static io.javalin.rendering.template.TemplateUtil.model;

import io.hexlet.dto.cars.BuildCarPage;
import io.hexlet.dto.cars.CarPage;
import io.hexlet.dto.cars.CarsPage;
import io.hexlet.model.Car;
import io.hexlet.repository.CarRepository;
import io.hexlet.util.NamedRoutes;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class CarController {
    public static void index(Context ctx) throws SQLException {
        var cars = CarRepository.getEntities();
        var page = new CarsPage(cars);
        ctx.render("cars/index.jte", model("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var car = CarRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Car with id = " + id + " not found"));
        var page = new CarPage(car);
        ctx.render("cars/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCarPage();
        ctx.render("cars/build.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        var make = ctx.formParam("make");
        var model = ctx.formParam("model");

        var car = new Car(make, model);
        CarRepository.save(car);
        ctx.redirect(NamedRoutes.carsPath());
    }
}
