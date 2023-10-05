package pageModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.util.List;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;

//    @FindBy(name = "username")
//    private WebElement username;
//
//    @FindBy(name = "password")
//    private WebElement password;
//
//    @FindBy(xpath = "//*[contains(text(), 'Login')]")
//    private WebElement loginBtn;

    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By error = By.xpath("//div[@class='oxd-alert oxd-alert--error']");
    private By emptyField = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");

    public Login(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
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

    public List<WebElement> getError() {
        return driver.findElements(error);
    }

    public List<WebElement> getEmptyField() {
        return driver.findElements(emptyField);
    }

}
