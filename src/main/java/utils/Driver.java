package utils;

import constants.Enums;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {
    static WebDriver driver;
    static WebDriverWait wait;

    public static WebDriver getWebDriver(Enums.driverType type) {
        if (driver == null) {

            switch (type) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;

                case EDGE:
                    driver = new EdgeDriver();
                    break;

                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
            }
        }
        return driver;
    }


    public static WebDriverWait getWebDriverWait(WebDriver driver, long waitTime) {
        if(wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        }
        return wait;
    }
}
