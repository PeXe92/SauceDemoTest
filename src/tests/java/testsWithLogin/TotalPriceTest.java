package testsWithLogin;

import com.github.javafaker.Faker;
import dataGenerator.DataCreation;
import methods.CheckoutMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ShoppingCartPage;
import pages.UserLoggedInPage;

public class TotalPriceTest extends BaseTestWithLogin{
    @Test
    public void checkTotalPrice() throws InterruptedException {
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        WebElement inventoryItem = userLoggedInPage.addItemByName("Sauce Labs Onesie");
        String itemPriceAsString = inventoryItem.findElement(By.className("inventory_item_price")).getText();
        double itemPriceAsNumber = Double.parseDouble(itemPriceAsString.substring(1));

        WebElement secondInventoryItem = userLoggedInPage.addItemByName("Sauce Labs Bolt T-Shirt");
        String secondItemPriceAsString = secondInventoryItem.findElement(By.className("inventory_item_price")).getText();
        double secondItemPriceAsNumber = Double.parseDouble(secondItemPriceAsString.substring(1));

        double expectedTotalItemsPrice = itemPriceAsNumber + secondItemPriceAsNumber;
        userLoggedInPage.navigateToShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.navigateToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutMethods checkoutMethods = new CheckoutMethods(driver);
        checkoutMethods.fillCheckoutData();
        Assert.assertEquals(checkoutPage.returnTotalPriceAsNumber(), expectedTotalItemsPrice);
    }
}
