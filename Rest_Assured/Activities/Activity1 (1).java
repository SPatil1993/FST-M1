package activities;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity1 {

    String baseURL = "https://petstore.swagger.io/v2/pet";

    @Test(priority =1)
    void addAPet(){
        String jsonReq = """
                {
                  "id": 77232,
                  "name": "Riley",
                  "status": "alive"
                }
                """;
        Response res = given().contentType(ContentType.JSON)
                .body(jsonReq)
                .when().post(baseURL);

        System.out.println(("Post request response : "+ res.body().prettyPrint()));
        res.then().body("id", equalTo(77232));
        res.then().body("name",equalTo("Riley"));
        res.then().body("status",equalTo("alive"));
    }

    //get pet details

    @Test(priority =2)
    public void getPetDetails(){
        Response res = given().contentType(ContentType.JSON)
                .when().get(baseURL+"/77232");
        System.out.println( "Get pet Details Response "+res.body().prettyPrint());
        res.then().body("id", equalTo(77232));
        res.then().body("name",equalTo("Riley"));
        res.then().body("status",equalTo("alive"));
    }

    @Test(priority =3)
    public void deletePet(){
        Response res = given().contentType(ContentType.JSON)
                .when().delete(baseURL+"/77232");
        System.out.println( "Delete Response "+res.body().prettyPrint());
        res.then().body("code", equalTo(200));
        res.then().body("message",equalTo("77232"));
    }
}
