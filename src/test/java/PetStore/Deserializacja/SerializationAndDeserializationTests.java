package PetStore.Deserializacja;


import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pl.javastart.main.pojo.Category;
import pl.javastart.main.pojo.Pet;
import pl.javastart.main.pojo.Tag;

import java.util.Collections;

import static io.restassured.RestAssured.given;

public class SerializationAndDeserializationTests {

    @Test
    public void givenPetWhenPostPetThenPetIsCreatedTest() {

        Category category = new Category();
        category.setId(1);
        category.setName("dogs");

        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("dogs-category");

        Pet pet = new Pet();
        pet.setId(123);
        pet.setCategory(category);
        pet.setPhotoUrls(Collections.singletonList("http://photos.com/dog1.jpg"));
        pet.setTags(Collections.singletonList(tag));
        pet.setStatus("available");

        given().log().all().body(pet).contentType("application/json")
                .when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/pet")
                .then().log().all().statusCode(200);


        Pet acutalPet = given().log().all().body(pet).contentType("application/json").when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/pet").then().log().all().statusCode(200).extract().as(Pet.class);

        Assertions.assertEquals(acutalPet.getId(), pet.getId(), "Pet Id");
        Assertions.assertEquals(acutalPet.getCategory().getName(), pet.getCategory().getName());
    }

}


