package tests;

import apiAdapters.ProjectAdapter;
import apiModels.Project;
import org.testng.annotations.Test;
import apiResponse.ResponseStatus;

import static org.testng.Assert.assertEquals;


public class ApiTest {


    @Test
    public void getProjectTest() {
        ResponseStatus response = new ProjectAdapter().getProject(404, "Home");
        System.out.println(response);
    }

    @Test
    public void checkApiTest() {
        Project project = Project.builder()
                .code("Home")
                .title("Home")
                .build();
        ResponseStatus actual = new ProjectAdapter().post(project, 422);
        ResponseStatus expected = ResponseStatus.builder()
                .status(false)
                .errorMessage("Data is invalid.")
                .build();

        assertEquals(actual, expected);
    }


}

