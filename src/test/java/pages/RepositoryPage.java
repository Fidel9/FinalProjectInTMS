package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepositoryPage extends BasePage {

    @FindBy(xpath = "//td[@class='style_codeCell-1EsJ-']//a")
    private WebElement testCasesWithoutSuite;

    @FindBy(xpath = "//table[@class='style_table-1jtb1']")
    private WebElement searchFieldTitleInRepo;

    public RepositoryPage() {
        PageFactory.initElements(driver,this);
    }

    public String getSearchFieldTitleInRepo(){return searchFieldTitleInRepo.getText();}//на данный момент не используется

    public  LastRepoPage lastPageInRepo(){
        testCasesWithoutSuite.click();
        return new LastRepoPage();
    }


}

