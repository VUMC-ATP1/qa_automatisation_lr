package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getUserNameField() {
        return driver.findElement(usernameField);
    }

    public void setUserName(String value) {
        getUserNameField().sendKeys(value);
    }
    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public void setPassword(String value) {
        getPasswordField().sendKeys(value);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public void setloginButton() {
        getLoginButton().click();
    }
}
