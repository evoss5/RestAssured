package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.oauth;
import static io.restassured.RestAssured.when;

public class CRUD {
    private static String username = "ck_8da07afd3503a4242e95a2d5bad99cc2fb55c552";
    private static String password = "cs_e57e8cadc42ca42064c44239853dda9aa2e77474";
    private static String url = "http://fakestore.local/wp-json/wc/v3/";
    private static String uri = "http://fakestore.local";
    private static String basePath = "fakestore.local/wp-json/wc/v3/";
    private static String productsEndpoint = "products";
    private static int port = 80;


    @BeforeAll
    public static void settings() {
        RestAssured.baseURI = uri;
        RestAssured.port = port;
        RestAssured.basePath = basePath;
        RestAssured.authentication = oauth(username, password, "", "");
    }

    @Test
    public void getAgain() {
        Response response = when().get(productsEndpoint);
        Assertions.assertEquals(200, response.statusCode());
    }

}
