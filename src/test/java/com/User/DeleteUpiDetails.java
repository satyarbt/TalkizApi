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
public class DeleteUpiDetails extends BaseTest {

	@Test(priority = 5, description = "Verify DeleteUpiDetails API StatusCode, Response Time and Nodes", groups= {"UserExisting"})
	public void POST_DeleteUpiDetails() throws Exception {
		int ErrorCount = 0;
		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.HeaderWithUpdatedToken()).when()
				.post(ApiPathMapper.extendedPath().get("DELETE_USERS_UPI_DETAILS"));
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());

		// Response Code check
		ResponseValidation.responseCodeValidation(response, 200);

		// Response Nodes Check
		Properties prop = new Properties();

		FileInputStream deleteupi = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/Nodes_DeleteUpiDetails.properties");
		prop.load(deleteupi);
		int length_nodes = prop.size();

		try {
			for (int i = 1; i <= length_nodes; i++) {

				ResponseValidation.responseKeyValidation(response, prop.getProperty("Node" + i));
				test.log(LogStatus.PASS, prop.getProperty("Node" + i) + " is present in the response body");
			}
			// ResponseTime Check

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
