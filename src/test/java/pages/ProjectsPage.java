package pages;

import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//a[@aria-label='Workspace']")
    private WebElement workspace;

    @FindBy(xpath = "//div[@class='user-menu']")
    private WebElement userMenu;

    @FindBy(xpath = "//div[@class='user-menu']//a")
    private WebElement openBilling;


    @FindBy(xpath = "//a[starts-with(text(),'Tms')]//following::td[@class='text-end']")
    private WebElement dropdownDeleteProjectProj;

    @FindBy(xpath = "//a[@href='/project/TMS/delete']")
    private WebElement selectDeleteInDropdownProj;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement deleteProjectButton;


    @FindBy(xpath = "//span[starts-with(text(),'Looks like')]")
    private WebElement  youDonNotHaveAnyProjects;

    public ProjectsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitleProjects() {
        return titleProjects.getText();
    }
    public ProjectsPage searchProjField(String searchProjE) {
        searchProjectsField.sendKeys(searchProjE, Keys.ENTER);
        return this;
    }
    public String getYouDonNotHaveAnyProjectsYet() {
        return youDonNotHaveAnyProjects.getText();
    }

    public NewProjectPage createNewProjectButton() {
        createNewProjectButton.click();
        return new NewProjectPage();
    }

    public WorkspacePage workspacePage() {
        workspace.click();
        return new WorkspacePage();
    }

    public BillingPage openBillingPage() {
        userMenu.click();
        openBilling.click();
        return new BillingPage();
    }

    public ProjectsPage deleteProjectNameProj() {
        dropdownDeleteProjectProj.click();
        selectDeleteInDropdownProj.click();
        deleteProjectButton.click();
        return this;
    }

}
