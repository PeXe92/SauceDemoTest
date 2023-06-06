package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserLoggedInPage extends BasePage {
    public UserLoggedInPage(WebDriver driver) {
        super(driver);
    }

    By productsTitleBy = By.className("title");
    By burgerMenuBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By backpackAddToCartButtonBY = By.id("add-to-cart-sauce-labs-backpack");
    By shoppingCartIconBy = By.className("shopping_cart_link");
    By allAddToCartButtonsBy = By.xpath("//button[contains(@id,'add-to-cart')]");
    By allItemsBy = By.className("inventory_item");
    By priceBy = By.className("inventory_item_price");
    By itemNameBy = By.className("inventory_item_name");
    By productSortContainerBy = By.className("product_sort_container");


    public void verifyLogin(String expectedTextOnLogin) {
        assertStringEquals(readTextFromElement(productsTitleBy), expectedTextOnLogin);
    }

    public void navigateToBurgerMenu() {
        clickElement(burgerMenuBy);
    }

    public void clickLogoutButton() {
        clickElement(logoutButtonBy);
    }

    public void addBackpackToCart() {
        clickElement(backpackAddToCartButtonBY);
    }

    public void navigateToShoppingCart() {
        clickElement(shoppingCartIconBy);
    }

    public UserLoggedInPage addRandomItemToCart() {
        clickElement(selectRandomWebelement(allAddToCartButtonsBy)); /* chainovanje metoda skracuje kod
                                                                       i moze se pozvati navigate to shopping cart iz ove metode*/
        return this;
    }

    public void addMostExpensiveItem() {
        WebElement element = returnItemWithMaxPriceAsWebElement(allItemsBy, priceBy);
        element.findElement(By.tagName("button")).click();
    }

    public String returnMostExpensiveItemName() {
        WebElement element = returnItemWithMaxPriceAsWebElement(allItemsBy, priceBy);
        return element.findElement(itemNameBy).getText(); // ova metoda vraca najskuplji item i nalazi ime i kao takvog da ga vrati
    }

    public WebElement addItemByName(String itemName) { // zelimo da u samom testu kazemo konkretno ime itema
        WebElement element = returnItemWithSpecificNameAsWebElement(allItemsBy, itemNameBy, itemName); /*izdvojicemo taj webelement uz pomoc returnitemwithspecific name i ide zajednicku lokator za iteme
                                                                                                        i za jednicki lokator za ime itema i prosledice se tu neki item name u samom testu
                                                                                                         */
        element.findElement(By.tagName("button")).click(); // na takvom izdvojenom webelementu da pronadjemo jedino dugme koje postoji na tom webelementu (add to cart)
        return element;
    }
    public WebElement navigateToProductSortContainer(){
        WebElement sortDropdown = driver.findElement(productSortContainerBy);
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Price (high to low)");
        return sortDropdown;


    }
    public WebElement items (){
        WebElement element = returnSpecificSorting(allItemsBy);
        return element;
    }

    }



