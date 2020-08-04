package com.User;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;


import com.DataMapper.ApiPathMapper;
import com.Reports.ReportListner;
import com.ResponseValidator.ResponseValidation;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.AssertionFailedError;

@Listeners(ReportListner.class)
public class DeleteBankDetails extends BaseTest{
	
	Response response=null;
	
	@BeforeTest
	public void POST_DeleteBankDetails()
	{

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.post(ApiPathMapper.extendedPath().get("DELETE_USERS_BANK_DETAILS"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
	}

	@Test(priority = 4, description = "Verify DeleteBankDetails API StatusCode, Response Time")
	public void POST_DeleteBankDetails_StatusCode_Time() throws Exception {

		/*
		 * test.log(LogStatus.INFO, "API test has been started...");
		 * 
		 * Response response =
		 * RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
		 * .post(ApiPathMapper.extendedPath().get("DELETE_USERS_BANK_DETAILS"));
		 * test.log(LogStatus.INFO, "Response body is " +
		 * response.getBody().asString());
		 */

		try {
			// Response Code check
			ResponseValidation.responseCodeValidation(response, 200);


			// ResponseTime Check
			ResponseValidation.responseTimeValidation(response);
			}catch(AssertionFailedError | Exception e)
			{
				test.log(LogStatus.FAIL, e.fillInStackTrace());
			}

	}
	
	@Test(priority = 4, description = "Verify DeleteBankDetails API Nodes")
	public void POST_DeleteBankDetails_Nodes() throws Exception {

		/*
		 * test.log(LogStatus.INFO, "API test has been started...");
		 * 
		 * Response response =
		 * RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
		 * .post(ApiPathMapper.extendedPath().get("DELETE_USERS_BANK_DETAILS"));
		 * test.log(LogStatus.INFO, "Response body is " +
		 * response.getBody().asString());
		 */

		
		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_DeleteBankDetails");

	}
}
