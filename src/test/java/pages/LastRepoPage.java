package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LastRepoPage extends BasePage {
    @FindBy(xpath = "//div[@class='flash-message']")
    private WebElement successFullTestCase;

    @FindBy(xpath = "//div[@class='flash-message']")
    private WebElement createdSuccessfullyProject;

    @FindBy(xpath = "//i[@class='far fa-trash']")
    public WebElement deleteCaseInRepo;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    public WebElement deleteCaseInRepo2;


    public LastRepoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("case was created successfully")
    public String getCaseWasCreatedSuccessfully() {
        return successFullTestCase.getText();
    }

    @Step("project was created successfully")
    public String getProjectWasCreatedSuccessfully() {
        return createdSuccessfullyProject.getText();
    }


    @Step("open create suite and case page")
    public CreateSuiteAndCasePage deleteCase() {
        deleteCaseInRepo.click();
        deleteCaseInRepo2.click();
        return new CreateSuiteAndCasePage(driver);
    }
}
