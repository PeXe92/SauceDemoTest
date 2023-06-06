package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameFieldBy = By.id("user-name"); // id je metoda znamo zbog zagrade dolazi iz BY klase
    By passwordFieldBy = By.id("password");
    By loginButtonBy = By.id("login-button");
    By errorMessageBy = By.xpath("//h3[@data-test='error']");
    public void writeUsername(String username){
        writeText(usernameFieldBy, username);
    }
    public void writePassword(String password){
        writeText(passwordFieldBy, password);
    }
    public void clickLoginButton(){
        clickElement(loginButtonBy);
    }

    public void verifyFailedLogin(String expectedText) {
        assertStringEquals(readTextFromElement(errorMessageBy), expectedText);

    }

    public void verifyLogout(String expectedText) {
        assertStringEquals(readAttributeValue(loginButtonBy, "value"), expectedText);

    }
}
