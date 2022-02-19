package pages;

import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//div[text()=\'These credentials do not match our records.\']")
    private WebElement errorLoginOrPassword;

    @FindBy(xpath = "//div[@class='col text-end']//a")
    private WebElement signUp;

    public LoginPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    /* public LoginPage login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        passwordField.sendKeys( Keys.ENTER);
        return new LoginPage();
    }*/

    public ProjectsPage login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
        return new ProjectsPage();
    }
    public String getErrorLoginOrPassword() {
        return errorLoginOrPassword.getText();
    }


    public SignUpPage signUp() {
        signUp.click();
        return new SignUpPage();
    }

}
