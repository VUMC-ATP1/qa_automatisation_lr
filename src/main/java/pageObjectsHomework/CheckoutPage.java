package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By msgError = By.cssSelector(".error-message-container h3");
    private WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }

    public void setFirstName(String value) {
        getFirstName().sendKeys(value);
    }
    public WebElement getLastName() {
        return driver.findElement(lastName);
    }

    public void setLastName(String value) {
        getLastName().sendKeys(value);
    }
    public WebElement getZipCode() {
        return driver.findElement(zipCode);
    }

    public void setZipCode(String value) {
        getZipCode().sendKeys(value);
    }
    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public void setContinueButton() {
        getContinueButton().click();
    }
    public WebElement getMsgError() {
        return driver.findElement(msgError);
    }
}
