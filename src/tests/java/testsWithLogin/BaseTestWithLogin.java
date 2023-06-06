package testsWithLogin;

import io.github.bonigarcia.wdm.WebDriverManager;
import methods.LoginMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import tests.BaseTest;
import utilities.PropertyManager;

public class BaseTestWithLogin extends BaseTest {
    //WebDriver driver; // ovo je globalna varijabla
    //sada poistovecujemo base test i base test with login i sklanjamo globalni webdriver
    @Override // posto se buni zbog setup metode iz base testa sada radimo override method
    @BeforeMethod
    public void setup() {
        super.setup(); // zove se setup metoda iz super klase tj iz base testa
        /*System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized").addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com/"); i posto su se poistovetile metode sada se ovaj deo brise jer ovo isto ima i u base testu*/
        LoginPage loginPage = new LoginPage(driver);
        LoginMethods loginMethods = new LoginMethods(driver);
        loginMethods.performLogin(PropertyManager.getInstance().getValidUsername(),PropertyManager.getInstance().getValidPassword());
    }

    /*@AfterMethod
    public void closeBrowser() {
        driver.quit();
    } i samim tim i ceo after method nam je nepotreban stoga se uklanjaaa*/

}

