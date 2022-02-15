package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//a[@class='mt-3 btn btn-primary']")
    private WebElement addPaymentMethodButton;

    @FindBy(xpath = "//div[@class='col-md-12']//h2[text()='Add new payment method']")
    private WebElement titlePaymentWindow;

    public PaymentPage() {
        PageFactory.initElements(driver,this);
    }

    public PaymentPage openPaymentWindow(){
        addPaymentMethodButton.click();
        return this;
    }
    public String getTitleWindowPayments(){
        return titlePaymentWindow.getAttribute("innerText");
    }
}
