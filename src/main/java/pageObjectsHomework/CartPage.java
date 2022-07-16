package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private final By checkoutButton = By.id("checkout");
    private WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButton);
    }

    public void setCheckoutButton() {
        getCheckoutButton().click();
    }
}