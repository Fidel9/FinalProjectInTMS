package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestRunPage extends BasePage{

    @FindBy(xpath = "//div[@class='run-case-row-div run-case-row-title']//a[starts-with(text(),'Test_Authorization')]")
    private WebElement titleTestRun;


    public TestRunPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("get title test run in page test run")
    public String getTitleTestRun() {
        return titleTestRun.getText();
    }

}
