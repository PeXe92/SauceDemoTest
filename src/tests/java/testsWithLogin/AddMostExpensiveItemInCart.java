package testsWithLogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import pages.UserLoggedInPage;

public class AddMostExpensiveItemInCart extends BaseTestWithLogin {
    @Test
    public void addMostExpensiveItemToCart() throws InterruptedException {
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        userLoggedInPage.addMostExpensiveItem();
        String itemName = userLoggedInPage.returnMostExpensiveItemName();
        userLoggedInPage.navigateToShoppingCart();
        Thread.sleep(3000);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertEquals(itemName, shoppingCartPage.returnItemName());

    }
}
