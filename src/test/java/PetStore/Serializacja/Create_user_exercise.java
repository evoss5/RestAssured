package PetStore.Serializacja;

import org.testng.annotations.Test;
import pl.javastart.main.pojo.User;

import static io.restassured.RestAssured.given;

public class Create_user_exercise {
    @Test
    public void createUser() {
        User user = new User();
        user.setId(555);
        user.setUsername("evo1");
        user.setFirstName("Maciek");
        user.setLastName("Evo");
        user.setEmail("evo@o2.pl");
        user.setUserStatus(123);

        given().log().all().contentType("application/json").body(user).when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/user").then().log().all().statusCode(200);

        user.setFirstName("Evo");
        user.setLastName("Kowalski");

        given().log().all().contentType("application/json").pathParam("username", user.getUsername()).body(user).when().put("https://swaggerpetstore.przyklady.javastart.pl/v2/user/{username}").then().log().all().statusCode(200);

        given().log().all().contentType("application/json").pathParam("username", user.getUsername()).when().get("https://swaggerpetstore.przyklady.javastart.pl/v2/user/{username}").then().log().all().statusCode(200);

    }
}
