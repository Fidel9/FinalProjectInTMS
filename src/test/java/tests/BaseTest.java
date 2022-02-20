package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
abstract public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    SignUpPage signUpPage;
    BillingHistoryPage billingHistoryPage;
    BillingPage billingPage;
    CaseBuildPage caseBuildPage;
    CreateSuiteAndCasePage createSuiteAndCasePage;
    InvitesPage invitesPage;
    LastRepoPage lastRepoPage;
    NewProjectPage newProjectPage;
    PaymentPage paymentPage;
    ProjectsPage projectsPage;
    RepositoryPage repositoryPage;
    WorkspacePage workspacePage;

    @BeforeMethod(description = "Setup and start browser")
    public void setUp(ITestContext context) {
        log.info("<----- начало теста ----->");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // BasePage.setDriver(driver);
        context.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        billingHistoryPage = new BillingHistoryPage(driver);
        billingPage = new BillingPage(driver);
        caseBuildPage = new CaseBuildPage(driver);
        createSuiteAndCasePage = new CreateSuiteAndCasePage(driver);
        invitesPage = new InvitesPage(driver);
        lastRepoPage = new LastRepoPage(driver);
        newProjectPage = new NewProjectPage(driver);
        paymentPage = new PaymentPage(driver);
        projectsPage = new ProjectsPage(driver);
        repositoryPage = new RepositoryPage(driver);
        workspacePage = new WorkspacePage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Close")
    public void tearDown() {
        driver.close();
        driver.quit();
        log.info(">-----<конец теста>-----<");
    }
}

