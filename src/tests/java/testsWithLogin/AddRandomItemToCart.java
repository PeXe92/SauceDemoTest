package testsWithLogin;

import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import pages.UserLoggedInPage;

public class AddRandomItemToCart extends BaseTestWithLogin {
    @Test
    public void addRandomItemToCart() {
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        userLoggedInPage.addRandomItemToCart();
        userLoggedInPage.navigateToShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.verifyItemIsInCart();

    }
}
