package RestAssured_Activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssured_Activity1 {
	
	final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";
	
  @Test (priority=1)
  public void addNewPet() {
      // Create JSON request
      String reqBody = "{"
          + "\"id\": 77232,"
          + "\"name\": \"Riley\","
          + " \"status\": \"alive\""
      + "}";

      Response response = 
          given().contentType(ContentType.JSON) // Set headers
          .body(reqBody) // Add request body
          .when().post(ROOT_URI); // Send POST request

      // Assertion
      response.then().body("id", equalTo(77232));
      response.then().body("name", equalTo("Riley"));
      response.then().body("status", equalTo("alive"));
  }
  
  @Test (priority=2)
  public void getPetDetails() {
	  Response response= 
			  given().contentType(ContentType.JSON)
			  .when().pathParam("petId","77232")
			  .get(ROOT_URI + "/{petId}");
	  
	  response.then().body("id", equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status", equalTo("alive"));
			  
  }
  
  
  @Test (priority=3)
  public void deletePet() {
	  Response response=
			  given().contentType(ContentType.JSON)
			  .when().pathParam("petId","77232")
			  .delete(ROOT_URI + "/{petId}");
	  
	  response.then().body("code", equalTo(200));
	  response.then().body("message", equalTo("77232"));
	  
  }
  
}
