package tests;


import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import readProperties.ConfigProvider;


@Log4j2
public class ProjTest extends BaseTest {

    @Test(priority = 1)
    public void a_createProjectAndCase() {
        log.info("Старт  теста на проверку создания проекта и тест кейса");
        CreateSuiteAndCasePage createSuiteAndCasePage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
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
    public void b_checkIfExistProjectInSearchField() {
        log.info("Поиск проекта по поисковой строке");
        ProjectsPage projectsPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .searchProjField(TestValues.TEST_TITLE);

        Assert.assertEquals(projectsPage.getTitleProjects(), "Tms");
        log.info("Проект найден ");
    }

    @Test(priority = 3)
    public void c_checkIfExistProject() {
        log.info("тест на создание  существующего проекта");
        NewProjectPage newProjectPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .createNewProjectButton()
                .createProject("Tms", "");

        newProjectPage.createNewProjectSaveButton();

        Assert.assertEquals(newProjectPage.getProjectWithTheSameCodeAlreadyExists(), "Project with the same code already exists.");
        log.error(newProjectPage.getProjectWithTheSameCodeAlreadyExists());
        log.info("Проект уже существует");
    }

    @Test(priority = 4)
    public void d_deleteNewProject() {
        log.info("Удаление существующего проекта");
        ProjectsPage projectsPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .deleteProjectNameTms()
                .searchProjField(TestValues.TEST_TITLE);

        Assert.assertEquals(projectsPage.getYouDonNotHaveAnyProjectsYet(), "Looks like you don’t have any projects yet.");
        log.info(projectsPage.getYouDonNotHaveAnyProjectsYet());
        log.info("Проект удален");
    }


    @Test(priority = 5)
    public void checkIfProjectFieldCodeAndNameCanAcceptMoreLettersInCreateNewProject() {
        log.info("Проверяем проект на минимальное колличество букв");
        NewProjectPage newProjectPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .createNewProjectButton()
                .createProject("Q", "");

        newProjectPage.createNewProjectSaveButton();

        Assert.assertEquals(newProjectPage.getErrorCode(), "The code must be at least 2 characters.");
        log.error(newProjectPage.getErrorCode());
        log.info("Код должен содержать более двух цифр");
    }

    @Test(priority = 6)
    public void checkIfCanAcceptNumberInProjectNameFieldInCreateProj() {
        log.info("Проверяем проект на вставление цифр в название проекта");
        NewProjectPage newProjectPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .createNewProjectButton()
                .createProject("P1234", "");

        newProjectPage.createNewProjectSaveButton();

        Assert.assertEquals(newProjectPage.getErrorCode(), "The code must be at least 2 characters.");
        log.error(newProjectPage.getErrorCode());
        log.info("Код должен содержать более двух цифр");
    }


}