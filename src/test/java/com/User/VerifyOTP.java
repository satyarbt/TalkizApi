package com.User;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Listeners;
import com.DataMapper.ApiPathMapper;
import com.Reports.ReportListner;
import com.ResponseValidator.ResponseValidation;
import com.SaveResponseData.CaptureResponseNodeValue;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(ReportListner.class)
public class VerifyOTP extends BaseTest {

	@Test(priority = 1, description = "Verify userName&OTP API Response Code, ResponseTime and Nodes ", groups= {"UserExisting"})
	public void POST_verifyOTP() throws Exception {
		int ErrorCount = 0;
		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.defaultHeaderWithToken())
				.body(builder.RequestBody_VerifyOTPUsername()).when()
				.post(ApiPathMapper.extendedPath().get("POST_USERS_VERIFYOTP"));

		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		// ResponseCode Check

		ResponseValidation.responseCodeValidation(response, 200);

		// Update user_id in properties file
		CaptureResponseNodeValue.saveStringNodeValue(response, "token", "token");

		// Response Nodes Check
		Properties prop = new Properties();
		FileInputStream otpusername = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/Nodes_VerifyotpusernameAPI.properties");
		prop.load(otpusername);
		int length_nodes = prop.size();
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, prop.getProperty("Node" + i));
				test.log(LogStatus.PASS, prop.getProperty("Node" + i) + " is present in the response body");

			}
		}

		catch (AssertionError | Exception e) {

			errorMessage = e.getLocalizedMessage();
			ErrorCount = ErrorCount + 1;

		}

		if (ErrorCount > 0) {
			ResponseValidation.responseTimeValidation(response);

			Assert.fail(errorMessage);
		} else {
			ResponseValidation.responseTimeValidation(response);
		}
	}
}
