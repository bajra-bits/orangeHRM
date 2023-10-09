package pageModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard extends BaseModal{
    private By navList = By.xpath("//ul[@class='oxd-main-menu']");
    private By adminNav = By.xpath("//li[1]//a[1]//span[1]");

    public Dashboard(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public  void navToAdmin() {
        WebElement navList = wait.until(ExpectedConditions.visibilityOfElementLocated(this.navList));
        navList.findElement(adminNav).click();
    }

}
