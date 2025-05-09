package tests.api;

import apis.ProductsApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsApiTest {

    ProductsApi productsApi = new ProductsApi();

    @Test
    public void testGetAllProducts() {
        Response response = productsApi.getAllProducts();
        Assert.assertEquals(response.getStatusCode(), 200, "Expected HTTP 200 for GET productsList");
        Assert.assertTrue(response.getBody().asString().contains("products"), "Response should contain 'products'");
    }

    @Test
    public void testPostToProductsListShouldFail() {
        Response response = productsApi.postToProductsList();
        Assert.assertEquals(response.getStatusCode(), 405, "Expected HTTP 405 for POST on productsList");
    }
}
