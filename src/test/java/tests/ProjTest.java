package tests;


import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import readProperties.ConfigProvider;



@Log4j2
public class ProjTest extends BaseTest {

    @Test(priority = 1)
    public void a_checkProject() {
        log.info("Старт позитивного теста на проверку функционнальности");
        CreateSuiteAndCasePage createSuiteAndCasePage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .createNewProjectButton()
                .createProject(TestValues.TEST_PROJECT_FIELD_NAME, TestValues.TEST_PROJECT_FIELD_CODE)
                .createNewProjectSaveButton()
                .createNewCase()
                .createCaseRepo(TestValues.TEST_PR_REPO_AUTH)
                .repository()
                .lastPageInRepo()
                .deleteCase();

        Assert.assertEquals(createSuiteAndCasePage.getStatisticRepo(), "0 suites | 1 test");
        log.info("Проходим регистрацию и создаем проект");
        log.info("Создаем Case и удаляем его из репозитория и получаем статистику в репопозитории");
        log.info(createSuiteAndCasePage.getStatisticRepo());
    }

    @Test(priority = 2)
    public void b_checkSearchField() {
        log.info("Поиск проекта по поисковой строке");
        ProjectsPage projectsPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .searchProjField(TestValues.TEST_TITLE);

        Assert.assertEquals(projectsPage.getTitleProjects(),"Tms");
        log.info("Проект найден ");
    }

    @Test(priority = 3)
    public void c_checkIfExistProject() {
        log.info("Положителбный тест на создание  существующего проекта");
        NewProjectPage newProjectPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .createNewProjectButton()
                .createProject("Tms", "");

        newProjectPage.createNewProjectSaveButton();

        Assert.assertEquals(newProjectPage.getProjectWithTheSameCodeAlreadyExists(), "Project with the same code already exists.");
        log.error(newProjectPage.getProjectWithTheSameCodeAlreadyExists());
        log.info("Проект уже существует");
    }

    @Test(priority = 4)
    public void d_checkDeleteProj(){
        log.info("Удаление существующего проекта");
        ProjectsPage projectsPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .deleteProjectNameProj()
                .searchProjField(TestValues.TEST_TITLE);

        Assert.assertEquals(projectsPage.getYouDonNotHaveAnyProjectsYet(),"Looks like you don’t have any projects yet.");
        log.info(projectsPage.getYouDonNotHaveAnyProjectsYet());
        log.info("Проект удален");
    }


    @Test(priority = 5)
    public void e_checkProjectFieldsInCreateProj() {
        log.info("Проверяем проект на минимальное колличество букв");
        NewProjectPage newProjectPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .createNewProjectButton()
                .createProject("Q", "");

        newProjectPage.createNewProjectSaveButton();

        Assert.assertEquals(newProjectPage.getErrorCode(), "The code must be at least 2 characters.");
        log.error(newProjectPage.getErrorCode());
        log.info("Код должен содержать более двух цифр");
    }
    @Test(priority = 6)
    public void g_checkProjectFieldsInCreateProj_2() {
        log.info("Проверяем проект на вставление цифр в название проекта");
        NewProjectPage newProjectPage = new LoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .createNewProjectButton()
                .createProject("P1234", "");

        newProjectPage.createNewProjectSaveButton();

        Assert.assertEquals(newProjectPage.getErrorCode(), "The code must be at least 2 characters.");
        log.error(newProjectPage.getErrorCode());
        log.info("Код должен содержать более двух цифр");
    }


}