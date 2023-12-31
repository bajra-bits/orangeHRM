package pageModal;

import constants.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.util.List;

public class UserManagement extends Dashboard {
    private By userMgmt = By.xpath("//span[normalize-space()='User Management']");
    private By dropdown = By.xpath("//ul[@class='oxd-dropdown-menu']//li");
    private By user = By.xpath("//a[@role='menuitem']");
    private By addBtn = By.xpath("//button[normalize-space()='Add']");
    private By saveBtn = By.xpath("//button[@type='submit']");
    private By cancelBtn = By.xpath("//button[@type='button' and @data-v-10d463b7]");
    private By errors = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");


    private By selectEl = By.xpath("//div[@class='oxd-select-text-input']");
    private By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By listWrapper = By.xpath("//div[@role='listbox']");
    private By searchText = By.xpath("//div[@role='option' and text()='Searching....']");
    private By listOptions = By.xpath("//div[@role='option']");

    private By username = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]");
    private By password = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]");
    private By confirmPassword = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]");

    /* search */
    private By searchUsername = By.xpath("//input[@class='oxd-input oxd-input--active' and not(@data-v-636d6b87)]");
    private By searchDropdown = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']");
    private By searchBtn = By.xpath("//button[@type='submit']");
    private By resetBtn = By.xpath("//button[normalize-space()='Reset']");
    private By records = By.xpath("//div[@class='oxd-table-card']");
    private By countLabel = By.xpath("//span[@class='oxd-text oxd-text--span' and @data-v-7b563373 and @data-v-0dea79bd]");
    private By tableBody = By.xpath("//div[@class='oxd-table-body']");

    /* icons */
    private By trashIcon = By.xpath("//*[@class='oxd-icon bi-trash']");
    private By editIcon = By.xpath("//*[@class='oxd-icon bi-pencil-fill']");

    /* modal */
    private By modal = By.xpath("//div[@role='document']");
    private By modCloseBtn = By.xpath("//button[@data-v-a11b6690]");
    private By modCancelBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']");
    private By modalAcceptBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");


    public UserManagement(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void deleteUser() throws InterruptedException {
        Thread.sleep(1000);
        Utils.elementToBeClickable(wait, trashIcon).click();
        Utils.visibilityOfElementLocated(wait, modal);
    }

    public void editUser() {
        Utils.elementToBeClickable(wait, editIcon).click();
    }

    public void closeModal() {
        Utils.elementToBeClickable(wait, modCloseBtn).click();
    }

    public void modCancelBtn() {
        Utils.elementToBeClickable(wait, modCancelBtn).click();
    }

    public void modAcceptBtn() {
        Utils.elementToBeClickable(wait, modalAcceptBtn).click();
    }

    public void searchByUser(String username) {
        // navigation
        clickAdmin();
        WebElement el = Utils.visibilityOfElementLocated(wait, searchUsername);
        el.clear();
        el.sendKeys(username);
        Utils.elementToBeClickable(wait, searchBtn).click();
    }

    public void searchByRole(String role) {
        clickAdmin();
        selectDropdown(searchDropdown, 0, Utils.getOptionValue(role));
        Utils.elementToBeClickable(wait, searchBtn).click();
    }

    public void searchByStatus(String status) {
        clickAdmin();
        selectDropdown(searchDropdown, 1, Utils.getOptionValue(status));
        Utils.elementToBeClickable(wait, searchBtn).click();

    }

    public void search(String username, String role, String status) {
        clickAdmin();
        WebElement el = Utils.visibilityOfElementLocated(wait, searchUsername);
        el.clear();
        el.sendKeys(username);
        selectDropdown(searchDropdown, 0, Utils.getOptionValue(role));
        selectDropdown(searchDropdown, 1, Utils.getOptionValue(status));
        Utils.elementToBeClickable(wait, searchBtn).click();
    }

    public List<WebElement> getList() {
        // wait until table visible
        WebElement table = Utils.visibilityOfElementLocated(wait, tableBody);
        return table.findElements(records);
    }

    public void resetSearch() {
        // navigation
        clickAdmin();
        Utils.elementToBeClickable(wait, resetBtn);
    }

    public String getCountLabel() {
        return Utils.visibilityOfElementLocated(wait, countLabel).getText();
    }


    public void clickAdmin() {
        WebElement dropdown;
        this.navToAdmin();
        Utils.elementToBeClickable(wait, userMgmt).click();
        dropdown = Utils.elementToBeClickable(wait, this.dropdown);
        dropdown.findElement(user).click();
    }

    public void addAdmin() {
        // navigation
        clickAdmin();
        // add admin
        Utils.elementToBeClickable(wait, addBtn).click();
    }

    public void populate(String role, String empName, String status, String username, String password, String confirmPassword) throws Exception {
        if (!role.isEmpty()) {
            selectDropdown(selectEl, 0, Utils.getOptionValue(role));
        }

        if (!empName.isEmpty()) {
            // search employee options
            inputFields(employeeName, empName.substring(0,1));
            Utils.visibilityOfElementLocated(wait, listWrapper);
            Utils.invisibilityOf(driver, wait, searchText);
            List<WebElement> dropdownOptions = driver.findElements(listOptions);
            if (!dropdownOptions.isEmpty()) {
                for (WebElement el : dropdownOptions) {
                    el.click();
                    break;
                }
            }
        }

        if (!status.isEmpty()) {
            selectDropdown(selectEl, 1, Utils.getOptionValue(status));
        }

        if (!username.isEmpty()) {
            inputFields(this.username, username);
        }

        if (!password.isEmpty()) {
            inputFields(this.password, password);
        }

        if (!confirmPassword.isEmpty()) {
            inputFields(this.confirmPassword, confirmPassword);
        }
    }

    public void save() throws InterruptedException {
        Thread.sleep(3500);
        Utils.elementToBeClickable(wait, saveBtn).click();
    }

    public void cancel() {
        Utils.elementToBeClickable(wait, cancelBtn).click();

    }

    public List<WebElement> getErrors() throws InterruptedException {
        Thread.sleep(1500);
        return driver.findElements(errors);
    }


    public void inputFields(By locator, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(text);
    }

    public void selectDropdown(By locator, int index, String value) {
        /* select option field */
        WebElement dropdown = Utils.visibilityOfAllElementsLocatedBy(wait, locator).get(index);
        dropdown.click();
//        System.out.println(dropdown.getAttribute("innerHTML"));
        dropdown.findElement(By.xpath(String.format("//*[@role='option']//*[contains(text(),'%s')]", value))).click();
//        Utils.presenceOfNestedElementLocatedBy(wait, dropdown, By.xpath(String.format("//*[@role='option']//*[contains(text(),%s)]", value))).click();
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