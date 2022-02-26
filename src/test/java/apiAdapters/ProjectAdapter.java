package apiAdapters;

import apiModels.Project;
import apiResponse.ResponseStatus;


public class ProjectAdapter extends BaseAdapter {

    public ResponseStatus post(Project project, int statusCode) {
        String response = post(gson.toJson(project, Project.class), statusCode, "project");
        return gson.fromJson(response, ResponseStatus.class);
    }

    public ResponseStatus getProject(int statusCode, String codeProject) {
        return gson.fromJson(super.get(statusCode, "project/" + codeProject), ResponseStatus.class);
    }


}

