package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvitesPage extends BasePage{

    @FindBy(xpath = "//a[@class='btn btn-primary me-2']")
    private WebElement inviteNewMemberButton;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement inviteMemberEmailFields;

    @FindBy(xpath = "//input[@name='role_title']")
    private WebElement inviteNewMemberTitle;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonInviteNewUser;

    @FindBy(xpath = "//span[text()='Read only']")
    private WebElement accessIndicator;

    @FindBy(xpath = "//span[text()='Access']")
    private WebElement accessIndicator2;

    @FindBy(xpath = "//input[@class='form-control search-input']")
    private WebElement searchFieldsForInvitesInInvitesPage;



    @FindBy(xpath = "//div[@class='flash-message']//div[@role='alert']")
    private WebElement validationsErrorMessageInviteNewMember;

    @FindBy(xpath = "//span[@class='no-project mt-4']")
    private WebElement errorSearchForInvites;

    @FindBy(xpath = "//div[@class='form-control-feedback']")//возможна ошибка из за скрытого текста
    private WebElement errorEmailInvites;

    @FindBy(xpath = "//div[@class='form-control-feedback']")//возможна ошибка из за скрытого текста
    private WebElement errorTitleInvites;

    @FindBy(xpath = "//span[@class='alert-message']")
    private WebElement successInvitesNewUser;

    @FindBy(xpath = "//span[@class='team-member-role']")
    private WebElement userEmailFoundInInvitesPage;

    @FindBy(xpath = "//div[@class='form-control-feedback']")//возможна ошибка из за скрытого текста
    private WebElement theUserAlreadyExists;



    @FindBy(xpath = "//span[contains(text(),'faker@faker.faker')]//following::a[@class='btn btn-dropdown']")
    private WebElement dropdownRevokeNewUser;

    @FindBy(xpath = "//a[@class='text-danger action-revoke']")
    private WebElement selectRevoke;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private WebElement buttonRevoke;


    public InvitesPage() {
        PageFactory.initElements(driver,this);
    }

    public InvitesPage inviteNewUserFields(String emailInviteMember,String titleInviteMember){
        inviteNewMemberButton.click();
        inviteMemberEmailFields.sendKeys(emailInviteMember);
        inviteNewMemberTitle.sendKeys(titleInviteMember);
        accessIndicator.click();
        accessIndicator2.click();
        buttonInviteNewUser.click();
        return this;
    }
    public InvitesPage searchForInvite(String strInviteSearch){
        searchFieldsForInvitesInInvitesPage.sendKeys(strInviteSearch);
        searchFieldsForInvitesInInvitesPage.sendKeys(Keys.ENTER);
        return this;
    }
    public InvitesPage revokeNewInvites(){
        dropdownRevokeNewUser.click();
        selectRevoke.click();
        buttonRevoke.click();
        return this;
    }

    public String getErrorInvitesNewMember(){
        return validationsErrorMessageInviteNewMember.getText();
    }
    public String getErrorEmailInvites(){return errorEmailInvites.getText();}
    public String getErrorTitleMember(){return errorTitleInvites.getText();}
    public String getErrorSearchForInvites(){
        return errorSearchForInvites.getAttribute("innerText");
    }
    public String getSuccessInvites(){return successInvitesNewUser.getText();}
    public String getUserEmailFoundInInvitesPage(){return userEmailFoundInInvitesPage.getAttribute("innerText");}
    public String getTheUserAlreadyExist(){return theUserAlreadyExists.getText();}


}

