package testCase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageModal.UserManagement;

import java.util.List;

public class TestUserManagement extends BaseClass {

    @Test
    public void testAddUserCancel() throws Exception {
        UserManagement userMg = new UserManagement(driver, wait);
        userMg.populate();
        userMg.cancel();
        logger.info("Add user cancel success");
    }

    @Test(priority = 1)
    public void testAddUser() throws Exception {
        UserManagement userMg = new UserManagement(driver, wait);
        userMg.populate();
        userMg.save();

        List<WebElement> errors = userMg.getErrors();
        if(!errors.isEmpty()) {
            for(WebElement el : errors) {
                logger.error(el.getText());
            }
            return;
        }

        logger.info("Add user success.");
    }
}
