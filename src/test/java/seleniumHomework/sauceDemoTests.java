package seleniumHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsHomework.InventoryPage;
import pageObjectsHomework.LoginPage;
import pageObjectsHomework.CartPage;
import pageObjectsHomework.CheckoutOverviewPage;
import pageObjectsHomework.CheckoutPage;
import pageObjectsHomework.CheckoutSuccessPage;

import java.util.logging.Level;
import java.util.logging.Logger;
@Log4j
public class sauceDemoTests {
    private final String sauceURL = "https://www.saucedemo.com/";
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;
    WebDriverWait wait;


    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Atveram Chrome");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
        driver.get(sauceURL);
    }

    @Test
    public void scenarioOne() {
        Assert.assertEquals(driver.getCurrentUrl(), sauceURL);
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

//        WebElement usernameField = driver.findElement(By.id("user-name"));
//        usernameField.sendKeys("standard_user");
        loginPage.setUserName("standard_user");

//        WebElement passwordField = driver.findElement(By.id("password"));
//        passwordField.sendKeys("secret_sauce");
        loginPage.setPassword("secret_sauce");

//        WebElement loginButton = driver.findElement(By.id("login-button"));
//        loginButton.click();
        loginPage.setloginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

//        WebElement addBikeLight = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
//        addBikeLight.click();
        inventoryPage.setAddBikeLight();

//        WebElement cartButton = driver.findElement(By.className("shopping_cart_badge"));
//        cartButton.click();
        inventoryPage.setCartButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

        WebElement itemInCart = driver.findElement(By.linkText("Sauce Labs Bike Light"));
        Assert.assertEquals(itemInCart.getText(),"Sauce Labs Bike Light");

//        WebElement checkoutButton = driver.findElement(By.id("checkout"));
//        checkoutButton.click();
        cartPage.setCheckoutButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");

//        WebElement firstnameField = driver.findElement(By.id("first-name"));
//        firstnameField.sendKeys("John");
        checkoutPage.setFirstName("John");

//        WebElement lastnameField = driver.findElement(By.id("last-name"));
//        lastnameField.sendKeys("Doe");
        checkoutPage.setLastName("Doe");

//        WebElement zipCodeField = driver.findElement(By.id("postal-code"));
//        zipCodeField.sendKeys("1111");
        checkoutPage.setZipCode("1111");

//        WebElement continueButton = driver.findElement(By.id("continue"));
//        continueButton.click();
        checkoutPage.setContinueButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");

        WebElement itemName = driver.findElement(By.className("inventory_item_name"));
        Assert.assertEquals(itemName.getText(), "Sauce Labs Bike Light");

        WebElement cartTotal = driver.findElement(By.className("summary_total_label"));
        Assert.assertEquals(cartTotal.getText(), "Total: $10.79");

//        WebElement finishButton = driver.findElement(By.id("finish"));
//        finishButton.click();
        checkoutOverviewPage.setFinishButton();

        WebElement checkoutComplete = driver.findElement(By.className("title"));
        Assert.assertEquals(checkoutComplete.getText(), "CHECKOUT: COMPLETE!");

        WebElement msgThankU = driver.findElement(By.className("complete-header"));
        Assert.assertEquals(msgThankU.getText(), "THANK YOU FOR YOUR ORDER");

//        WebElement homeButton = driver.findElement(By.id("back-to-products"));
//        homeButton.click();
        checkoutSuccessPage.setHomeButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }
    @Test
    public void scenarioTwo() {
       // Assert.assertEquals(driver.getCurrentUrl(), sauceURL);
       // Assert.assertEquals(driver.getTitle(), "Swag Labs");

//        WebElement usernameField = driver.findElement(By.id("user-name"));
//        usernameField.sendKeys("standard_user");
        loginPage.setUserName("standard_user");

//        WebElement passwordField = driver.findElement(By.id("password"));
//        passwordField.sendKeys("secret_sauce");
        loginPage.setPassword("secret_sauce");

//        WebElement loginButton = driver.findElement(By.id("login-button"));
//        loginButton.click();
        loginPage.setloginButton();

      //  Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

//        WebElement add2CartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
//        add2CartButton.click();
        inventoryPage.setAddBikeLight();

//        WebElement cartButton = driver.findElement(By.className("shopping_cart_badge"));
//        cartButton.click();
        inventoryPage.setCartButton();
      //  Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

      //  WebElement itemInCart = driver.findElement(By.linkText("Sauce Labs Bike Light"));
      //  Assert.assertEquals(itemInCart.getText(), "Sauce Labs Bike Light");

//        WebElement checkoutButton = driver.findElement(By.id("checkout"));
//        checkoutButton.click();
        cartPage.setCheckoutButton();

     //   Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");

//        WebElement continueButton = driver.findElement(By.id("continue"));
//        continueButton.click();
        checkoutPage.setContinueButton();

        WebElement msgError = driver.findElement(By.cssSelector(".error-message-container h3"));
        Assert.assertEquals(msgError.getText(), "Error: First Name is required");

//        WebElement firstnameField = driver.findElement(By.id("first-name"));
//        firstnameField.sendKeys("John");
        checkoutPage.setFirstName("John");

//        WebElement continueButton = driver.findElement(By.id("continue"));
//        continueButton.click();
        checkoutPage.setContinueButton();

        //WebElement msgError = driver.findElement(By.className("error-message-container error"));
        Assert.assertEquals(msgError.getText(), "Error: Last Name is required");

//        WebElement lastnameField = driver.findElement(By.id("last-name"));
//        lastnameField.sendKeys("Doe");
        checkoutPage.setLastName("Doe");

        checkoutPage.setContinueButton();
        Assert.assertEquals(msgError.getText(), "Error: Postal Code is required");

//        WebElement zipCodeField = driver.findElement(By.id("postal-code"));
//        zipCodeField.sendKeys("1111");
        checkoutPage.setZipCode("1111");

        checkoutPage.setContinueButton();
        WebElement checkoutComplete = driver.findElement(By.className("title"));
        Assert.assertEquals(checkoutComplete.getText(), "CHECKOUT: OVERVIEW");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Aizveram Chrome");
        driver.close();
    }
}
