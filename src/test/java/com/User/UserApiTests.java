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
public class UserApiTests extends BaseTest {

	@Test(priority = 0, description = "Verify createUser API StatusCode, ResponseTime")
	public void POST_CreateAUser_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.defaultHeaderWithToken())
				.body(builder.RequestBody_CreateUser()).when()
				.post(ApiPathMapper.extendedPath().get("POST_USERS_TO_CREATE_USER"));
		CaptureResponseNodeValue.saveIntegerNodeValue(response, "user_id", "user_id");
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
	
	@Test(priority = 0, description = "Verify createUser API Nodes")
	public void POST_CreateAUser_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.defaultHeaderWithToken())
				.body(builder.RequestBody_CreateUser()).when()
				.post(ApiPathMapper.extendedPath().get("POST_USERS_TO_CREATE_USER"));

		CaptureResponseNodeValue.saveIntegerNodeValue(response, "user_id", "user_id");

		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_CreateUserAPI");
	}

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

	@Test(priority = 2, description = "Verify getProfile API StatusCode, Response Time")

	public void GET_getProfile_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_PROFILE"));
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
	
	
	@Test(priority = 2, description = "Verify getProfile API Nodes")

	public void GET_getProfile_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_PROFILE"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		
		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_GetProfileAPI");

	}


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

	@Test(priority = 2, description = "Verify updateProfile API StatusCode, Response Time")
	public void PUT_UpdateProfile_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdateProfile()).when()
				.put(ApiPathMapper.extendedPath().get("PUT_USERS_UPDATE_PROFILE"));
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
	
	@Test(priority = 2, description = "Verify updateProfile API Nodes")
	public void PUT_UpdateProfile_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdateProfile()).when()
				.put(ApiPathMapper.extendedPath().get("PUT_USERS_UPDATE_PROFILE"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_UpdateProfile");


	}

	@Test(priority = 2, description = "Verify updatePreference API StatusCode, Response Time")
	public void PUT_UpdatePreferences_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdatePreference()).when()
				.put(ApiPathMapper.extendedPath().get("PUT_USERS_UPDATE_PREFERENCES"));
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
	
	@Test(priority = 2, description = "Verify updatePreference API Nodes")
	public void PUT_UpdatePreference_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdatePreference()).when()
				.put(ApiPathMapper.extendedPath().get("PUT_USERS_UPDATE_PREFERENCES"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_UpdatePreference");

	}

	@Test(priority = 2, description = "Verify getPreference API StatusCode, Response Time")
	public void GET_GetPreference_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_PREFERENCES"));
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
	
	@Test(priority = 2, description = "Verify getPreference API Nodes")
	public void GET_GetPreference_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_PREFERENCES"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_GetPreference");


	}

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

	@Test(priority = 2, description = "Verify UpdateUpiDetails API StatusCode, Response Time")
	public void PUT_UpdateUpiDetails_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdateUPIDetails()).when()
				.put(ApiPathMapper.extendedPath().get("PUT_USERS_SAVE_UPI_DETAILS"));
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
	
	@Test(priority = 2, description = "Verify UpdateUpiDetails API Nodes")
	public void PUT_UpdateUpiDetails_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdateUPIDetails()).when()
				.put(ApiPathMapper.extendedPath().get("PUT_USERS_SAVE_UPI_DETAILS"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_UpdateUpiDetails");

		
	}

	@Test(priority = 2, description = "Verify UpdateBankDetails API StatusCode, Response Time")
	public void PUT_UpdateBankDetails_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdateBankDetails()).when()
				.put(ApiPathMapper.extendedPath().get("PUT_USERS_SAVE_BANK_DETAILS"));
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
	
	@Test(priority = 2, description = "Verify UpdateBankDetails API Nodes")
	public void PUT_UpdateBankDetails_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdateBankDetails()).when()
				.put(ApiPathMapper.extendedPath().get("PUT_USERS_SAVE_BANK_DETAILS"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		
		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_UpdateBankDetails");

	

	}

	@Test(priority = 3, description = "Verify GetBankDetails API StatusCode, Response Time")
	public void GET_BankDetails_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_BANK_DETAILS"));
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
	
	@Test(priority = 3, description = "Verify GetBankDetails API Nodes")
	public void GET_BankDetails_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_BANK_DETAILS"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		
		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_GetBankDetails");


	}

	@Test(priority = 4, description = "Verify DeleteBankDetails API StatusCode, Response Time")
	public void POST_DeleteBankDetails_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.post(ApiPathMapper.extendedPath().get("DELETE_USERS_BANK_DETAILS"));
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
	
	@Test(priority = 4, description = "Verify DeleteBankDetails API Nodes")
	public void POST_DeleteBankDetails_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.post(ApiPathMapper.extendedPath().get("DELETE_USERS_BANK_DETAILS"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		
		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_DeleteBankDetails");

	}

	@Test(priority = 5, description = "Verify DeleteUpiDetails API StatusCode, Response Time")
	public void POST_DeleteUpiDetails_StatusCode_Time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.post(ApiPathMapper.extendedPath().get("DELETE_USERS_UPI_DETAILS"));
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
	
	@Test(priority = 5, description = "Verify DeleteUpiDetails API Nodes")
	public void POST_DeleteUpiDetails_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.post(ApiPathMapper.extendedPath().get("DELETE_USERS_UPI_DETAILS"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_DeleteUpiDetails");

	}

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

	@Test(priority = 6, description = "Verify FollowUser API StatusCode, Response Time")
	public void POST_FollowUser_StatusCode_time() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.post(ApiPathMapper.extendedPath().get("POST_USERS_FOLLOW"));
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
	
	@Test(priority = 6, description = "Verify FollowUser API Nodes")
	public void POST_FollowUser_Nodes() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.post(ApiPathMapper.extendedPath().get("POST_USERS_FOLLOW"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		// Response nodes check
		ResponseValidation.responseKeyValidation(response, "Nodes_FollowUser");

	}

}
