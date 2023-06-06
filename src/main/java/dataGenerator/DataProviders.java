package dataGenerator;

import org.testng.annotations.DataProvider;
import utilities.PropertyManager;

public class DataProviders {
    @DataProvider(name = "failedLogin")
    public Object[][] getFailLoginData() {
        return new Object[][]
                {
                        {PropertyManager.getInstance().getInvalidUsername(), PropertyManager.getInstance().getInvalidPassword(), "Epic sadface: Username and password do not match any user in this service"},
                        {"", "", "Epic sadface: Username is required"},
                        {"", PropertyManager.getInstance().getValidPassword(), "Epic sadface: Username is required"},
                        {PropertyManager.getInstance().getValidUsername(), PropertyManager.getInstance().getInvalidPassword(), "Epic sadface: Username and password do not match any user in this service"}

                };
    }

    @DataProvider(name = "sucessfullLogin")
    public Object[][] getSucessfullLoginData() {
        return new Object[][]
                {
                        {PropertyManager.getInstance().getValidUsername(), PropertyManager.getInstance().getValidPassword()},
                };

    }
}