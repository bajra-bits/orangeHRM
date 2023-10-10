package utils;

import constants.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Utils {
    public static WebElement visibilityOfElementLocated(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement elementToBeClickable(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static List<WebElement> visibilityOfAllElementsLocatedBy(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static WebElement presenceOfNestedElementLocatedBy(WebDriverWait wait, WebElement el,  By locator) {
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(el, locator));
    }

    public static void invisibilityOf(WebDriver driver, WebDriverWait wait, By el) {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(el)));
    }

    public static String getOptionValue(String role) {
        return role.trim().length() < 1 ? Variables.optionEmpty : role;
    }




}
