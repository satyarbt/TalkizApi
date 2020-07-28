package com.User;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ApiConfig.ApiPath;
import com.Reports.ReportListner;
import com.ResponseDataMapper.CreateUserMapper;
import com.ResponseDataMapper.DeleteBankDetailsMapper;
import com.ResponseDataMapper.DeleteUpiDetailsMapper;
import com.ResponseDataMapper.FollowUserMapper;
import com.ResponseDataMapper.GetBankDetailsMapper;
import com.ResponseDataMapper.GetPreferenceMapper;
import com.ResponseDataMapper.GetProfileMapper;
import com.ResponseDataMapper.GetUserProfileMapper;
import com.ResponseDataMapper.GetUsersFollowingMe;
import com.ResponseDataMapper.UnfollowUserMapper;
import com.ResponseDataMapper.UpdateBankDetailsMapper;
import com.ResponseDataMapper.UpdatePreferenceMapper;
import com.ResponseDataMapper.UpdateProfileImageMapper;
import com.ResponseDataMapper.UpdateProfileMapper;
import com.ResponseDataMapper.UpdateUPIDetailsMapper;
import com.ResponseDataMapper.VerifyOTPUsernameMapper;
import com.ResponseValidator.ResponseValidation;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Listeners(ReportListner.class)
public class UserApiTests extends BaseTest{
	
		
	@Test(priority = 0, description = "Verify createUser API StatusCode, ResponseTime and Nodes")
	public void POST_CreateAUser() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.defaultHeaderWithToken())
				.body(builder.RequestBody_Login()).when().post(ApiPath.path.POST_USERS_TO_CREATE_USER);

		JsonPath JsPathEvaluator = response.jsonPath();
		int user_id = JsPathEvaluator.get("user_id");
		System.out.println(user_id);
		PropertiesConfiguration config = new PropertiesConfiguration(
				System.getProperty("user.dir") + "/TestData/dev.properties");
		config.setProperty("user_id", user_id);
		config.save();

		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		// Status Code check
				ResponseValidation.responseCodeValidation(response, 200);
				
		// Response nodes check
		int length_nodes = CreateUserMapper.Usercreation_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, CreateUserMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {

			ErrorCount = ErrorCount + 1;
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}



	@Test(priority = 1, description = "Verify userName&OTP API Response Code, ResponseTime and Nodes ")
	public void POST_verifyOTP() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.defaultHeaderWithToken())
				.body(builder.RequestBody_VerifyOTPUsername()).when().post(ApiPath.path.POST_USERS_VERIFYOTP);

		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//ResponseCode Check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Update user_id in properties file
		JsonPath JsPathEvaluator = response.jsonPath();
		String token = JsPathEvaluator.get("token");
		System.out.println(token);
		PropertiesConfiguration config = new PropertiesConfiguration(
				System.getProperty("user.dir") + "/TestData/dev.properties");
		config.setProperty("token", token);
		config.save();
		
		//Response Nodes Check
		int length_nodes = VerifyOTPUsernameMapper.OTPUsername_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response,
						VerifyOTPUsernameMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}

	}

	@Test(priority = 2, description = "Verify getProfile API StatusCode, Response Time and Nodes")

	public void GET_getProfile() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.get(ApiPath.path.GET_USERS_PROFILE);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//StatusCode Check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes Check
		int length_nodes = GetProfileMapper.GetProfile_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, GetProfileMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}

	@Test(priority = 2, description = "Verify getOtherUserProfile API StatusCode, Response Time and Nodes")
	public void GET_OtherUserProfile() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.queryParams(builder.QueryParams_GetOtherUserProfile()).when()
				.get(ApiPath.path.GET_USERS_OTHER_PROFILE);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		//StatusCode Check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes Check
		int length_nodes = GetUserProfileMapper.GetUserProfile_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, GetUserProfileMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//responseTime Check
		ResponseValidation.responseTimeValidation(response);

	}

	@Test(priority = 2, description = "Verify response body nodes of getOtherUserProfile API")
	public void GET_getOtherUserProfile() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.queryParams(builder.QueryParams_GetOtherUserProfile()).when()
				.get(ApiPath.path.GET_USERS_OTHER_PROFILE);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		

	}

	@Test(priority = 2, description = "Verify updateProfile API StatusCode, Response Time and Nodes")
	public void PUT_UpdateProfile() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdateProfile()).when().put(ApiPath.path.PUT_USERS_UPDATE_PROFILE);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//StatusCode Check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes Check

		int length_nodes = UpdateProfileMapper.UpdateProfile_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, UpdateProfileMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;

		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}

	@Test(priority = 2, description = "Verify updatePreference API StatusCode, Response Time and Nodes")
	public void PUT_UpdatePreferencee() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdatePreference()).when().put(ApiPath.path.PUT_USERS_UPDATE_PREFERENCES);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//StatusCode Check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Node Check
		int length_nodes = UpdatePreferenceMapper.UpdatePreference_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response,
						UpdatePreferenceMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}


	@Test(priority = 2, description = "Verify getPreference API StatusCode, Response Time and Nodes")
	public void GET_GetPreferencee() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.get(ApiPath.path.GET_USERS_PREFERENCES);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//StatusCode Check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//ResponseNodes Check
		int length_nodes = GetPreferenceMapper.GetPreference_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, GetPreferenceMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}

	@Test(priority = 2, description = "Verify updateProfileImage API StatusCode, Response Time and Nodes")
	public void PUT_UpdateProfileImage() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().multiPart(testUploadFile).when()
				.headers(header.HeaderWithMultipartANDUpdatedToken()).when()
				.put(ApiPath.path.PUT_USERS_UPDATE_PROFILE_IMAGE);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//Status code check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes check
		int length_nodes = UpdateProfileImageMapper.UpdateProfileImage_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response,
						UpdateProfileImageMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}

	
	@Test(priority = 2, description = "Verify UsersFollowingMe API StatusCode, Response Time and Nodes ")
	public void GET_UsersFollowingMe() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.queryParams(builder.QueryParams_UsersFollowingMe()).when()
				.get(ApiPath.path.GET_USERS_FOLLOWING_ME);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//Response code check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Node Check
		int length_nodes = GetUsersFollowingMe.GetUsersFollowingMe_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, GetUsersFollowingMe.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//Response Time check
		ResponseValidation.responseTimeValidation(response);

	}
	
	@Test(priority = 2, description = "Verify UpdateUpiDetails API StatusCode, Response Time and Nodes")
	public void PUT_UpdateUpiDetails() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdateUPIDetails()).when().put(ApiPath.path.PUT_USERS_SAVE_UPI_DETAILS);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//Response Code check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes Check
		int length_nodes = UpdateUPIDetailsMapper.UpdateUpi_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, UpdateUPIDetailsMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}
	@Test(priority = 2, description = "Verify UpdateBankDetails API StatusCode, Response Time and Nodes")
	public void PUT_UpdateBankDetails() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.body(builder.RequestBody_UpdateBankDetails()).when().put(ApiPath.path.PUT_USERS_SAVE_BANK_DETAILS);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//Response Code check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes Check
		int length_nodes = UpdateBankDetailsMapper.UpdateBank_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, UpdateBankDetailsMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}
	
	@Test(priority = 3, description = "Verify GetBankDetails API StatusCode, Response Time and Nodes")
	public void GET_BankDetails() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.DefalutHeaderWithUpdatedToken())
				.when().get(ApiPath.path.GET_USERS_BANK_DETAILS);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//Response Code check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes Check
		int length_nodes = GetBankDetailsMapper.GetBank_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, GetBankDetailsMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}
	
	@Test(priority = 4, description = "Verify DeleteBankDetails API StatusCode, Response Time and Nodes")
	public void POST_DeleteBankDetails() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.when().post(ApiPath.path.DELETE_USERS_BANK_DETAILS);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//Response Code check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes Check
		int length_nodes = DeleteBankDetailsMapper.DeleteBank_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, DeleteBankDetailsMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}
	
	@Test(priority = 5, description = "Verify DeleteUpiDetails API StatusCode, Response Time and Nodes")
	public void POST_DeleteUpiDetails() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.when().post(ApiPath.path.DELETE_USERS_UPI_DETAILS);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//Response Code check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes Check
		int length_nodes = DeleteUpiDetailsMapper.DeleteUpi_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, DeleteUpiDetailsMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}
	
	@Test(priority = 5, description = "Verify UnfollowUser API StatusCode, Response Time and Nodes")
	public void POST_UnfollowUser() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.when().post(ApiPath.path.POST_USERS_UNFOLLOW);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//Response Code check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes Check
		int length_nodes = UnfollowUserMapper.UnfollowUser_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, UnfollowUserMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}
	
	@Test(priority = 6, description = "Verify FollowUser API StatusCode, Response Time and Nodes")
	public void POST_FollowUser() throws Exception {

		test.log(LogStatus.INFO, "API test has been started...");
		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.when().post(ApiPath.path.POST_USERS_FOLLOW);
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
		
		//Response Code check
		ResponseValidation.responseCodeValidation(response, 200);
		
		//Response Nodes Check
		int length_nodes = FollowUserMapper.FollowUser_ResponseNodes().size();
		int ErrorCount = 0;
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, FollowUserMapper.propMain.getProperty("Node" + i));
			}
		} catch (AssertionError | Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;
		}
		if (ErrorCount > 0) {
			Assert.fail(errorMessage);

		}
		
		//ResponseTime Check
		ResponseValidation.responseTimeValidation(response);

	}
	
	

}


