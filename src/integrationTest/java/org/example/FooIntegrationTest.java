package org.example;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class FooIntegrationTest {

  @Test
  public void testUserFetchesSuccess() {

    given().
	port(8081). // the default port is 8080
    expect().
        statusCode(200).
        content(containsString("YES")).
    when().
        get("/foo/api/hello/yes");

    given().
	port(8081).
    expect().
       statusCode(200).
       content(containsString("NO")).
    when().
       get("/foo/api/hello/no");
  }
}
