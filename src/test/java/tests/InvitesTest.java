package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InvitesPage;
import pages.LoginPage;

@Log4j2
public class InvitesTest extends BaseTest {

    @Test(priority = 1)
    public void a_invitesNewUser() {
        log.info("тест на проверку регистрации нового пользавателя и ограничиваем доступ");
        InvitesPage invitesPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("faker@faker.faker", "QA engineer");

        Assert.assertEquals(invitesPage.getSuccessInvites(), "User has been successfully invited");
        log.info("Тест пройден новый пользователь добавлен " + invitesPage.getSuccessInvites());
    }

    @Test(priority = 2)
    public void b_searchNewInviteUser() {
        log.info("тест на поиск пользователей ");
        InvitesPage invitesPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .workspacePage()
                .openInvitesPage()
                .searchForInvite("faker@faker.faker");

        Assert.assertEquals(invitesPage.getUserEmailFoundInInvitesPage(), "faker@faker.faker");
        log.info("Пользователь найден " + invitesPage.getUserEmailFoundInInvitesPage());
    }

    @Test(priority = 3)
    public void c_checkAddExistsUser() {
        log.info("тест на создание существующего пользователя");
        InvitesPage invitesPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("faker@faker.faker", "QA engineer");


        Assert.assertEquals(invitesPage.getTheUserAlreadyExist(), "Sorry, but this member has been already invited.");
        log.info("Пользаватель уже существует");
        log.error(invitesPage.getTheUserAlreadyExist());
    }

    @Test(priority = 4)
    public void invitesCheckSearchFields() {
        log.info("Поиск не существующего пользователя в поисковой строке");
        InvitesPage invitesPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .workspacePage()
                .openInvitesPage()
                .searchForInvite("Ivan");

        Assert.assertEquals(invitesPage.getErrorSearchForInvites(), "Invites matching your criteria are not found.");
        log.info("Пользователь с таким именем не найден ");
        log.error(invitesPage.getErrorSearchForInvites());
    }


    @Test(priority = 5)
    public void openWindowWithFieldsForInvitesNewUser() {
        log.info("тест проверка полей можно ли зарегестрироваться не заполняя поля email и title");
        InvitesPage invitesPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("", "");

        Assert.assertEquals(invitesPage.getErrorInvitesNewMember(), "Validation error");
        log.error(invitesPage.getErrorInvitesNewMember() + " Введите в поля критерии");
    }

    @Test(priority = 6)
    public void openWindowWithFieldsForInvitesNewUserAndCheckEmailUserFields() {
        log.info("Негативный тест проверка поля ввода эл почты (email)");
        InvitesPage invitesPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("", "QA engineer");

        Assert.assertEquals(invitesPage.getErrorEmailInvites(), "Sorry, but email can`t be empty");
        log.info(" Поле должно быть заполнено");
        log.error(invitesPage.getErrorEmailInvites());
    }

    @Test(priority = 7)
    public void openWindowWithFieldsForInvitesNewUserAndCheckEmailUserFields_2() {
        log.info("тест на неправильный ввод эл почты");
        InvitesPage invitesPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("faker@@gmail.com", "QA engineer");

        Assert.assertEquals(invitesPage.getErrorEmailInvites(), "Sorry, but this email is not valid");
        log.error(invitesPage.getErrorEmailInvites() + "Sorry, but this email is not valid");
    }

    @Test(priority = 8)
    public void openWindowWithFieldsForInvitesNewUserAndCheckTitleUserFields() {
        log.info("тест на проверку поля title");
        InvitesPage invitesPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("faker@gmail.com", "");

        Assert.assertEquals(invitesPage.getErrorTitleMember(), "Sorry, but role title can`t be empty");
        log.info("Титл должен быть заполнен");
        log.error(invitesPage.getErrorTitleMember());
    }

    @Test(priority = 9)
    public void i_revokeNewInvites() {
        log.info("Тест удаляет добавленого пользователя(faker@faker.faker) и проверяет" +
                " в поисковой строке существует липользователь с таким адрессом ");
        InvitesPage invitesPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .workspacePage()
                .openInvitesPage()
                .revokeNewInvites()
                .searchForInvite("faker@faker.faker");

        Assert.assertEquals(invitesPage.getErrorSearchForInvites(), "Invites matching your criteria are not found.");
        log.info(invitesPage.getErrorSearchForInvites());
    }
}

