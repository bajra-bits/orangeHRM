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
                {"Admin", "Odis  Adalwin", "Enabled", "newuser2", "Test@1234", "Test@1234"},
                // Add more test data as needed
        };
    }

    @DataProvider(name = "searchUser")
    public static Object[][] searchUser() {
        return new Object[][]{
                {""},
                {"newuser2"},
                {"invaliduser"}
        };

    }

    @DataProvider(name = "role")
    public static Object[][] searchByRole() {
        return new Object[][]{
                {"Admin"},
                {"ESS"}
        };

    }

    @DataProvider(name = "status")
    public static Object[][] searchByStatus() {
        return new Object[][]{
                {"Enabled"},
                {"Disabled"}
        };
    }

    @DataProvider(name = "search")
    public static Object[][] search() {
        return new Object[][]{
                {"admin", "Admin", "Enabled"},
                {"user307", "ESS", "Disabled"}
        };
    }


    @DataProvider(name = "userToDelete")
    public static Object[][] userToDelete() {
        return new Object[][]{
                {"newUser1"},
                {"newuser2"}
        };
    }




}
