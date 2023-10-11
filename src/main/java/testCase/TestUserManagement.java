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
        userMg.addAdmin();
        userMg.cancel();
        logger.info("Add user cancel success");
    }

    @Test(priority = 1, dataProvider = "admin", dataProviderClass = AdminData.class)
    public void testAddUser(String role, String empName, String status, String username, String password, String confirmPassword) throws Exception {
        UserManagement userMg = new UserManagement(driver, wait);
        userMg.addAdmin();
        userMg.populate(role, empName, status, username, password, confirmPassword);
        Thread.sleep(2000);
        userMg.save();

        List<WebElement> errors = userMg.getErrors();
        if (!errors.isEmpty()) {
            for (WebElement el : errors) {
                logger.error(el.getText());
            }
            logger.info("****** EOF *******");
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

    @Test(priority = 4, dataProvider = "role", dataProviderClass = AdminData.class)
    public void testSearchByRole(String role) {
        List<WebElement> list;
        UserManagement userMg = new UserManagement(driver, wait);

        userMg.searchByRole(role);
        list = userMg.getList();
        if (list.isEmpty()) {
            logger.error("No records found");
            return;
        }

        logger.info(String.format("***** Showing records for %s *****", role));

        logger.info(String.format("Total items in a list %d",  list.size()));
    }

    @Test(priority = 5, dataProvider = "status", dataProviderClass = AdminData.class)
    public void testSearchByStatus(String status) {
        List<WebElement> list;
        UserManagement userMg = new UserManagement(driver, wait);

        userMg.searchByStatus(status);
        list = userMg.getList();
        if (list.isEmpty()) {
            logger.error("No records found");
            return;
        }

        logger.info(String.format("**** Showing records for %s ****", status));
        logger.info(String.format("Total items  in a list %d",  list.size()));
    }

    @Test(priority = 6, dataProvider = "search", dataProviderClass = AdminData.class)
    public void testSearch(String username, String role, String status) {
        List<WebElement> list;
        UserManagement userMg = new UserManagement(driver, wait);

        userMg.search(username, role, status);
        list = userMg.getList();
        if (list.isEmpty()) {
            logger.error("No records found");
            return;
        }

        logger.info(String.format("***** Showing records for %s:%s:%s *****", username, role, status));
        logger.info(String.format("Total items in a list %d",  list.size()));
    }


    @Test(priority = 7, dataProvider = "userToDelete", dataProviderClass = AdminData.class)
    public void deleteUser(String username) {
        List<WebElement> list;
        UserManagement userMg = new UserManagement(driver, wait);

        userMg.searchByUser(username);
        list = userMg.getList();
        if (list.isEmpty()) {
            logger.error("No records found");
            return;
        }

        // Test modal close
        userMg.deleteUser();
        userMg.closeModal();
        logger.info("Close Modal");

        // Test modCancelBtn
        userMg.deleteUser();
        userMg.modCancelBtn();
        logger.info("Cancel Delete User");

        // Delete user
        userMg.deleteUser();
        userMg.modAcceptBtn();

        list = userMg.getList();
        if (!list.isEmpty()) {
            logger.error("Delete user failed");
            return;
        }

        logger.info("Delete user success");
    }
}
