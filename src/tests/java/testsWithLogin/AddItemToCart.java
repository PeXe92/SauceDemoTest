package testsWithLogin;

import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import pages.UserLoggedInPage;

public class AddItemToCart extends BaseTestWithLogin{
    @Test
    public void addItemToCart(){
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        userLoggedInPage.addBackpackToCart();
        userLoggedInPage.navigateToShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.verifyBackpackIsAdded("Remove");
    }
}
