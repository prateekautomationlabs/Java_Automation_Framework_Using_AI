package apis;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class BrandsApi {

    private static final String BASE_URL = "https://automationexercise.com/api";

    public Response getAllBrands() {
        return given()
                .when()
                .get(BASE_URL + "/brandsList");
    }

    public Response putToBrandsList() {
        return given()
                .when()
                .put(BASE_URL + "/brandsList");
    }
}
