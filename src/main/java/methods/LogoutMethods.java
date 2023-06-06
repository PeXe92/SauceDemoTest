package methods;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.UserLoggedInPage;

public class LogoutMethods extends UserLoggedInPage {

    public LogoutMethods(WebDriver driver) {
        super(driver);
    }
    public void performLogout(){
        navigateToBurgerMenu();
        clickLogoutButton();
    }
}
