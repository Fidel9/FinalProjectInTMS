package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkspacePage extends BasePage{

    @FindBy(xpath = "//a[@data-bs-original-title='Invites']")
    private WebElement selectInvitesPage;

    public WorkspacePage() {
        PageFactory.initElements(driver,this);
    }

    public InvitesPage openInvitesPage(){
        selectInvitesPage.click();
        return new InvitesPage();
    }
}
