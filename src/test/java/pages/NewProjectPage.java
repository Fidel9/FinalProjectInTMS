package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProjectPage extends BasePage {

    @FindBy(xpath = "//input[@type='text']")
    private WebElement createProjectName;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement createProjectCode;

    @FindBy(xpath = "")
    private WebElement createProjectDescription;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createProjectSaveButton;

    @FindBy(xpath = "//div[text()='The code must be at least 2 characters.']")
    private WebElement errorCode;

    @FindBy(xpath = "//div[@class='flash-message']")
    private WebElement projectExist;

    public NewProjectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("error code")
    public String getErrorCode() {
        return errorCode.getText();
    }

    @Step("project with The same Code already exists")
    public String getProjectWithTheSameCodeAlreadyExists() {
        return projectExist.getText();
    }

    @Step("open new project page and create project")
    public NewProjectPage createProject(String createProjectNameE,
                                        String createProjectCodeE) {
        createProjectName.sendKeys(createProjectNameE);
        createProjectCode.sendKeys(createProjectCodeE);
        return this;
    }

    @Step("open create suite and case page")
    public CreateSuiteAndCasePage createNewProjectSaveButton() {
        createProjectSaveButton.click();
        return new CreateSuiteAndCasePage(driver);
    }
}


