package pageModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

public class UserManagement extends Dashboard {
    private By userMgmt = By.xpath("//span[normalize-space()='User Management']");
    private By dropdown = By.xpath("//ul[@class='oxd-dropdown-menu']//li");
    private By user = By.xpath("//a[@role='menuitem']");
    private By addBtn = By.xpath("//button[normalize-space()='Add']");

    private By employeeList = By.xpath("div[@class='oxd-autocomplete-wrapper'");
    private By listBox = By.xpath("div[@role='listbox']");

    private By userRole = By.xpath("//div[@class='oxd-select-text-input']");
    private By status = By.xpath("//div[@class='oxd-select-text-input' and contains(text(), 'Select')]");
    private By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By username = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]");
    private By password = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]");
    private By confirmPassword = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]");


    /*
     * $x("//div[@class=''and text()='Lisa']")
     * */

    public UserManagement(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void addUser() throws Exception {
        WebElement dropdown;
        this.navToAdmin();
        Utils.elementToBeClickable(wait, userMgmt).click();
        dropdown = Utils.elementToBeClickable(wait, this.dropdown);
        dropdown.findElement(user).click();

        /* add user */
        Utils.elementToBeClickable(wait, addBtn).click();

        inputFields(username, "username");
        inputFields(password, "password");
        inputFields(confirmPassword, "password");

//        WebElement roleList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userRole)).get(0);
//        roleList.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//div[@role='option']//span[contains(text(), 'Admin')]"))).click();
        selectOpts(userRole, 0, "Admin");
        selectOpts(userRole, 1, "Enabled");

        inputFields(employeeName, "Odis  Adalwin");

       /* // Now, wait for the options to become visible
        WebElement dropdownDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-autocomplete-wrapper']//*[@role='listbox']")));

        // Now, you can capture the values from the dropdown div
        java.util.List<WebElement> dropdownOptions = dropdownDiv.findElements(By.xpath("//*[role='option']"));

        // Loop through the dropdown options and capture their text
        for (WebElement option : dropdownOptions) {
            String optionText = option.getText();
            System.out.println("Dropdown Value: " + optionText);
        }*/


        Thread.sleep(5000);


        WebElement dropdownDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-autocomplete-wrapper']//div[@role='listbox']")));
        java.util.List<WebElement> dropdownOptions = dropdownDiv.findElements(By.xpath("//*[@role='option']"));
        dropdownOptions.get(0).click();

        /*for (WebElement option : dropdownOptions) {
            String optionText = option.getText();
            System.out.println("Dropdown Value: " + optionText);
        }*/
    }


    public void inputFields(By locator, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(text);
    }

    public void selectOpts(By locator, int index, String value) {
        /* select option field */
        WebElement optsEl = Utils.visibilityOfAllElementsLocatedBy(wait, locator).get(index);
        optsEl.click();
        Utils.presenceOfNestedElementLocatedBy(wait, optsEl, By.xpath(String.format("//*[@role='option']//*[contains(text(),%s)]", value))).click();

    }


}


/*
*  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='listbox']//*[contains(text(),'Searching')]")));

        // Now, wait for the options to become visible
        WebElement dropdownDiv = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='listbox']")));

        // Now, you can capture the values from the dropdown div
        java.util.List<WebElement> dropdownOptions = dropdownDiv.findElements(By.cssSelector("div[role='option']"));

        // Loop through the dropdown options and capture their text
        for (WebElement option : dropdownOptions) {
            String optionText = option.getText();
            System.out.println("Dropdown Value: " + optionText);
        }
*
* */