package tests;

import dataGenerator.DataProviders;
import methods.LoginMethods;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FailedLoginTest extends BaseTest {
    @Test(dataProvider = "failedLogin",dataProviderClass = DataProviders.class)
    public void failedLogin(String username,String password,String error) {
        LoginPage loginPage = new LoginPage(driver);
        LoginMethods loginMethods = new LoginMethods(driver);
        loginMethods.performLogin(username,password);
        loginPage.verifyFailedLogin(error);

    }
}
