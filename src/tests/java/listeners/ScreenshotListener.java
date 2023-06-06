package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.File;
import java.util.Date;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
        try{
            Object currentClass = result.getInstance();
            WebDriver driver = ((BaseTest) currentClass).getDriver();
            takeScreenshot(driver, result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void takeScreenshot(WebDriver driver, ITestResult result){ // driver na kome se to browseru pravi SC i rezultat testa koji se trenutno izvrsava
        TakesScreenshot screenshot =((TakesScreenshot) driver);
        File tempFile = screenshot.getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        String screenshotName = result.getName()+"_"+date.toString().replace(":","_")
                .replace(" ","_");
        try{
            FileUtils.copyFile(tempFile, new File("./Screenshots/"+screenshotName+".png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

