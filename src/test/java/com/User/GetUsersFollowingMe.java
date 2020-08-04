package com.User;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.DataMapper.ApiPathMapper;
import com.Reports.ReportListner;
import com.ResponseValidator.ResponseValidation;
import com.SaveResponseData.CaptureResponseNodeValue;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.AssertionFailedError;

@Listeners(ReportListner.class)
public class GetUsersFollowingMe extends BaseTest {
	
	@Test(priority = 2, description = "Verify UsersFollowingMe API StatusCode, Response Time")
	public void GET_UsersFollowingMe_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.queryParams(builder.QueryParams_UsersFollowingMe()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_FOLLOWING_ME"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		CaptureResponseNodeValue.saveIntegerNodeValue(response, "[0].user_id", "id");

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
	
	@Test(priority = 2, description = "Verify UsersFollowingMe API Nodes ")
	public void GET_UsersFollowingMe() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.queryParams(builder.QueryParams_UsersFollowingMe()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_FOLLOWING_ME"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		CaptureResponseNodeValue.saveIntegerNodeValue(response, "[0].user_id", "id");

		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_UsersFollowingMe");

	}

}
