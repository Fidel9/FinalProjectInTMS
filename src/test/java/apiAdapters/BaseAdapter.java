package apiAdapters;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    Gson gson = new Gson();
    public String post(String body, int statusCode,String url){
        return   given().
                log().all().
                header("Token","e8e2ea0411aba42c27b85987f068dfcefe721ea5").
                header("Content-Type","application/json").
                header("Accept","application/jason").
                body(body).

                when().
                post("https://api.qase.io/v1/" + url).

                then().
                log().all().
                statusCode(statusCode).
                extract().
                body().
                asString();

    }

    public String get( int statusCode,String url){
        return   given().
                log().all().
                header("Token","e8e2ea0411aba42c27b85987f068dfcefe721ea5").
                header("Content-Type","application/json").
                header("Accept","application/jason").


                when().
                get("https://api.qase.io/v1/" + url).

                then().
                log().all().
                statusCode(statusCode).
                extract().
                body().
                asString();

    }
    public String delete(String body, int statusCode,String url){
        return   given().
                log().all().
                header("Token","e8e2ea0411aba42c27b85987f068dfcefe721ea5").
                header("Content-Type","application/json").
                header("Accept","application/jason").
                body(body).

                when().
                delete("https://api.qase.io/v1/" + url).

                then().
                log().all().
                statusCode(statusCode).
                extract().
                body().
                asString();

    }

}

