package PetStore.methods.POST;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class postMethod {
    @Test
    public void postMethod() {
        String pet = "{\n" +
                "  \"id\": 555,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"Fika\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        given().log().all().body(pet).contentType("application/json")
                .when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/pet")
                .then().log().all().statusCode(200);


        given().log().all().body(pet).pathParam("petId", 555)
                .when().delete("https://swaggerpetstore.przyklady.javastart.pl/v2/pet/{petId}")
                .then().log().all().statusCode(200);
    }
    @Test
    public void createNewUser() {
        String user = "[\n" +
                "  {\n" +
                "    \"id\": 255,\n" +
                "    \"username\": \"Evo\",\n" +
                "    \"firstName\": \"Maciek\",\n" +
                "    \"lastName\": \"Evo\",\n" +
                "    \"email\": \"string\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"string\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";
        given().log().all().body(user).contentType("application/json")
                .when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/user")
                .then().log().all().statusCode(200);

        given().log().all().body(user).contentType("application/json").pathParam("username", "Maciek")
                .when().put("https://swaggerpetstore.przyklady.javastart.pl/v2/user/{username}")
                .then().log().all().statusCode(200);

    }
}
