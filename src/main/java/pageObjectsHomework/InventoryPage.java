package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    private final By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By cartButton = By.className("shopping_cart_badge");
    private final By itemInCart = By.linkText("Sauce Labs Bike Light");
    private WebDriver driver;
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getAddBikeLight() {
        return driver.findElement(addBikeLight);
    }
    public void setAddBikeLight() {
        getAddBikeLight().click();
    }
    public WebElement getCartButton() {
        return driver.findElement(cartButton);
    }
    public void setCartButton() {
        getCartButton().click();
    }
    public WebElement getItemInCart()
    {
        return driver.findElement(itemInCart);
    }
}
