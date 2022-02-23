package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

@Log4j2
public class RunTest extends BaseTest {

    @Test
    public void openTestRun() {
        log.info("Старт  теста на проверку test run");
        TestRunPage testRunPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .createNewProjectButton()
                .createProject(TestValues.TEST_PROJECT_FIELD_NAME_2, TestValues.TEST_PROJECT_FIELD_CODE_2)
                .createNewProjectSaveButton()
                .createNewCase()
                .createCaseRepo(TestValues.TEST_PR_REPO_AUTH_2)
                .repository()
                .openTestRun();

        Assert.assertEquals(testRunPage.getTitleTestRun(),TestValues.TEST_RUN_TITLE);
        log.info(testRunPage.getTitleTestRun());
    }

    @Test
    public void errorMessageTestRun() {
        log.info("Старт  теста на проверку test run");
        RepositoryPage repositoryPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                        .openPageRepositoryWithoutCreateNewProject()
                                .checkErrorFlashMessage();

        Assert.assertEquals(repositoryPage.getMessageYouHaveReachedALimitOfActiveRun(),TestValues.TEST_RUN_ERROR_MESSAGE);
        log.info(repositoryPage.getMessageYouHaveReachedALimitOfActiveRun());
    }
    @Test
    public void deleteProjectFromTestRun() {
        log.info("Удаление существующего проекта");
        ProjectsPage projectsPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .deleteProjectFromTestRun()
                .searchProjField(TestValues.TEST_TITLE_2);

        Assert.assertEquals(projectsPage.getYouDonNotHaveAnyProjectsYet(), "Looks like you don’t have any projects yet.");
        log.info(projectsPage.getYouDonNotHaveAnyProjectsYet());
        log.info("Проект удален");
    }
}
