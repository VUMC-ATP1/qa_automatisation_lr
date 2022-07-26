package steps_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectsHomework.*;
import utils.WebDriverManager;

public class CommonStepDef {
    WebDriver driver= WebDriverManager.getInstance();
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
    @Given("I have navigate to login page")
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }
    @When("I login  with {string} and {string}")
    public void loginWith(String username, String password) {
        loginPage.authorizeUser(username, password);
    }
    @Then("I am successfully logged in")
    public void checkSuccessLogin() {
        Assertions.assertThat(driver.getCurrentUrl()).containsIgnoringCase("inventory.html");

    }
/*
    @Then("I see login error message {string}")
    public void checkErrorMessage(String value) {
        Assertions.assertThat(authorizationPage.getErrorField().getText()).isEqualTo(value);
    }
 */

    @When("I add a product {string} in cart")
    public void addProduct(String shoppingItem) {
        inventoryPage.setAddBikeLight();
    }

    @Then("I go to shopping cart")
    public void goToCart() {
        inventoryPage.setCartButton();
    }

    @And("I check the product {string} is in cart")
    public void checkItemInCart(String itemInCart) {
        Assertions.assertThat(inventoryPage.getItemInCart().getText()).isEqualTo(itemInCart);
    }

    @Then("I navigate to Checkout")
    public void navigateToCheckout() {
        cartPage.setCheckoutButton();
    }

    @And("I fill in Order form customer name {string}, last name {string}, zip code {string}")
    public void fillOrder(String customerName, String customerLastName, String zipCode) {
        checkoutPage.setFirstName("John");
        checkoutPage.setLastName("Doe");
        checkoutPage.setZipCode("1111");
    }

    @Then("I continue submit the Order")
    public void submitOrder() {
        checkoutPage.setContinueButton();
    }

    @And("I check Order has correct item")
    public void checkOrderCorrect() {
//        Assertions.assertThat(checkoutOverviewPage.getItemName().getText()).isEqualTo(item);
        Assert.assertEquals(checkoutOverviewPage.getItemName().getText(), "Sauce Labs Bike Light");
    }

    @Then("I finish order submitting")
    public void orderSubmittedSuccessfully() {
        checkoutOverviewPage.setFinishButton();
    }


    @And("I check the Order have message {string}")
    public void checkOrderComplete(String msgThankU) {
        Assertions.assertThat(checkoutSuccessPage.getMsgThankU().getText()).isEqualTo(msgThankU);
    }
    @Then("I click back Home button")
    public void clickHomeButton() {
        checkoutSuccessPage.setHomeButton();
    }

    @And("I navigate to Home")
    public void navigateHome() {
        Assertions.assertThat(driver.getCurrentUrl()).containsIgnoringCase("inventory.html");
    }

    @When("I continue order without customer data")
    public void continueOrderWithoutCustomerData() {
        checkoutPage.setContinueButton();
    }

    @Then("I get error message {string}")
    public void getErrorMessageNoName(String noName) {
        Assertions.assertThat(checkoutPage.getMsgError().getText()).isEqualTo(noName);
    }

    @When("I enter customer {string} and click continue")
    public void enterCustomerNameAndClickContinue(String arg0) {
        checkoutPage.setFirstName("John");
        checkoutPage.setContinueButton();
    }

    @Then("I get last name error message {string}")
    public void getErrorMessageNoLastName(String noLastName) {
        Assertions.assertThat(checkoutPage.getMsgError().getText()).isEqualTo(noLastName);
    }

    @When("I enter customer {string}, {string} and click continue")
    public void enterCustomerNameLastNameAndClickContinue(String name, String lastName) {
        checkoutPage.setFirstName("John");
        checkoutPage.setLastName("Doe");
        checkoutPage.setContinueButton();
    }

    @Then("I get zip code error message {string}")
    public void getZipCodeErrorMessage(String noZipCode) {
        Assertions.assertThat(checkoutPage.getMsgError().getText()).isEqualTo(noZipCode);
    }
}
