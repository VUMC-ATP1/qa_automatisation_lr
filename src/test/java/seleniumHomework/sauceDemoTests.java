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

        loginPage.setUserName("standard_user");

        loginPage.setPassword("secret_sauce");

        loginPage.setloginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        inventoryPage.setAddBikeLight();

        inventoryPage.setCartButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

        Assert.assertEquals(inventoryPage.getItemInCart().getText(), "Sauce Labs Bike Light");

        cartPage.setCheckoutButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");

        checkoutPage.setFirstName("John");

        checkoutPage.setLastName("Doe");

        checkoutPage.setZipCode("1111");

        checkoutPage.setContinueButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");

        Assert.assertEquals(checkoutOverviewPage.getItemName().getText(), "Sauce Labs Bike Light");

        Assert.assertEquals(checkoutOverviewPage.getCartTotal().getText(),"Total: $10.79");

        checkoutOverviewPage.setFinishButton();

        Assert.assertEquals(checkoutSuccessPage.getCheckoutTitle().getText(), "CHECKOUT: COMPLETE!");

        Assert.assertEquals(checkoutSuccessPage.getMsgThankU().getText(), "THANK YOU FOR YOUR ORDER");


        checkoutSuccessPage.setHomeButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }
    @Test
    public void scenarioTwo() {

        loginPage.setUserName("standard_user");

        loginPage.setPassword("secret_sauce");

        loginPage.setloginButton();

        inventoryPage.setAddBikeLight();

        inventoryPage.setCartButton();

        cartPage.setCheckoutButton();

        checkoutPage.setContinueButton();

        Assert.assertEquals(checkoutPage.getMsgError().getText(), "Error: First Name is required");

        checkoutPage.setFirstName("John");

        checkoutPage.setContinueButton();

        Assert.assertEquals(checkoutPage.getMsgError().getText(), "Error: Last Name is required");

        checkoutPage.setLastName("Doe");

        checkoutPage.setContinueButton();
        Assert.assertEquals(checkoutPage.getMsgError().getText(), "Error: Postal Code is required");

        checkoutPage.setZipCode("1111");

        checkoutPage.setContinueButton();

        Assert.assertEquals(checkoutSuccessPage.getCheckoutTitle().getText(), "CHECKOUT: OVERVIEW");


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Aizveram Chrome");
        driver.close();
    }
}
