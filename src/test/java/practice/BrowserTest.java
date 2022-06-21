package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Log4j
public class BrowserTest {
    ChromeDriver driver;

    private final String GOOGLE_URL = "https://google.lv";
@BeforeTest
public void setProperties(){
    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    Logger.getLogger("orc.openqa.selenium").setLevel(Level.OFF);

}
    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(GOOGLE_URL);
    }


    @Test
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertEquals(driver.getCurrentUrl(), GOOGLE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing ChromeDriver");
        driver.close();
    }
}
