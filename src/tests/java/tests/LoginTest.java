package tests;

import methods.LoginMethods;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserLoggedInPage;
import utilities.PropertyManager;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        LoginMethods loginMethods = new LoginMethods(driver);
        loginMethods.performLogin(PropertyManager.getInstance().getValidUsername(), PropertyManager.getInstance().getValidPassword());
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        userLoggedInPage.verifyLogin("Products");
    }
}
