package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import tests.base.BaseTest;

public class ProductsPageTest extends BaseTest {

    @Test
    public void testSearchProductDisplaysResults() {
        HomePage home = new HomePage(driver);
        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);
        products.enterSearchQuery("Top");
        products.clickSearchButton();

        String header = products.getSearchedProductsHeader();
        Assert.assertTrue(header.contains("Searched Products"), "Search results not shown.");
    }

    @Test
    public void testViewProductOpensDetailPage() {
        HomePage home = new HomePage(driver);
        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);
        products.clickFirstProductViewButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"), "Product detail page not opened.");
    }
}
