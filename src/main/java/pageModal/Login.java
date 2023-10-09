package pageModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Login extends BaseModal {
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By error = By.xpath("//div[@role='alert']");
    private By emptyField = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");

    public Login(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        clearFields();
        Utils.visibilityOfElementLocated(wait, this.username).sendKeys(username);
        Utils.visibilityOfElementLocated(wait, this.password).sendKeys(password);
        Utils.visibilityOfElementLocated(wait, loginBtn).click();
    }

    public void clearFields() {
        Utils.visibilityOfElementLocated(wait, this.username).clear();
        Utils.visibilityOfElementLocated(wait, this.password).clear();
    }

    public List<WebElement> getError() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElements(error);
    }

    public List<WebElement> getEmptyField() {
        return driver.findElements(emptyField);
    }

}
