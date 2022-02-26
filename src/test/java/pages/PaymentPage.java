package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//a[@class='mt-3 btn btn-primary']")
    private WebElement addPaymentMethodButton;

    @FindBy(xpath = "//div[@class='col-md-12']//h2[text()='Add new payment method']")
    private WebElement titlePaymentWindow;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Step("open payment window")
    public PaymentPage openPaymentWindow() {
        addPaymentMethodButton.click();
        return this;
    }

    @Step("title window payments")
    public String getTitleWindowPayments() {
        return titlePaymentWindow.getAttribute("innerText");
    }
}
