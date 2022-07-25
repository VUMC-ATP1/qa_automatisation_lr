package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSuccessPage {
    private final By homeButton = By.id("back-to-products");
    private final By checkoutComplete = By.className("title");
    private final By msgThankU = By.className("complete-header");
    private WebDriver driver;
    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getHomeButton() {
        return driver.findElement(homeButton);
    }

    public void setHomeButton() {
        getHomeButton().click();
    }
    public WebElement getCheckoutTitle()
    {
        return driver.findElement(checkoutComplete);
    }
    public WebElement getMsgThankU()
    {
        return driver.findElement(msgThankU);
    }
}
