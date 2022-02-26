package tests;

import apiAdapters.ProjectAdapter;
import apiModels.Project;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import apiResponse.ResponseStatus;

import static org.testng.Assert.assertEquals;

@Log4j2
public class ApiTest {


    @Test
    public void getProjectTest() {
        ResponseStatus response = new ProjectAdapter().getProject(200, "Home");
        System.out.println(response);
    }

    @Test
    public void checkApiTest() {
        log.info("check invalid param");
        Project project = Project.builder()
                .code("Mouse")
                .title("Mouse")
                .build();
        ResponseStatus actual = new ProjectAdapter().post(project, 422);
        ResponseStatus expected = ResponseStatus.builder()
                .status(false)
                .errorMessage("Data is invalid.")
                .build();

        assertEquals(actual, expected);
    }


}

