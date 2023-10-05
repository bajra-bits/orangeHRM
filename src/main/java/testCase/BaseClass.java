package testCase;

import constants.Enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.Driver;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Logger logger;

    @Parameters({"type", "waitTime", "url"})
    @BeforeClass
    public void setup(String type, String waitTime, String url) {
        try {
            driver = Driver.getWebDriver(Enums.driverType.valueOf(type));
            wait = Driver.getWebDriverWait(driver, Long.parseLong(waitTime));
            logger = LogManager.getLogger(BaseClass.class.getName());
            driver.get(url);
            driver.manage().window().maximize();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid enum string: " + type);
        }

    }

    @Parameters({"sleepTime"})
    @AfterClass
    public void teardown(String sleepTime) throws InterruptedException {
        Thread.sleep(Long.parseLong(sleepTime));
        driver.quit();
    }

}
