package RestAssured_Activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssured_Activity3 {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectBody("status", equalTo("alive"))
                .build();
    }

    @DataProvider
    public Object[][] petInfoProvider() {
        Object[][] testData = new Object[][] { 
            { 99232, "Doggie", "alive" }, 
            { 99233, "Booby", "alive" }
        };
        return testData;
    }

    @Test(priority=1)
    public void addPets() {
        String reqBody = "{\"id\": 99232, \"name\": \"Doggie\", \"status\": \"alive\"}";
        Response response = given().spec(requestSpec) 
                .body(reqBody) 
                .when().post(); 

        reqBody = "{\"id\": 99233, \"name\": \"Booby\", \"status\": \"alive\"}";
        response = given().spec(requestSpec) 
                .body(reqBody) 
                .when().post(); 
        
        response.then().spec(responseSpec); 
    }

    @Test(dataProvider = "petInfoProvider", priority=2)
    public void getPets(int id, String name, String status) {
        Response response = given().spec(requestSpec)
                .pathParam("petId", id) 
                .when().get("/{petId}"); 
        System.out.println(response.asPrettyString());
        response.then()
        .spec(responseSpec) 
        .body("name", equalTo(name)); 
    }
    
    @Test(dataProvider = "petInfoProvider", priority=3)
    public void deletePets(int id, String name, String status) {
        Response response = given().spec(requestSpec)
                .pathParam("petId", id) 
                .when().delete("/{petId}"); 

        response.then().body("code", equalTo(200));
    }

}

