package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    private final By finishButton = By.id("finish");
    private final By itemName = By.className("inventory_item_name");
    private final By cartTotal = By.className("summary_total_label");
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
    public WebElement getItemName()
    {
        return driver.findElement(itemName);
    }
    public WebElement getCartTotal()
    {
        return driver.findElement(cartTotal);
    }
}
