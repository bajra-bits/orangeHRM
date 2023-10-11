package testData;

import org.testng.annotations.DataProvider;

public class AdminData {
    @DataProvider(name = "admin")
    public static Object[][] admin() {
        return new Object[][]{
                {"", "", "", "", "", ""},
                {"Admin", "", "", "", "", ""},
                {"Admin", "Odis  Adalwin", "", "", "", ""},
                {"Admin", "Odis  Adalwin", "Enabled", "", "", ""},
                {"Admin", "Odis  Adalwin", "Enabled", "newuser2", "", ""},
                {"Admin", "Odis  Adalwin", "Enabled", "newuser2", "Test", ""},
                {"Admin", "Odis  Adalwin", "Enabled", "newuser2", "Testagain", ""},
                {"Admin", "Odis  Adalwin", "Enabled", "newuser2", "Test@1234", ""},
                {"Admin", "Odis  Adalwin", "Enabled", "newuser2", "Test@1234", "Test@123"},
                {"ESS", "Odis  Adalwin", "Enabled", "newuser3", "Test@1234", "Test@1234"},
                {"ESS", "Odis  Adalwin", "Enabled", "newuser3", "Test@1234", "Test@1234"},

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
                {"invaliduser"},
                {"newuser3"}
        };
    }




}
