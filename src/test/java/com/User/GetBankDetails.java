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
public class GetBankDetails extends BaseTest {

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
		} catch (AssertionFailedError | Exception e) {
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
}
