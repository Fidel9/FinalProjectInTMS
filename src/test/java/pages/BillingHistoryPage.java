package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingHistoryPage extends BasePage{
    @FindBy(xpath = "//table[@class='table projects-table mt-3']//td[3]")
    private WebElement amount;

    @FindBy(xpath = "//span[@class='ms-0 badge bg-success']")
    private WebElement status;

    public BillingHistoryPage(){
        PageFactory.initElements(driver, this);}

    public String getAmountBillingHistory() {return amount.getText();}
    public String getStatusBillingHistory() {return status.getText();}

}
