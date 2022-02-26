package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

@Log4j2
public class LoginTest extends BaseTest {
    @Test
    public void checkLoginAndPassword() {
        log.info("Проверка теста  на авторизацию");
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .open()
                .login("faker@faker.ru", "12345");
        Assert.assertEquals(loginPage.getErrorLoginOrPassword(), "These credentials do not match our records.");
        log.error(loginPage.getErrorLoginOrPassword());
        log.info("Авторизация не должна проходить при не правильном вводе адреса почты или пароля");
    }
}
