package tests.api;

import apis.SearchProductApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductApiTest {

    SearchProductApi searchApi = new SearchProductApi();

    @Test
    public void testSearchValidProduct() {
        Response response = searchApi.searchProduct("top");
        Assert.assertEquals(response.getStatusCode(), 200, "Expected HTTP 200 for valid product search");
        Assert.assertTrue(response.getBody().asString().contains("products"), "Response should contain 'products'");
    }

    @Test
    public void testSearchProductWithoutParamShouldFail() {
        Response response = searchApi.searchProductWithoutParam();
        Assert.assertEquals(response.getStatusCode(), 400, "Expected HTTP 400 for missing parameter");
    }
}
