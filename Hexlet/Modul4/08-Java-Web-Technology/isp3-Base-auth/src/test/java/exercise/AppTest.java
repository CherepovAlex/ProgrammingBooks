package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

import java.util.Base64;

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
    void testWithoutHeader() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/protected");
            assertThat(response.code()).isEqualTo(401);

            var header = response.header("WWW-Authenticate");
            assertThat(header).isNotNull();

            var body = response.body().string();
            assertThat(body).doesNotContain("Welcome to protected Area");
        });
    }

    @Test
    void testWithWrongUser() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var credentials = "wrong:strong_password";
            var encoded = Base64.getEncoder().encodeToString(credentials.getBytes());
            var response = client
                    .get("/protected", (req) -> req.header("Authorization", "Basic " + encoded));

            assertThat(response.code()).isEqualTo(401);

            var header = response.header("WWW-Authenticate");
            assertThat(header).isNotNull();

            var body = response.body().string();
            assertThat(body).doesNotContain("Welcome to protected Area");
        });
    }

    @Test
    void testWithWrongPassword() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var credentials = "admin:password";
            var encoded = Base64.getEncoder().encodeToString(credentials.getBytes());
            var response = client
                    .get("/protected", (req) -> req.header("Authorization", "Basic " + encoded));

            assertThat(response.code()).isEqualTo(401);

            var header = response.header("WWW-Authenticate");
            assertThat(header).isNotNull();

            var body = response.body().string();
            assertThat(body).doesNotContain("Welcome to protected Area");
        });
    }

    @Test
    void testAuthenticated() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var credentials = "admin:strong_password";
            var encoded = Base64.getEncoder().encodeToString(credentials.getBytes());
            var response = client
                    .get("/protected", (req) -> req.header("Authorization", "Basic " + encoded));

            assertThat(response.code()).isEqualTo(200);

            var body = response.body().string();
            assertThat(body).contains("Welcome to protected Area");
        });
    }

    @Test
    void testPostRequest() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var response = client.post("/protected");
            assertThat(response.code()).isEqualTo(401);

            var header = response.header("WWW-Authenticate");
            assertThat(header).isNotNull();
        });
    }
}
