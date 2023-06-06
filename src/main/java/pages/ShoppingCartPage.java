package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By removeBackpackButtonBy = By.id("remove-sauce-labs-backpack");
    By removeButtonBy = By.xpath("//button[text()='Remove']");
    By cartItemsBy = By.className("cart_item");
    By cartItemNameBy = By.className("inventory_item_name");
    By checkoutButtonBy = By.id("checkout");

    public void verifyBackpackIsAdded(String expectedText) {
        assertStringEquals(readTextFromElement(removeBackpackButtonBy), expectedText);
    }

    public void verifyItemIsInCart() {
        isElementDisplayed(removeButtonBy);
    }

    public void removeItemFromCart() {
        clickElement(removeButtonBy);
    }


    public void verifyCartisEmpty() {
        Assert.assertTrue(isElementNotDisplayed(removeButtonBy));
    /*ova metoda ce pronaci removebutton ukoliko ga pronadje vratice false i assert true ce da padne
      ukoliko ova metoda ne pronadje removeButton vratice true i metoda ce da vrati da je test prosao*/
    }

    public String returnItemName() {
        return driver.findElement(cartItemsBy).findElement(cartItemNameBy).getText(); // pronaci ce item u cartu unutar itema nadje ime get text dohvati ime i return metoda ce da ga vrati

    }
    public void navigateToCheckout(){
        clickElement(checkoutButtonBy);
    }
}