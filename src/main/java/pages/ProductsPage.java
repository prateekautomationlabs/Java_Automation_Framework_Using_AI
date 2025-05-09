package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    // Locators
    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By searchedProductsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
    private final By firstProductViewButton = By.xpath("(//a[contains(text(),'View Product')])[1]");

    // Constructor
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void enterSearchQuery(String query) {
        driver.findElement(searchInput).sendKeys(query);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String getSearchedProductsHeader() {
        return driver.findElement(searchedProductsHeader).getText();
    }

    public void clickFirstProductViewButton() {
        driver.findElement(firstProductViewButton).click();
    }
}
