package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    WebDriver driver; // deklarisemo globalni drajver kako bismo mogli da ga korsitimo u vise metoda
    WebDriverWait wait;

    public BasePage(WebDriver driver) {  // konstruktor base pageta ce da ocekuje nekakav driver iz base testa
        this.driver = driver; // komandom this poistovecuje se globalni i lokani driver
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisibility(By elementLocator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementLocator)); // da sam element sa tim lokatorom bude vidljiv na samoj stranici
    }

    public void waitVisibility(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement)); // ceka vidljivost nekog webElementa
    }

    public void writeText(By elementLocator, String text) {
        driver.findElement(elementLocator).sendKeys(text);
    }

    public void clickElement(By elementLocator) {
        waitVisibility(elementLocator);
        driver.findElement(elementLocator).click();
    }

    public void clickElement(WebElement webElement) {
        waitVisibility(webElement);
        webElement.click();
    }

    public String readTextFromElement(By elementLocator) {
        waitVisibility(elementLocator);
        return driver.findElement(elementLocator).getText(); //chainovanje metoda ne treba nam objekat elementa jer ova metoda ga vec vraca
    }

    public void assertStringEquals(String actualTextOnElement, String expectedTextOnElement) {
        Assert.assertEquals(actualTextOnElement, expectedTextOnElement);
    }

    public String readAttributeValue(By elementLocator, String attribute) {
        waitVisibility(elementLocator);
        return driver.findElement(elementLocator).getAttribute(attribute); // vraca 1 webElement
    }

    public WebElement selectRandomWebelement(By elementLocator) { // metoda koja trazi sve webelemenete
        List<WebElement> webElementList = driver.findElements(elementLocator); // radimo findElements metoda koja vraca listu webElemenata
        Random random = new Random(); // trazi random webelement
        int size = webElementList.size(); // proverava se velicina liste i to se cuva u varijabli size()
        int selection = random.nextInt(size - 1); // uz pomoc objekta te klase da izabere neku int vrednost ali max vrednost je velicina liste pa minus 1 zbog indeksa
        return webElementList.get(selection); // return uzmi tu listu webElemenata trazi sad index zbog toga smo isli size -1
        /* findelements ce naci sve elemente koji imaju taj neki lokator (By elementLocator) tako pronadjene elemente
        ce da spakuje u listu web elemenata sa imenom WebelementList
        uz pomoc webelementlist.size() proveravamo kolika je lista cuvamo neku varijablu size
        pa uz pomoc klase random cuvamo neki random broj od nule do size -1 cuvamo to u selection
        uz pomocu get metode biramo index od 0 do n-1 bira se random 0 - 5 i kao takav vracen
         */
    }

    public void isElementDisplayed(By elementLocator) {
        Assert.assertTrue(driver.findElement(elementLocator).isDisplayed());
    }

    public boolean isElementNotDisplayed(By elementLocator) {  // trazi neki lokator sa kojim ce da radi
        if (driver.findElements(elementLocator).size() > 0) {//proveravamo velicinu liste i ovde
            return false;
        } else {
            return true;
        }

    }

    public WebElement returnItemWithMaxPriceAsWebElement(By elementLocator, By itemPriceLocator) {
        List<WebElement> itemsList = driver.findElements(elementLocator); // koji je to zajednicki lokator za webelemente -itemList uzima sve webelemente sa tim lokatorom
        if (itemsList.size() == 0) {
            throw new SkipException("No available items");
        } else {
            String priceAsString = itemsList.get(0).findElement(itemPriceLocator).getText(); //  vata nulti index webelementa trazi mu cenu preko lokatora itempricelocator i onda gettext metoda cita cenu ;
            double maxPrice = Double.parseDouble(priceAsString.substring(1)); // string pretvaramo u double pars medotom i substring se koristi da se skine $ sign
            WebElement maxPriceElement = itemsList.get(0); // krece se od pretpostavke da prvi element u listi ima najvecu cenu
            for (int i = 1; i < itemsList.size(); i++) { //uvodi se brojac krece se od 1 jer 0 vec koristimo. Sve dok je I manji od velicine nase liste radice se neka logika i uvecace se brojac
                String price = itemsList.get(i).findElement(itemPriceLocator).getText(); // poredimo cenu i-tog elementa
                double priceAsNumber = Double.parseDouble(price.substring(1)); // prebacuje se u double
                if (priceAsNumber > maxPrice) { // poredi se if metodom
                    maxPrice = priceAsNumber; // max prajsu ce se dodeliti cena itog elementa
                    maxPriceElement = itemsList.get(i); // a maxprajsu ce se dodeliti iti element
                }
            }
            return maxPriceElement; // kada for petlja prodje kroz sve elemente metoda vraca element koja sadrzi maksimalnu cenu
        }
    }

    public WebElement returnItemWithSpecificNameAsWebElement(By elementLocator, By itemNameLocator, String itemName) {
        List<WebElement> itemList = driver.findElements(elementLocator); // isto ko i gore lista svih webelemenata
        WebElement elementWithSpecificName = null; // radi se ovaj webelement i pocetna wrednost mu je null
        for (WebElement element : itemList) { // vadi jedan po jedan webelement iz liste web elemenata
            String item = element.findElement(itemNameLocator).getText();  // na tom webelementu pronadji ime tog itema i sacuvaj ga u ovaj string
            if (item.equals(itemName)) { // u koliko je pronadjeno ime jednako imenu koje smo prosledili (imenu itema koje zelimo da pronadjemo)
                elementWithSpecificName = element; // element sa specificnim imenom je element iz for petlje

                break; // ukoliko je jednako izadji iz for petlje
            }
        }
        return elementWithSpecificName; // i na kraju samo vratimo taj webelement
    }

    public WebElement returnSpecificSorting(By elementLocator) {
        List<WebElement> products = driver.findElements(elementLocator);
        for (int i = 1; i > products.size(); i++) {
            WebElement currentProduct = products.get(i);
            WebElement previousProduct = products.get(i - 1);
            String currentProductPrice = currentProduct.findElement(By.className("inventory_item_price")).getText();
            String previousProductPrice = previousProduct.findElement(By.className("inventory_item_price")).getText();
            Assert.assertTrue(Double.parseDouble(currentProductPrice.substring(1)) >= Double.parseDouble(previousProductPrice.substring(1))); // asertacija ne treba da stoji ovde boze moj
        }
        return products.get(0); // vraca prvi produkt u listi
    }
}