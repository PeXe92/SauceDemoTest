package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertyManager;

public class BaseTest {
    public WebDriver driver; // ovo je globalna varijabla
    @BeforeMethod
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver(new ChromeOptions().addArguments("--start-maximized").addArguments("--remote-allow-origins=*"));
        driver.get(PropertyManager.getInstance().getUrl());
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    public WebDriver getDriver(){
        return driver; // javna metoda u base testu koja ce da vrati vrednost drivera
    }

}
