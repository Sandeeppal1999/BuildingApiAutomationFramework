package api.endpoints;


/* UserEndPoint.java

Created to perform CRUD[create, retrieve, update, delete] operation to the user API.

* */

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

    public static Response createUser(User payload){

        Response response= given()
                             .contentType(ContentType.JSON)
                             .accept(ContentType.JSON)
                             .body(payload)
                             .when()
                             .post(Routes.post_url);
        return response;
    }
    public static Response readUser(String userName){

        Response response= given()
                .pathParams("username",userName)
                .when()
                .get(Routes.get_url);
        return response;
    }

    public static Response updateUser(String userName,User payload){

        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParams("username",userName)
                .body(payload)
                .when()
                .put(Routes.put_url);
        return response;
    }

    public static Response deleteUser(String userName){
        Response response= given()
                .pathParams("username",userName)
                .when()
                .delete(Routes.delete_url);
        return response;
    }

}
