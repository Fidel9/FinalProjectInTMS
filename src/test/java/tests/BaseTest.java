package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
abstract public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    SignUpPage signUpPage;
    BillingHistoryPage billingHistoryPage;
    BillingPage billingPage;
    CreateTestCasePage createTestCasePage;
    CreateSuiteAndCasePage createSuiteAndCasePage;
    InvitesPage invitesPage;
    LastRepoPage lastRepoPage;
    NewProjectPage newProjectPage;
    PaymentPage paymentPage;
    ProjectsPage projectsPage;
    RepositoryPage repositoryPage;
    WorkspacePage workspacePage;

    String emailAdmin, passwordAdmin;

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


        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("url"));
        emailAdmin = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("users.demo.login"));
        passwordAdmin = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("users.demo.password"));
        Configuration.browser = "chrome";
        Configuration.clickViaJs =true;
        Configuration.savePageSource = false;
        Configuration.timeout = 10000;


        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        billingHistoryPage = new BillingHistoryPage(driver);
        billingPage = new BillingPage(driver);
        createTestCasePage = new CreateTestCasePage(driver);
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

