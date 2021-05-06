package tests.apiTests;

import com.google.gson.Gson;
import enums.ProjectType;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestAssuredTests {
    private static String END_POINT = "index.php?/dashboard";


    @Test
    public void simpleRestAssuredTest1() {
        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "";

        //Setup Request Object
        RequestSpecification request = given();

        //Setup Response Object
        Response response = request.request(Method.GET, endpoint);

        int statusCode = response.statusCode();
        System.out.println(statusCode);

        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }

    @Test
    public void simpleRestAssuredTest2() {
        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "/api/users/2";

        //Setup Request Object
        RequestSpecification request = RestAssured.given();

        //Setup Response Object
        Response response = request.request(Method.GET, endpoint);

        int statusCode = response.statusCode();

        String responseBody = response.getBody().asString();

        System.out.println(responseBody);

        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }

    @Test
    public void simpleRestAssuredTest3() {
        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "/api/users/2";

        //Setup Request Object
        RequestSpecification request = RestAssured.given();

        //Setup Response Object
        Response response = request.request(Method.GET, endpoint);

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .body();

    }

    @Test
    public void simpleRestAssuredTest4() {
        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "/api/users/2";

        //Setup Request Object
        RequestSpecification request = RestAssured.given();

        //Setup Response Object
        Response response = request.request(Method.GET, endpoint);

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"));
    }

    @Test
    public void simpleRestAssuredTest5() {
        RestAssured.baseURI = "http://reqres.in";
        String endpoint = "/api/users";
        String bodeJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\",\n" +
                "    \"id\": \"662\",\n" +
                "    \"createdAt\": \"2021-04-29T18:49:07.532Z\"\n" +
                "}";

        int projectID = given()
                .body(bodeJson)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract().jsonPath().getInt("id");
    }

    @Test
    public void serializationTest() {
        Gson gson = new Gson();
        Project project = Project.builder()
                .name("Name")
                .projectType(ProjectType.MULTIPLE)
                .isShowAnnouncement(true)
                .Announcement("Announcement description")
                .build();

        String result = gson.toJson(project);
        System.out.println(result);
    }

    @Test
    public void deserializationTest() {
        Gson gson = new Gson();

        String jsonString = "{\"name\":\"Name\",\" announcement\":\"Announcement description\"}";

        Project project = gson.fromJson(jsonString, Project.class);

        String result = gson.toJson(project);
        System.out.println(result);
    }
}
