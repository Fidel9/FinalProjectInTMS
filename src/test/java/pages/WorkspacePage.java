package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkspacePage extends BasePage {

    @FindBy(xpath = "//a[@data-bs-original-title='Invites']")
    private WebElement selectInvitesPage;

    public WorkspacePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("oen invites page")
    public InvitesPage openInvitesPage() {
        selectInvitesPage.click();
        return new InvitesPage(driver);
    }
}
