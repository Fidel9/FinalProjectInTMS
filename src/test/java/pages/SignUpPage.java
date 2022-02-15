package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class SignUpPage extends BasePage {


    @FindBy(xpath = "//input[@type='email']")
    private WebElement signUpEmail;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement signUpPassword;

    @FindBy(xpath = "//input[@name='password_confirmation']")
    private WebElement signUpPassword2;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "//div[@class='form-control-feedback']")
    private WebElement errorSignUpEmail;

    @FindBy(xpath = "//div[text()='The password must be at least 8 characters.']")
    private WebElement errorSignUpPass;

    @FindBy(xpath = "//span[text()='The agreement field is required.']")
    private WebElement errorCheckBox;

    public SignUpPage() {
        PageFactory.initElements(driver,this);
    }


    public SignUpPage demoSignUpPage(String demoEm,String demoPas,String demoPas2) {
        signUpEmail.sendKeys(demoEm, Keys.ENTER);
        signUpPassword.sendKeys(demoPas,Keys.ENTER);
        signUpPassword2.sendKeys(demoPas2,Keys.ENTER);
        checkBox.isSelected();
        return this;
    }

    public String getErrorSignUpEmail(){
        return errorSignUpEmail.getAttribute("innerText");
    }
    public String getErrorSignUpPass(){
        return errorSignUpPass.getText();
    }
    public String getCheckBox(){
        return errorCheckBox.getText();
    }
}

