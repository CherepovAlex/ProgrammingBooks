package io.hexlet.app;

import io.hexlet.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

class AppTest {

    private static Javalin app;

    @BeforeEach
    public void setUp() throws Exception {
        app = App.getApp();
    }

    @Test
    void testMainPage() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    void testProductsPage() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/movies");
            assertThat(response.code()).isEqualTo(200);

            var body = response.body().string();

            assertThat(body).contains("Sukiyaki Western Django", "Stephen Giddons", "Action|Western");
            assertThat(body).contains("Mr. Average", "Scotty Diver", "Comedy|Romance");
        });
    }

    @Test
    void testFilteredPage1() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/movies?genre=Drama&rating=9");
            assertThat(response.code()).isEqualTo(200);

            var body = response.body().string();

            assertThat(body).contains("The Scapegoat", "Drama");
            assertThat(body).contains("Tumbleweeds", "Drama");
            assertThat(body).doesNotContain("Cosmopolis", "Nasty Old People");
        });
    }

    @Test
    void testFilteredPage2() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/movies?director=Deane+Ealles");
            assertThat(response.code()).isEqualTo(200);

            var body = response.body().string();

            assertThat(body).contains("Storage 24");
            assertThat(body).doesNotContain("Waterloo", "Nasty Old People");
        });
    }

    @Test
    void testFilteredPage3() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/movies?rating=9.9");
            assertThat(response.code()).isEqualTo(200);

            var body = response.body().string();

            assertThat(body).contains("Chicago Cab");
            assertThat(body).doesNotContain("Nymph", "Teddy Bear");
        });
    }
}