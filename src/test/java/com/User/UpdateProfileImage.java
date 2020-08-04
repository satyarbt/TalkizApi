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
public class UpdateProfileImage extends BaseTest {
	
	@Test(priority = 2, description = "Verify updateProfileImage API StatusCode, Response Time")
	public void PUT_UpdateProfileImage_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().multiPart(testUploadFile).when()
				.headers(header.HeaderWithMultipartANDUpdatedToken()).when()
				.put(ApiPathMapper.extendedPath().get("PUT_USERS_UPDATE_PROFILE_IMAGE"));
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
	
	@Test(priority = 2, description = "Verify updateProfileImage API Nodes")
	public void PUT_UpdateProfileImage_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().multiPart(testUploadFile).when()
				.headers(header.HeaderWithMultipartANDUpdatedToken()).when()
				.put(ApiPathMapper.extendedPath().get("PUT_USERS_UPDATE_PROFILE_IMAGE"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		
			// Response nodes check
			ResponseValidation.responseKeyValidation(response, "Nodes_UpdateProfileImage");

		
	}

}
