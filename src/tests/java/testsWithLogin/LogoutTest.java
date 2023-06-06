package testsWithLogin;

import methods.LogoutMethods;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserLoggedInPage;

public class LogoutTest extends BaseTestWithLogin {
    @Test
    public void LogoutTest() {
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        LogoutMethods logoutMethods = new LogoutMethods(driver);
        logoutMethods.performLogout();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLogout("Login");
    }
}
