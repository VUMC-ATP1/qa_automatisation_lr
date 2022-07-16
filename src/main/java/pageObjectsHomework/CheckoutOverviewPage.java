package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    private final By finishButton = By.id("finish");
    private WebDriver driver;
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getFinishButton() {
        return driver.findElement(finishButton);
    }

    public void setFinishButton() {
        getFinishButton().click();
    }
}
