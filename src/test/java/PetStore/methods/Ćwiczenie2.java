package PetStore.methods;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Ćwiczenie2 {
    // Wykorzystując dokumentację dostępną pod adresem http://swaggerpetstore.przyklady.javastart.pl/, napisz test dla endpointa /user i metody POST.

    String user = "{\n" +
            "  \"id\": 445,\n" +
            "  \"username\": \"Evo\",\n" +
            "  \"firstName\": \"Evo\",\n" +
            "  \"lastName\": \"Kowalski\",\n" +
            "  \"email\": \"Evo@test.com\",\n" +
            "  \"password\": \"password\",\n" +
            "  \"phone\": \"+123456789\",\n" +
            "  \"userStatus\": 1\n" +
            "}";
    @Test
    public void createUser() {
        given().log().all().contentType("application/json").body(user)
                .when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/user")
                .then().log().all().statusCode(200);
    }
}
