package PetStore.methods;

import org.testng.annotations.Test;
import pl.javastart.main.pojo.User;

import static io.restassured.RestAssured.given;

public class Ćwiczenie2 {
    // Wykorzystując dokumentację dostępną pod adresem http://swaggerpetstore.przyklady.javastart.pl/, napisz test dla endpointa /user i metody POST.


    @Test
    public void createUser() {
        User user = new User();
        user.setId(445);
        user.setUsername("Evo_user");
        user.setFirstName("Evo");
        user.setLastName("Piasek");
        user.setEmail("evo@o2.pl");
        user.setPassword("pass");
        user.setPhone("+24441221");
        user.setUserStatus(123);
        given().log().all().contentType("application/json").body(user)
                .when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/user")
                .then().log().all().statusCode(200);
    }
}
