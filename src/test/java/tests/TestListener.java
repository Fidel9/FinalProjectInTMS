package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

@Log4j2
public class TestListener implements ITestListener {

    /* @Override
     public void onTestStart(ITestResult result){
         System.out.printf("Test started: %s \n", result.getName());
     }
     public void onTestSuccess(ITestResult result){
         System.out.printf("Test success: %s \n", result.getName());
     }
     public void onTestFailure(ITestResult result) {
         System.out.printf("Test failed: %s \n", result.getName());
     }*/
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        log.debug("Test %s failed", result.getName());
        AllureUtils.takeScreenshot(driver);
    }

}




