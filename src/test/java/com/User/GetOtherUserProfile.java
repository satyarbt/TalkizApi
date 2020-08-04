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
public class GetOtherUserProfile extends BaseTest {

	@Test(priority = 2, description = "Verify getOtherUserProfile API StatusCode, Response Time")
	public void GET_OtherUserProfile_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.queryParams(builder.QueryParams_GetOtherUserProfile()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_OTHER_PROFILE"));
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
	
	@Test(priority = 2, description = "Verify getOtherUserProfile API Nodes")
	public void GET_OtherUserProfile_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.queryParams(builder.QueryParams_GetOtherUserProfile()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_OTHER_PROFILE"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		// Response Nodes Check

		ResponseValidation.responseKeyValidation(response, "Nodes_GetUserProfileAPI");


	}

}
