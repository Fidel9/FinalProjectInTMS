package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseBuildPage extends BasePage {


    @FindBy(xpath = "//input[@type='Text']")
    private WebElement authorization;

    @FindBy(xpath = "//div[@class='notranslate css-12z288s-control']")
    private WebElement dropdownStatusList;

    @FindBy(xpath = "//div[@class=' css-1hwfws3']//div[text()='Actual']")
    private WebElement dropdownStatusValue;

    @FindBy(xpath = "//div[@id='severityGroup']//i[@class='color-minor fas fa-angle-down']")
    private WebElement dropdownSeverityList;

    @FindBy(xpath = "//div[@id='severityGroup']//i[@class='color-minor fas fa-angle-down']")
    private WebElement dropdownSeverityValue;

    @FindBy(xpath = "//button[@id='save-case']")
    private WebElement clickSaveBuildRepoProject;

    public CaseBuildPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("create case repo")
    public CaseBuildPage createCaseRepo(String authorizationN) {
        authorization.sendKeys(authorizationN);
        dropdownStatusList.click();
        dropdownStatusValue.click();
        //  dropdownSeverityList.click();  //на данный момент не используются
        //  dropdownSeverityValue.click();
        return this;
    }

    @Step("open page repository")
    public RepositoryPage repository() {
        clickSaveBuildRepoProject.click();
        return new RepositoryPage(driver);
    }
}

