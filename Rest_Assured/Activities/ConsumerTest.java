package pactProject;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {

    //create headers
    Map<String,String> headers = new HashMap<>();

    // Create contract
    @Pact(consumer = "UserConsumer", provider ="UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        headers.put("Content-Type","application/json");

        //set req/res body
        DslPart requestResponseBody = new PactDslJsonBody()
                .numberType("id",100)
                .stringType("firstName","Srilatha")
                .stringType("lastName","B")
                .stringType("email","srilatha2530@gmail.com");

        return builder.given("POST Request")
                .uponReceiving("Request to create a user")
                .method("post")
                .path("/api/users")
                .headers(headers)
                .body(requestResponseBody)
                .willRespondWith()
                .status(201)
                .body(requestResponseBody)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider", port="8282")
    public void consumerTest(){

        //Req body
        Map<String ,Object> reqBody = new HashMap<>();
        reqBody.put("id",100);
        reqBody.put("firstName","Srilatha");
        reqBody.put("lastName","B");
        reqBody.put("email","srilatha2530@gmail.com");

        //Send POST Request
        given().baseUri("http://localhost:8282/api/users")
                .headers(headers)
                .body(reqBody)
                .log().all()
                .when().post()
                .then().statusCode(201)
                .body("email", equalTo("srilatha2530@gmail.com")).log().all();

    }


}
