package com.User;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.DataMapper.ApiPathMapper;
import com.Reports.ReportListner;
import com.ResponseValidator.ResponseValidation;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.AssertionFailedError;

@Listeners(ReportListner.class)
public class UnfollowUser extends BaseTest{
	
	@Test(priority = 5, description = "Verify UnfollowUser API StatusCode, Response Time")
	public void POST_UnfollowUser_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.post(ApiPathMapper.extendedPath().get("POST_USERS_UNFOLLOW"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

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
	
	@Test(priority = 5, description = "Verify UnfollowUser API Nodes")
	public void POST_UnfollowUser_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.post(ApiPathMapper.extendedPath().get("POST_USERS_UNFOLLOW"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());


		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_UnfollowUser");


	}

}
