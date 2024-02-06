package Tests.Ćwiczenie;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Cwiczenie {
    private String username = "ck_8da07afd3503a4242e95a2d5bad99cc2fb55c552";
    private String password = "cs_e57e8cadc42ca42064c44239853dda9aa2e77474";
    private String url = "http://fakestore.local/wp-json/wc/v3/";
    private String productsEndpoint = "products";


    @Test
    public void bodyExample() {
        Response response = given().port(80).auth().oauth(username, password, "", "").when().get(url + productsEndpoint + "391");


        System.out.println(response.jsonPath().getString("id"));
        Assertions.assertEquals(200, response.statusCode());
    }
}
