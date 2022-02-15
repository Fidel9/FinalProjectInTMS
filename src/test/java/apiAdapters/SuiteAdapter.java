package apiAdapters;

import apiModels.Suites;
import apiResponse.ResponseStatus;


public class SuiteAdapter extends BaseAdapter {

    public ResponseStatus post(Suites suite, int statusCode) {
        String response = post(gson.toJson(suite, Suites.class), statusCode, "suite");
        return gson.fromJson(response, ResponseStatus.class);
    }

    public ResponseStatus getSuite(int statusCode, String codeSuite) {
        return gson.fromJson(super.get(statusCode, "suite/" + codeSuite), ResponseStatus.class);
    }

}

