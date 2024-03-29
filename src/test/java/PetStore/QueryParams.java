package PetStore;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pl.javastart.main.pojo.Category;
import pl.javastart.main.pojo.Pet;
import pl.javastart.main.pojo.Tag;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class QueryParams {

    @Test
    public void queryParams() {
        Category category = new Category();
        category.setId(901);
        category.setName("dogs");

        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("dogs-category");

        Pet pet = new Pet();
        pet.setId(999);
        pet.setCategory(category);
        pet.setStatus("sold");

        given().log().all().body(pet).contentType("application/json")
                .when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/pet").then().log().all().statusCode(200);

        Pet[] pets = given().log().all().body(pet).contentType("application/json")
                .queryParam("status", "sold")
                .when().get("https://swaggerpetstore.przyklady.javastart.pl/v2/pet/findByStatus")
                .then().log().all().statusCode(200).extract().as(Pet[].class);

        Assertions.assertTrue(Arrays.asList(pets).size() > 0, "Lista zwierzaków");
    }

}
