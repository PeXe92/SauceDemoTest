package testsWithLogin;

import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import pages.UserLoggedInPage;

public class RemoveItemFromCart extends BaseTestWithLogin {
    @Test
    public void removeItem() {
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        userLoggedInPage.addRandomItemToCart().navigateToShoppingCart(); //chainovanje metoda
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeItemFromCart();
        shoppingCartPage.verifyCartisEmpty();

    }
}
