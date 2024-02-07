package PetStore.methods.PUT;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class putMethod {
    @Test
    public void getMethodTest() {

        String pet = "{\n" +
                "  \"id\": 123,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"dogs\"\n" +
                "  },\n" +
                "  \"name\": \"Burek\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"http://photos.com/dog1.jpg\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"dogs-category\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        given().log().all().body(pet).contentType("application/json").when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/pet").then().log().all().statusCode(200);

        pet = "{\n" +
                "  \"id\": 123,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"dogs\"\n" +
                "  },\n" +
                "  \"name\": \"Reksio\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"http://photos.com/dog1.jpg\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"dogs-category\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        given().log().all().body(pet).contentType("application/json").when().put("https://swaggerpetstore.przyklady.javastart.pl/v2/pet").then().log().all().statusCode(200);

    }
}
