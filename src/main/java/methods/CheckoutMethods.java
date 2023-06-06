package methods;

import com.github.javafaker.Faker;
import dataGenerator.DataCreation;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

public class CheckoutMethods extends CheckoutPage {
    public CheckoutMethods(WebDriver driver) {
        super(driver);
    }
    /*public void fillCkeckoutData(String firstName, String lastName, String postalCode){
        writeFirstName(firstName);
        writeLastName(lastName);
        writePostalCode(postalCode);
        clickContinueButton();
    }*/
    public void fillCheckoutData(){
        String firstName = DataCreation.generateFirstName();
        writeFirstName(firstName);
        String lastName = DataCreation.generateLastName();
        writeLastName(lastName);
        String zipCode = DataCreation.generateZipCode();
        writePostalCode(zipCode);
        clickContinueButton();
}
    }
