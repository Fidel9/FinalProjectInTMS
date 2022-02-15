package pages;

import org.openqa.selenium.Keys;
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

    public NewProjectPage() {
        PageFactory.initElements(driver, this);
    }

    public String getErrorCode() {
        return errorCode.getText();
    }

    public String getProjectWithTheSameCodeAlreadyExists() {
        return projectExist.getText();
    }

    public NewProjectPage createProject(String createProjectNameE,
                                        String createProjectCodeE) {
        createProjectName.sendKeys(createProjectNameE);
        createProjectCode.sendKeys(createProjectCodeE);
        return this;
    }

    public CreateSuiteAndCasePage createNewProjectSaveButton() {
        createProjectSaveButton.click();
        return new CreateSuiteAndCasePage();
    }


}


