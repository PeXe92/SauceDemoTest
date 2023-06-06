package testsWithLogin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.UserLoggedInPage;

public class ProductSortHightoLow extends BaseTestWithLogin {
    @Test
    public void productSortHtoL() throws InterruptedException {
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        userLoggedInPage.navigateToProductSortContainer();
        userLoggedInPage.items();

        Thread.sleep(5000);
    }

}

