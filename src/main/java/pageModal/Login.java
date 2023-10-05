package pageModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login {
    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//*[contains(text(), 'Login')]")
    private WebElement loginBtn;

    private By error = By.xpath("//div[@class='oxd-alert oxd-alert--error']");
    private By emptyField = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password) {
        clearFields();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }

    public void clearFields() {
        username.clear();
        password.clear();
    }

    public List<WebElement> getError() {
        return driver.findElements(error);
    }

    public List<WebElement> getEmptyField() {
        return driver.findElements(emptyField);
    }

}
