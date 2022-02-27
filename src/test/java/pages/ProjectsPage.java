package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchProjectsField;

    @FindBy(xpath = "//a[starts-with(text(),'Tms')]")
    private WebElement titleProjects;


    @FindBy(xpath = "//div[@class='me-3']/a")
    private WebElement createNewProjectButton;

    @FindBy(xpath = "//a[@href='https://app.qase.io/workspace']")//a[@aria-label='Workspace']
    private WebElement workspace;

    @FindBy(xpath = "//div[@class='user-menu']")
    private WebElement userMenu;

    @FindBy(xpath = "//div[@class='user-menu']//a")
    private WebElement openBilling;


    @FindBy(xpath = "//a[starts-with(text(),'Tms')]//following::td[@class='text-end']")
    private WebElement dropdownDeleteProjectProj;

    @FindBy(xpath = "//a[@href='/project/TMS/delete']")
    private WebElement selectDeleteInDropdownProj;

    @FindBy(xpath = "//a[@href='/project/TESTPROJEC/delete']")
    private WebElement selectDeleteForTestRun;

    @FindBy(xpath = "//a[starts-with(text(),'TestProject')]//following::td[@class='text-end']")
    private WebElement dropdownDeleteProjectForTestRun;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement deleteProjectButton;


    @FindBy(xpath = "//span[starts-with(text(),'Looks like')]")
    private WebElement youDonNotHaveAnyProjects;


    @FindBy(xpath = "//a[starts-with(text(),'TestProject')]")
    private WebElement pageRepositoryWithoutCreateNewProject;



    @FindBy(xpath = "//a[@href='/project/TESTPROJEC']")
    private WebElement clickProject;

    @FindBy(xpath = "//span[starts-with(text(),'Test Runs')]")
    private WebElement clickButtonTestRun;

    @FindBy(xpath = "//a[@href='/run/TESTPROJEC/dashboard/1']//following::td[@class='text-end']//a")
    private WebElement clickButtonTestRunDropdown;

    @FindBy(xpath = "//a[@href='/run/TESTPROJEC/delete/1']")
    private WebElement selectDeleteInDropdownTestProjec;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonDeleteTesRun;

    @FindBy(xpath = "//a[@href='/run/TESTPROJEC/dashboard/1']")
    private WebElement clickButtonTestRunCase;

    public ProjectsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("title project")
    public String getTitleProjects() {
        return titleProjects.getText();
    }

    @Step("search project for search field in project page")
    public ProjectsPage searchProjField(String searchProjE) {
        searchProjectsField.sendKeys(searchProjE, Keys.ENTER);
        return this;
    }

    @Step("you Don't have any projects yet")
    public String getYouDonNotHaveAnyProjectsYet() {
        return youDonNotHaveAnyProjects.getText();
    }

    @Step("button create new project ")
    public NewProjectPage createNewProjectButton() {
        createNewProjectButton.click();
        return new NewProjectPage(driver);
    }

    @Step("open workspace page")
    public WorkspacePage workspacePage() {
        workspace.click();
        return new WorkspacePage(driver);
    }

    @Step("open billing page")
    public BillingPage openBillingPage() {
        userMenu.click();
        openBilling.click();
        return new BillingPage(driver);
    }

    @Step("delete project in project page")
    public ProjectsPage deleteProjectNameTms() {
        dropdownDeleteProjectProj.click();
        selectDeleteInDropdownProj.click();
        deleteProjectButton.click();
        return this;
    }

    @Step("delete project in project page")
    public ProjectsPage deleteProjectFromTestRun() {
        dropdownDeleteProjectForTestRun.click();
        selectDeleteForTestRun.click();
        deleteProjectButton.click();
        return this;
    }

    @Step("open repository page with click exist project")
    public RepositoryPage openPageRepositoryWithoutCreateNewProject(){
        pageRepositoryWithoutCreateNewProject.click();
        return new RepositoryPage(driver);
    }

    @Step("delete test run")
    public ProjectsPage deleteTestRunInPageExpressRun() {
        clickProject.click();
        clickButtonTestRun.click();
        clickButtonTestRunDropdown.click();
        selectDeleteInDropdownTestProjec.click();
        buttonDeleteTesRun.click();
        return this;
    }
    @Step("delete test run")
    public TestRunPage openTestRunPage() {
        clickProject.click();
        clickButtonTestRun.click();
        clickButtonTestRunCase.click();
        return new TestRunPage(driver);
    }
}
