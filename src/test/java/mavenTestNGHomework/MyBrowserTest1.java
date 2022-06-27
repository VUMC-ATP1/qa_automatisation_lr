package mavenTestNGHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class MyBrowserTest1 {
    private final String myURL = "https://www.lsm.lv/";
    ChromeDriver driver;

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Atveram Chrome");
        driver = new ChromeDriver();
        driver.get(myURL);
    }

    @Test
    public void testMyURL() {
        Assert.assertEquals(driver.getCurrentUrl(), myURL);
    }

    @Test
    public void testMyURLTitle() {
        Assert.assertEquals(driver.getTitle(), "LSM.lv - Uzticamas ziņas");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Aizveram Chrome");
        driver.close();
    }
}
