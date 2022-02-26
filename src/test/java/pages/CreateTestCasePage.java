package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTestCasePage extends BasePage {


    @FindBy(xpath = "//input[@type='Text']")
    private WebElement authorization;

    @FindBy(xpath = "//div[@class='notranslate css-12z288s-control']")
    private WebElement dropdownStatusList;

    @FindBy(xpath = "//div[@class=' css-1hwfws3']//div[text()='Actual']")
    private WebElement dropdownStatusValue;

    @FindBy(xpath = "//div[@id='severityGroup']")
    private WebElement dropdownSeverityList;

    @FindBy(xpath = "//div[contains(text(),'Minor')]")
    private WebElement dropdownSeverityValue;

    @FindBy(xpath = "//div[@id='priorityGroup']")
    private WebElement dropdownPriorityList;

    @FindBy(xpath = "//div[contains(text(),'Low')]")
    private WebElement dropdownPriorityValue;

    @FindBy(xpath = "//div[@id='typeGroup']")
    private WebElement dropdownTypeList;

    @FindBy(xpath = "//div[contains(text(),'Functional')]")
    private WebElement dropdownTypeValue;


    @FindBy(xpath = "//button[@id='save-case']")
    private WebElement clickSaveBuildRepoProject;


    public CreateTestCasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("create case repo")
    public CreateTestCasePage createCaseRepo(String authorizationN) {
        authorization.sendKeys(authorizationN);
        dropdownStatusList.click();
        dropdownStatusValue.click();

        dropdownSeverityList.click();  //на данный момент не используются
        dropdownSeverityValue.click();

        dropdownPriorityList.click();
        dropdownPriorityValue.click();

        dropdownTypeList.click();
        dropdownTypeValue.click();
        return this;
    }

    @Step("open page repository")
    public RepositoryPage repository() {
        clickSaveBuildRepoProject.click();
        return new RepositoryPage(driver);
    }
}

