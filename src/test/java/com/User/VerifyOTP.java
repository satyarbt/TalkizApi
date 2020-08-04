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
public class VerifyOTP extends BaseTest {

	@Test(priority = 1, description = "Verify userName&OTP API Response Code, ResponseTime")
	public void POST_verifyOTP_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.defaultHeaderWithToken())
				.body(builder.RequestBody_VerifyOTPUsername()).when()
				.post(ApiPathMapper.extendedPath().get("POST_USERS_VERIFYOTP"));

		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		// Update user_id in properties file
		CaptureResponseNodeValue.saveStringNodeValue(response, "token", "token");	
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
	
	@Test(priority = 1, description = "Verify userName&OTP API Nodes")
	public void POST_verifyOTP_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.defaultHeaderWithToken())
				.body(builder.RequestBody_VerifyOTPUsername()).when()
				.post(ApiPathMapper.extendedPath().get("POST_USERS_VERIFYOTP"));

		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		
		// Update user_id in properties file
		CaptureResponseNodeValue.saveStringNodeValue(response, "token", "token");

		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_VerifyotpusernameAPI");
	}
}
