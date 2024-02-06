package PetStore;

import static io.restassured.RestAssured.given;

public class Test {
    @org.testng.annotations.Test
    public void automatedTest() {
        given().when().get("https://swaggerpetstore.przyklady.javastart.pl/v2/pet/1").then().statusCode(200);

    }
}
