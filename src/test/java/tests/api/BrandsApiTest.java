package tests.api;

import apis.BrandsApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrandsApiTest {

    BrandsApi brandsApi = new BrandsApi();

    @Test
    public void testGetAllBrands() {
        Response response = brandsApi.getAllBrands();
        Assert.assertEquals(response.getStatusCode(), 200, "Expected HTTP 200 for GET brandsList");
        Assert.assertTrue(response.getBody().asString().contains("brands"), "Response should contain 'brands'");
    }

    @Test
    public void testPutToBrandsListShouldFail() {
        Response response = brandsApi.putToBrandsList();
        Assert.assertEquals(response.getStatusCode(), 405, "Expected HTTP 405 for PUT on brandsList");
    }
}

