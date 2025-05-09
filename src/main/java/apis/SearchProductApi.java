package apis;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class SearchProductApi {

    private static final String BASE_URL = "https://automationexercise.com/api";

    public Response searchProduct(String productName) {
        return given()
                .formParam("search_product", productName)
                .when()
                .post(BASE_URL + "/searchProduct");
    }

    public Response searchProductWithoutParam() {
        return given()
                .when()
                .post(BASE_URL + "/searchProduct");
    }
}
