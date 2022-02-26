package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BillingPage extends BasePage {


    @FindBy(xpath = "//div[@class='sub-menu-container']//i[@class='far fa-fw fa-credit-card']")
    private WebElement paymentMethods;

    @FindBy(xpath = "//div[@class='sub-menu-container']//li[2]//span")
    private WebElement billing;

    @FindBy(xpath = "//h2[@class='subscription-title']")
    private WebElement currentSubscriptionPlan;

    @FindBy(xpath = "//div[@class='plan-details row mt-3']//div[3]/span[@class='plan-details-item-content']")
    private WebElement nextСharge;


    public BillingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Проверяем текущуюю подписку (check current subscription plan in billing page) ")
    public String getCurrentSubscriptionPlan() {
        return currentSubscriptionPlan.getText();
    }

    @Step("Проверяем текущий счет(check charge in billing page)")
    public String getNextCharge() {
        return nextСharge.getText();
    }

    @Step("Открываем страницу способы оплаты(open payment page)")
    public PaymentPage openPaymentMethods() {
        paymentMethods.click();
        return new PaymentPage(driver);
    }

    @Step("Открываем страницу история платежа(open page history)")
    public BillingHistoryPage openBillingHistory() {
        billing.click();
        return new BillingHistoryPage(driver);
    }

}

