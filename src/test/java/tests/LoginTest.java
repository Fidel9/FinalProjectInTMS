package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

@Log4j2
public class LoginTest extends BaseTest {
    @Test
    public void checkProject3() {
        log.info("Проверка теста  на авторизацию");
        LoginPage loginMainPage = new LoginPage();
        loginMainPage.login("faker@faker.ru", "12345");
        Assert.assertEquals(loginMainPage.getErrorLoginOrPassword(), "These credentials do not match our records.");
        log.error(loginMainPage.getErrorLoginOrPassword());
        log.info("Авторизация не должна проходить при не правильном вводе адреса почты или пароля");
    }
}
