package tests;


import apiAdapters.ProjectAdapter;
import apiAdapters.SuiteAdapter;
import apiModels.Project;
import apiModels.Suites;
import apiResponse.Delete;
import org.testng.annotations.Test;
import apiResponse.ResponseStatus;
import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertEquals;

public class SuiteTest {

   /* @Test
    public void createNewProjectApiTest(){
        Project project =  Project.builder()
                .title("Home")
                .code("Home")
                .build();
        ResponseStatus actual = new ProjectAdapter().post(project,200);
        ResponseStatus expected = ResponseStatus.builder()
                .status(true)
                .build();

        assertEquals(actual, expected);
    }
    @Test
    public void checkSuiteApiTest(){
        Suites suite  =  Suites.builder()
                .code("Home")
                .title("Home")
                .build();
        ResponseStatus actual = new SuiteAdapter().post(suite,404);
        ResponseStatus expected = ResponseStatus.builder()
                .status(false)
                .errorMessage("Project is not found.")
                .build();

        assertEquals(actual, expected);
    }

    @Test
    public void deleteProjectTest() {
        Project project = Project.builder()
                .code("Home")
                .build();
        Delete actual = new ProjectAdapter().delete(project, 200);
        Delete expected = Delete.builder()
                .status(true)
                .build();

        assertEquals(actual, expected);
    }*/

}

