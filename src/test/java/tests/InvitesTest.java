package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InvitesPage;
import pages.LoginPage;
import readProperties.ConfigProvider;

@Log4j2
public class InvitesTest extends BaseTest {

    @Test
    public void a_invitesNewUser() {
        log.info("Положительный тест на проверку регистрации нового пользавателя и ограничиваем доступ");
        InvitesPage invitesPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("faker@faker.faker", "QA engineer");

        Assert.assertEquals(invitesPage.getSuccessInvites(), "User has been successfully invited");
        log.info("Тест пройден новый пользователь добавлен " + invitesPage.getSuccessInvites());
    }

    @Test
    public void b_searchNewInviteUser() {
        log.info("Положительный тест на поиск пользователей ");
        InvitesPage invitesPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .workspacePage()
                .openInvitesPage()
                .searchForInvite("faker@faker.faker");

        Assert.assertEquals(invitesPage.getUserEmailFoundInInvitesPage(), "faker@faker.faker");
        log.info("Пользователь найден " + invitesPage.getUserEmailFoundInInvitesPage());
    }
    @Test
    public void c_checkAddExistsUser() {
        log.info("Негативный тест на создание существующего пользователя");
        InvitesPage invitesPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("faker@faker.faker", "QA engineer");


        Assert.assertEquals(invitesPage.getTheUserAlreadyExist(), "Sorry, but this member has been already invited.");
        log.info("Пользаватель уже существует");
        log.error(invitesPage.getTheUserAlreadyExist());
    }

    @Test
    public void d_invitesCheckSearchFields() {
        log.info("Поиск не существующего пользователя в поисковой строке");
        InvitesPage invitesPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .workspacePage()
                .openInvitesPage()
                .searchForInvite("Ivan");

        Assert.assertEquals(invitesPage.getErrorSearchForInvites(), "Invites matching your criteria are not found.");
        log.info("Пользователь с таким именем не найден ");
        log.error(invitesPage.getErrorSearchForInvites());
    }


    @Test
    public void e_openWindowWithFieldsForInvitesNewUser() {
        log.info("Негативный тест проверка полей можно ли зарегестрироваться не заполняя поля email и title");
        InvitesPage invitesPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("", "");

        Assert.assertEquals(invitesPage.getErrorInvitesNewMember(), "Validation error");
        log.error(invitesPage.getErrorInvitesNewMember() + " Введите в поля критерии");
    }

    @Test
    public void f_openWindowWithFieldsForInvitesNewUserAndCheckEmailUserFields() {
        log.info("Негативный тест проверка поля ввода эл почты (email)");
        InvitesPage invitesPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("", "QA engineer");

        Assert.assertEquals(invitesPage.getErrorEmailInvites(), "Sorry, but email can`t be empty");
        log.info(" Поле должно быть заполнено");
        log.error(invitesPage.getErrorEmailInvites());
    }

    @Test
    public void g_openWindowWithFieldsForInvitesNewUserAndCheckEmailUserFields_2() {
        log.info("Негативный тест на неправильный ввод эл почты");
        InvitesPage invitesPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("faker@@gmail.com", "QA engineer");

        Assert.assertEquals(invitesPage.getErrorEmailInvites(), "Sorry, but this email is not valid");
        log.error(invitesPage.getErrorEmailInvites() + "Sorry, but this email is not valid");
    }

    @Test
    public void h_openWindowWithFieldsForInvitesNewUserAndCheckTitleUserFields() {
        log.info("Негативный тест на проверку поля title");
        InvitesPage invitesPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .workspacePage()
                .openInvitesPage()
                .inviteNewUserFields("faker@gmail.com", "");

        Assert.assertEquals(invitesPage.getErrorTitleMember(), "Sorry, but role title can`t be empty");
        log.info("Титл должен быть заполнен");
        log.error(invitesPage.getErrorTitleMember());
    }

    @Test
    public void i_revokeNewInvites(){
        log.info("Тест удаляет добавленого пользователя(faker@faker.faker) и проверяет" +
                " в поисковой строке существует липользователь с таким адрессом ");
        InvitesPage invitesPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .workspacePage()
                .openInvitesPage()
                .revokeNewInvites()
                .searchForInvite("faker@faker.faker");

        Assert.assertEquals(invitesPage.getErrorSearchForInvites(),"Invites matching your criteria are not found.");
        log.info(invitesPage.getErrorSearchForInvites());
    }
}

