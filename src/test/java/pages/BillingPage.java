package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingPage extends BasePage {

    @FindBy(xpath = "//div[@class='sub-menu-container']//i[@class='far fa-fw fa-credit-card']")
    private WebElement paymentMethods;

    @FindBy(xpath = "//div[@class='sub-menu-container']//li[2]//span")
    private WebElement billing;

    @FindBy(xpath = "//h2[@class='subscription-title']")
    private WebElement currentSubscriptionPlan;

    @FindBy(xpath = "//div[@class='plan-details row mt-3']//div[3]/span[@class='plan-details-item-content']")
    private WebElement nextСharge;


    public BillingPage() {
        PageFactory.initElements(this.driver, this);
    }

    public String getCurrentSubscriptionPlan() {return currentSubscriptionPlan.getText();}


    public String getNextCharge() {return nextСharge.getText();}

    public PaymentPage openPaymentMethods() {
        paymentMethods.click();
        return new PaymentPage();
    }

    public BillingHistoryPage openBillingHistory() {
        billing.click();
        return new BillingHistoryPage();
    }

}
