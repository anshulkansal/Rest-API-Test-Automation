package com.rest.test.stepdefs;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestUtil {
	protected static String endPointUrl;
	protected static RequestSpecification request = RestAssured.given();;
	protected static Response response;
	protected static RequestSpecification httpRequest;
	
	public static void setBaseURI() throws Exception {
		RestAssured.baseURI = endPointUrl;
		response = RestAssured.get();
	}
	
	public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }
	
	 public static void verifyServerIsUpAndRunning() {
	        response.then().assertThat().statusCode(Macros.successCode);
	    }
	 
	 public static void setContentType(final String type) {
	        httpRequest = RestAssured.given().contentType(type);
	    }
	 
	 public static void setRequestBody(File jsonFileName) {
	        httpRequest.given().body(jsonFileName);
	    }
	 
	 public static void setQueryParamaters(String paramName, String ParamValue) {
	        httpRequest = RestAssured.given().queryParam(paramName, ParamValue);
	    }
	 
	 public static void setHeaderParamaters(String paramName, String ParamValue) {
	        httpRequest = RestAssured.given().header(paramName, ParamValue);
	    }
	 
	 public static void setFormParamaters(String paramName, String ParamValue) {
	        httpRequest = RestAssured.given().formParam(paramName, ParamValue);
	    }
	 
	 public static Response getRequest(String basePath) {
	        response = httpRequest.get(basePath);
	        return response;
	    }
	 
	 public void postRequest(String basePath) {
	        response = httpRequest.when().post(basePath);
	    }
	 
	 public static Response deleteRequest(String basePath) {
	        response = httpRequest.delete(basePath);
	        return response;
	    }
	 
	 public static Response putRequest(String basePath) {
	        response = httpRequest.put(basePath);
	        return response;
	    }
	 
	 public Response getResponse() {
	        return response;
	    }
	 
	 public static Response verifyStatusCode(int statusCode) {
	        Assert.assertEquals(response.statusCode(), statusCode);
	        return response;
	    }
	 
	 public static Response verifyStringExistInResponse(String stringToBeVerify) {
	        Assert.assertTrue(response.asString().contains(stringToBeVerify));
	        return response;
	    }
	 
	 public static void validateResponseJsonPathValue(String jsonPath, String expectedValue) {
	        Assert.assertEquals(response.jsonPath().get(jsonPath), expectedValue);
	    }
	 
	 public static Object getResponseValue(String jsonPath) {
	        return response.jsonPath().get(jsonPath);
	    }
	 
	 
}
