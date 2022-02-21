package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class LoginPage extends BasePage {

    @FindBy(css = "#inputEmail")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id='inputPassword']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[text()='These credentials do not match our records.']")
    private WebElement errorLoginOrPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[@class='col text-end']//a")
    private WebElement signUp;

    public LoginPage(WebDriver driver) {
        super(driver);
       // driver.get(ConfigProvider.URL);
        PageFactory.initElements(this.driver, this);
    }

     public LoginPage open() {
         driver.get(ConfigProvider.URL);
         PageFactory.initElements(this.driver, this);
         return this;
     }
    @Step("open project page")
    public ProjectsPage login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        buttonLogin.click();
        return new ProjectsPage(driver);
    }

    @Step("error login or password")
    public String getErrorLoginOrPassword() {
        return errorLoginOrPassword.getText();
    }

    @Step("open signUp")
    public SignUpPage openSignUp() {
        signUp.click();
        return new SignUpPage(driver);
    }

}
