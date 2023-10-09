package testCase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageModal.UserManagement;
import testData.AdminData;

import java.util.List;

public class TestUserManagement extends BaseClass {

    @Test()
    public void testAddUserCancel() {
        UserManagement userMg = new UserManagement(driver, wait);
        userMg.cancel();
        logger.info("Add user cancel success");
    }

    @Test(priority = 1, dataProvider = "admin", dataProviderClass = AdminData.class)
    public void testAddUser(String role, String empName, String status, String username, String password, String confirmPassword) throws Exception {
        UserManagement userMg = new UserManagement(driver, wait);
        userMg.populate(role, empName, status, username, password, confirmPassword);
        Thread.sleep(1000);
        userMg.save();

        List<WebElement> errors = userMg.getErrors();
        if (!errors.isEmpty()) {
            for (WebElement el : errors) {
                logger.error(el.getText());
            }
            return;
        }

        logger.info("Add user success.");
    }

    @Test(priority = 2, dataProvider = "searchUser", dataProviderClass = AdminData.class)
    public void testSearchUser(String username) {
        List<WebElement> list;
        UserManagement userMg = new UserManagement(driver, wait);

        userMg.searchByUser(username);
        list = userMg.getList();
        if (list.isEmpty()) {
            logger.error("No records found");
            return;
        }

        logger.info("Total items in a list: " + list.size());
    }


    @Test(priority = 3)
    public void resetSearch() {
        List<WebElement> list;
        UserManagement userMg = new UserManagement(driver, wait);

        userMg.resetSearch();
        list = userMg.getList();
        if (list.isEmpty()) {
            logger.error("Reset failed!");
            return;
        }

        logger.info("Reset success");
    }

}
