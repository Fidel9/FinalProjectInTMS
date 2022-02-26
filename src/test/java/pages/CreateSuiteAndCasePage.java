package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSuiteAndCasePage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Search for cases']")
    private WebElement searchCaseField;

    @FindBy(xpath = "//table[@class='style_table-1jtb1']")
    private WebElement titleRepository;

    @FindBy(xpath = "//span[@class='style_statistic-SjRZY']")
    private WebElement statistic;

    @FindBy(xpath = "//div[@class='d-flex']//a[@id='create-case-button']")
    private WebElement caseBuildProjectPage;

    public CreateSuiteAndCasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getCreateSuiteAndCaseSearchField() {
        return searchCaseField.getText();
    }//на данный моментне используется

    public String getCreateSuiteAndCaseTitle() {
        return titleRepository.getAttribute("innerText");
    }// clickSaveRepoProject.click();

    @Step("take statistic in repo")
    public String getStatisticRepo() {
        return statistic.getText();
    }

    @Step("open create new case in suite and case page")
    public CreateTestCasePage createNewCase() {
        caseBuildProjectPage.click();
        return new CreateTestCasePage(driver);
    }
}

