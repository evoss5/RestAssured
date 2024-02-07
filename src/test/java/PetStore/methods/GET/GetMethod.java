package PetStore.methods.GET;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethod {
    @Test
    public void getMethod() {
        given().when().get("https://swaggerpetstore.przyklady.javastart.pl/v2/pet/{param}", 0).then().statusCode(404);

    }

    @Test
    public void getMethodNamedParameters() {
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

    }
    @Test
    public void namedParameters() {
        given().log().all().log().uri().pathParam("petId", 1).when().get("https://swaggerpetstore.przyklady.javastart.pl/v2/pet/{petId}").then().log().all().statusCode(200);
    }
}
