package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;

@Log4j2
public class SignUpTest extends BaseTest {

    @Test(priority = 1)
    public void signUpCheckInputEmail() {
        log.info("Негативный тест на проверку ввода существующего проекта. Проверяем регистрацию пользователя заполняем email");
        SignUpPage signUpPage = new LoginPage(driver)

                .openSignUp()
                .openSignUpPageAndInputEmailAndPassword("test@test.com", "12345678", "12345678");

        Assert.assertEquals(signUpPage.getErrorSignUpEmail(), "The email has already been taken.");
        log.error(signUpPage.getErrorSignUpEmail() + "Проект уже существует");
    }

    @Test(priority = 2)
    public void signUpTestPassword() {
        log.info("Негативный тест на проверку пароля.Проверяем регистрацию пользователя заполняем email");
        SignUpPage signUpPage = new LoginPage(driver)

                .openSignUp()
                .openSignUpPageAndInputEmailAndPassword("fake@fake.ru", "12345", "12345");

        Assert.assertEquals(signUpPage.getErrorSignUpPass(), "The password must be at least 8 characters.");
        log.error(signUpPage.getErrorSignUpPass() + "Пароль должен иметь  больше 8 символов ");
    }

    @Test(priority = 3)
    public void signUpTestCheckBox() {
        log.info("Проверяем регистрацию пользователя заполняем checkBox");
        SignUpPage signUpPage = new LoginPage(driver)

                .openSignUp()
                .openSignUpPageAndInputEmailAndPassword("faker@faker.ru", "12345678", "12345678");

        Assert.assertEquals(signUpPage.getErrorCheckBox(), "The agreement field is required.");
        log.error(signUpPage.getErrorCheckBox());
    }

}
