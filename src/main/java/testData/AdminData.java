package testData;

import org.testng.annotations.DataProvider;

public class AdminData {

    @DataProvider(name = "clearAdmin")
    public static Object[][] clearAdmin() {
        // Define your test data here as a 2D array
        return new Object[][]{
                {"Admin", "Lisa Andrews", "Enabled", "Super Groot", "Test@1234", "Test@1234"},
                // Add more test data as needed
        };
    }

    @DataProvider(name = "admin")
    public static Object[][] admin() {
        // Define your test data here as a 2D array
        return new Object[][]{
                {"Admin", "Lisa Andrews", "Enabled", "newuser1", "Test@1234", "Test@1234"},
                // Add more test data as needed
        };
    }

    @DataProvider(name = "searchUser")
    public static Object[][] searchUser() {
        return new Object[][]{
                {""},
                {"newuser"},
                {"invaliduser"}
        };

    }
}
