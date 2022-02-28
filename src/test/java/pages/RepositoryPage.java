package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RepositoryPage extends BasePage {

    @FindBy(xpath = "//td[@class='style_codeCell-1EsJ-']//a")
    private WebElement testCasesWithoutSuite;

    @FindBy(xpath = "//table[@class='style_table-1jtb1']")
    private WebElement searchFieldTitleInRepo;


    @FindBy(xpath = "//label[@class='style_checkbox-1sXFN style_checkbox-1ztec style_inHeader-18FWp']")
    private WebElement input;

    @FindBy(xpath = "//button[contains(text(),'Run')]")
    private WebElement buttonRunTest;

    @FindBy(xpath = "//div[@class='flash-message']//div[@class='alert alert-error alert-dismissible show']")
    private WebElement messageLimitOfActiveRun;

    @FindBy(xpath = "//div[@class='modal-footer mt-1']//button[contains(text(),'Start test run')]")
    private WebElement startExpressRunButton;

    public RepositoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("Search Field Title In Repo")
    public String getSearchFieldTitleInRepo() {
        return searchFieldTitleInRepo.getText();
    }//на данный момент не используется

    @Step("message you have reached a limited of active run")
    public String getMessageYouHaveReachedALimitOfActiveRun() {
        return  messageLimitOfActiveRun.getText();
    }

    @Step("open last repo page")
    public LastRepoPage lastPageInRepo() {
        testCasesWithoutSuite.click();
        return new LastRepoPage(driver);
    }

    @Step("open test run")
    public TestRunPage openTestRun(){
        input.click();
        buttonRunTest.click();
        startExpressRunButton.click();
        return new TestRunPage(driver);
    }

     @Step("check if you have reached a limit of active run in test run")
     public RepositoryPage checkErrorFlashMessage(){
         input.click();
         buttonRunTest.click();
         startExpressRunButton.click();
        return this;
     }
}

