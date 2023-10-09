package testCase;

import org.testng.annotations.Test;
import pageModal.UserManagement;

public class TestUserManagement extends BaseClass {

    @Test
    public void testAddUser() throws Exception {
        UserManagement userMg = new UserManagement(driver, wait);
        userMg.addUser();
    }
}
