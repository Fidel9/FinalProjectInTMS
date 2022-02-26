package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingHistoryPage extends BasePage {
    @FindBy(xpath = "//table[@class='table projects-table mt-3']//td[3]")
    private WebElement amount;

    @FindBy(xpath = "//span[@class='ms-0 badge bg-success']")
    private WebElement status;

    public BillingHistoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("Проверяем сумму на счету, на странице платежа (check amount in billing page)")
    public String getAmountBillingHistory() {
        return amount.getText();
    }

    @Step("Проверяем платежную историю на странице платежа(check status in billing page)")
    public String getStatusBillingHistory() {
        return status.getText();
    }

}

