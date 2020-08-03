package com.User;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DataMapper.ApiPathMapper;
import com.Reports.ReportListner;
import com.ResponseValidator.ResponseValidation;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(ReportListner.class)
public class GetOtherUserProfile extends BaseTest {

	@Test(priority = 2, description = "Verify getOtherUserProfile API StatusCode, Response Time and Nodes", groups= {"UserExisting"})
	public void GET_OtherUserProfile() throws Exception {
		int ErrorCount = 0;
		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken())
				.queryParams(builder.QueryParams_GetOtherUserProfile()).when()
				.get(ApiPathMapper.extendedPath().get("GET_USERS_OTHER_PROFILE"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString()); // StatusCode Check
		ResponseValidation.responseCodeValidation(response, 200);

		// Response Nodes Check
		Properties prop = new Properties();
		FileInputStream getuserprofile = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/Nodes_GetUserProfileAPI.properties");
		prop.load(getuserprofile);
		int length_nodes = prop.size();
		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, prop.getProperty("Node" + i));
				test.log(LogStatus.PASS, prop.getProperty("Node" + i) + " is present in the response body");
			}
			// responseTime Check

		} catch (AssertionError | Exception e) {
			errorMessage = e.getLocalizedMessage();

			ErrorCount = ErrorCount + 1;
		}

		if (ErrorCount > 0) {
			ResponseValidation.responseTimeValidation(response);
			AssertJUnit.fail(errorMessage);
		} else {
			ResponseValidation.responseTimeValidation(response);
		}

	}

}
