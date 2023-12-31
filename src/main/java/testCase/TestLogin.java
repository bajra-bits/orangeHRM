package testCase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageModal.Login;
import utils.Driver;

import java.util.List;

public class TestLogin extends BaseClass {

    @Parameters({"username", "password"})
    @Test
    public void verifyLogin(String username, String password) throws InterruptedException {
        Login loginModal = new Login(driver,wait );

        loginModal.login(username, password);
        List<WebElement> emptyFields = loginModal.getEmptyField();
        List<WebElement> error = loginModal.getError();

        if (!emptyFields.isEmpty()) {
            int emptySize = emptyFields.size();
            String errorText = emptyFields.get(0).getText();
            boolean isUsernameEmpty = username.trim().isEmpty();
            if (emptySize == 2) {
                logger.error("All fields empty");
                return;
            }

            if (isUsernameEmpty) {
                logger.error("Username " + errorText);
                return;
            }

            logger.error("Password " + errorText);
            return;
        }

        if (!error.isEmpty()) {
            for (WebElement el : error) {
                logger.error(el.getText());
            }
            return;
        }

        logger.info("Login successful");

    }

    @DataProvider(name = "login")
    public Object[][] dataSet() {
        return new Object[][]{
                {"", ""},
                {"admin", ""},
                {"", "admin123"},
                {"admin", "admin123"},

        };
    }


}
