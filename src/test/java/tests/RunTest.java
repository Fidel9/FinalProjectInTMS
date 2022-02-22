package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateSuiteAndCasePage;
import pages.LoginPage;
import pages.RepositoryPage;
import pages.TestRunPage;
import readProperties.ConfigProvider;
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

        Assert.assertEquals(testRunPage.getTitleTestRun(),"Test was created succesfuly");
    }

    @Test
    public void errorMessageTestRun() {
        log.info("Старт  теста на проверку test run");
        RepositoryPage repositoryPage = new LoginPage(driver)
                .open()
                .login(emailAdmin,passwordAdmin)
                        .openPageRepositoryWithoutCreateNewProject()
                                .checkErrorFlashMessage();

        Assert.assertEquals(repositoryPage.getMessageYouHaveReachedALimitOfActiveRun(),"\n" +
                "You have reached a limit of active runs. Complete/Abort your active test runs or upgrade to a paid plan.");

    }
}
