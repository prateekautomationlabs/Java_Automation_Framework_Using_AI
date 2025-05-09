package apis;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ProductsApi {

    private static final String BASE_URL = "https://automationexercise.com/api";

    public Response getAllProducts() {
        return given()
                .when()
                .get(BASE_URL + "/productsList");
    }

    public Response postToProductsList() {
        return given()
                .when()
                .post(BASE_URL + "/productsList");
    }
}
