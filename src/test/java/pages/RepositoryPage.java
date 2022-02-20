package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RepositoryPage extends BasePage {

    @FindBy(xpath = "//td[@class='style_codeCell-1EsJ-']//a")
    private WebElement testCasesWithoutSuite;

    @FindBy(xpath = "//table[@class='style_table-1jtb1']")
    private WebElement searchFieldTitleInRepo;

    public RepositoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("Search Field Title In Repo")
    public String getSearchFieldTitleInRepo() {
        return searchFieldTitleInRepo.getText();
    }//на данный момент не используется

    @Step("open last repo page")
    public LastRepoPage lastPageInRepo() {
        testCasesWithoutSuite.click();
        return new LastRepoPage(driver);
    }

}

