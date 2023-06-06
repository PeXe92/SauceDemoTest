package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {
    private static String url, validUsername, validPassword, invalidUsername, invalidPassword;
    private static PropertyManager instance;
    public static PropertyManager getInstance() { // SINGLETON DESIGN PATTERN
        if (instance == null) {
            instance = new PropertyManager();
            instance.loadData();
        }
        return instance;
    }

    private void loadData() {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/configuration.properties");
            properties.load(fis);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        url = properties.getProperty("url");
        validUsername = properties.getProperty("validUsername");
        validPassword = properties.getProperty("validPassword");
        invalidUsername = properties.getProperty("invalidUsername");
        invalidPassword = properties.getProperty("invalidPassword");
    }
    public static String getUrl() {
        return url;
    }

    public static String getValidUsername() {
        return validUsername;
    }

    public static String getValidPassword() {
        return validPassword;
    }

    public static String getInvalidUsername() {
        return invalidUsername;
    }

    public static String getInvalidPassword() {
        return invalidPassword;
    }


}


