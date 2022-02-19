package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
abstract public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(description = "Setup and start browser")
    public void setUp(ITestContext context) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
          //  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            BasePage.setDriver(driver);
        context.setAttribute("driver", driver);

    }



    @AfterMethod(alwaysRun = true, description = "Close")
    public void tearDown() {
        driver.close();
        driver.quit();
        log.info(">-----<конец теста>-----<");
    }
}

