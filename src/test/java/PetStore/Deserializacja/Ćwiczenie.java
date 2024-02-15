package PetStore.Deserializacja;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.javastart.main.pojo.Category;
import pl.javastart.main.pojo.Pet;
import pl.javastart.main.pojo.Tag;

import static io.restassured.RestAssured.given;

public class Ćwiczenie {
    @Test
    public void givenExistingPetIdWhenGetPetThenReturnPetTest() {
        Category category = new Category();
        category.setId(1);
        category.setName("dogs");

        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("dogs-category");

        Pet pet = new Pet();
        pet.setId(123);
        pet.setCategory(category);
        pet.setStatus("available");

        given().log().all().body(pet).contentType("application/json").when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/pet").then().log().all().statusCode(200);

        Pet actualPet = given().log().method().log().uri().pathParam("petId", pet.getId()).when().get("https://swaggerpetstore.przyklady.javastart.pl/v2/pet/{petId}").then().log().all().statusCode(200).extract().as(Pet.class);

        Assertions.assertEquals(actualPet.getId(), pet.getId(), "Id is not the same");
    }
}
