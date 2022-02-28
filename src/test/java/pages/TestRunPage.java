package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestRunPage extends BasePage{

    @FindBy(xpath = "//div[@class='d-flex project-row run-case-row']//span[@class='custom-control-indicator']")
    private WebElement clickTitleTestRun;

    @FindBy(xpath = "//div[@class='run-case-row-div run-case-row-title']//a[starts-with(text(),'Test_Authorization')]")
    private WebElement clickTitleTestRun2;

    @FindBy(xpath = "//h1[contains(text(),'Test_Authorization')]")
    private WebElement titleTestRun;


    @FindBy(xpath = "//div[starts-with(text(),'Test cases')]")
    private WebElement titleTestCase;


    @FindBy(xpath = "//a[contains(text(),'Test_Authorization')]//following::div[@class='run-case-row-div text-end run-case-row-controls']")
    private WebElement clickTestRunCaseDropdown;

    @FindBy(xpath = "//div[@class='dropdown-item']//a[@class='text-danger']")
    private WebElement selectRemoveCaseInDropdown;

    @FindBy(xpath = "//button[@class='btn btn-danger btn-very-wide']")
    private WebElement removeCase;

    public TestRunPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("get title test run in page test run")
    public  TestRunPage clickTestRunTest_Authorization() {
        clickTitleTestRun.click();
        clickTitleTestRun2.click();
      return this;
    }
    @Step("get title test run")
    public String  getTitleTestRun(){
      return   titleTestRun.getText();
    }

    @Step("get title test cases without suite")
    public String  getTestCasesWithoutSuite(){
        return   titleTestCase.getText();
    }

    @Step("delete test run")
    public TestRunPage RemoveCaseTestRunInPageExpressRun() {
       clickTestRunCaseDropdown.click();
       selectRemoveCaseInDropdown.click();
       removeCase.click();
        return this;
    }

}
