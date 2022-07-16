package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSuccessPage {
    private final By homeButton = By.id("back-to-products");
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
}
