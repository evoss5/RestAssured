package PetStore.methods;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Ćwiczenie1 {
/*    Zmodyfikuj drugi test automatyczny z zadania 3.1, tak aby dodać logowanie dla żądania i odpowiedzi według wymagań
    Dla żądania - zaloguj tylko ścieżkę URI oraz metodę HTTP, która została użyta,
    Dla odpowiedzi zaloguj wszystkie możliwe szczegóły. */

   @Test
    public void givenExistingPetIdWhenGetPetThenReturnPetTest() {
        given().log().method().log().uri()
                .when().get("https://swaggerpetstore.przyklady.javastart.pl/v2/pet/1")
                .then().log().all().statusCode(200);
    }


}
