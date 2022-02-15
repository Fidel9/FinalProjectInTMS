package pages;

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


    public LastRepoPage() {
        PageFactory.initElements(driver,this);}

    public String getCaseWasCreatedSuccessfully(){return successFullTestCase.getText();}

    public String getProjectWasCreatedSuccessfully(){return createdSuccessfullyProject.getText();}



    public CreateSuiteAndCasePage deleteCase(){
        deleteCaseInRepo.click();
        deleteCaseInRepo2.click();
        return new CreateSuiteAndCasePage();
    }
}
