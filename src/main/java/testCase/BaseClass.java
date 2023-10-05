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
import utils.ReadConfig;

import java.util.HashMap;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Logger logger;

    @BeforeClass
    public void setup() {
        try {
            ReadConfig read = new ReadConfig();
            HashMap<String, String> config = read.getDriverConfig();

            driver = Driver.getWebDriver(Enums.driverType.valueOf(config.get("type")));
            wait = Driver.getWebDriverWait(driver, Long.parseLong(config.get("waitTime")));
            logger = LogManager.getLogger("OrangeHRM");
            driver.get(config.get("url"));
            driver.manage().window().maximize();
        } catch (IllegalArgumentException ex) {
            logger.error("Invalid driver type" );
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            throw ex;
        }

    }


}
