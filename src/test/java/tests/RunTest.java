package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

@Log4j2
public class RunTest extends BaseTest {

    @Test
    public void a_openTestRun() {
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


        //Assert.assertEquals(testRunPage.getTitleTestRun(),TestValues.TEST_RUN_TITLE);
       // log.info(testRunPage.getTitleTestRun());
    }

    @Test
    public void b_errorMessageTestRun() {
        log.info("Старт  теста на проверку test run");
        RepositoryPage repositoryPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                        .openPageRepositoryWithoutCreateNewProject()
                                .checkErrorFlashMessage();

        Assert.assertEquals(repositoryPage.getMessageYouHaveReachedALimitOfActiveRun(),TestValues.TEST_RUN_ERROR_MESSAGE);
        log.info(repositoryPage.getMessageYouHaveReachedALimitOfActiveRun());
    }
   /* @Test
    public void c_removeCaseTestRun() {
        log.info("delete test run case");
        TestRunPage testRunPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .openTestRunPage()
                .RemoveCaseTestRunInPageExpressRun();

        log.info("Test run case deleted");
    }*/
    @Test
    public void c_deleteTestRun() {
        log.info("delete test run");
        ProjectsPage projectsPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                .deleteTestRunInPageExpressRun();

        log.info("Test run deleted");
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
