package com.ResponseValidator;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import com.DataMapper.EnvironmentDataMapper;
import com.Reports.ReportListner;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import junit.framework.AssertionFailedError;

@Listeners(ReportListner.class)
public class ResponseValidation extends ReportListner {

	EnvironmentDataMapper prop = new EnvironmentDataMapper();

	public static void responseCodeValidation(Response response, int statusCode) {
		try {

			Assert.assertEquals(response.getStatusCode(), statusCode, "Getting status code " + response.getStatusCode()
					+ " instead of expected status code " + statusCode);
			test.log(LogStatus.PASS, "Status code " + statusCode + " validated successfully");

		} catch (AssertionFailedError | NullPointerException e) {

			test.log(LogStatus.FAIL, "Getting status code " + response.getStatusCode()
					+ " instead of expected status code " + statusCode);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	public static void responseKeyValidation(Response response, String key) throws Exception {

		String res = response.getBody().asString();
		try {
			Assert.assertTrue(res.contains(key), key + " node is not present in the response body");

			test.log(LogStatus.PASS, key + " node present in the response body");

		} catch (AssertionFailedError | NullPointerException e) {
			test.log(LogStatus.FAIL, key + " node is not present in the response body");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());

		}

	}

	public static void responseTimeValidation(Response response) throws Exception {
		long actualTime = response.getTime();
		try {
			String ExpectedTime = EnvironmentDataMapper.fileandenv.get("ResponseTime");
			int ET = Integer.parseInt(ExpectedTime);
			Assert.assertTrue(actualTime <= ET,
					"Time allocated " + actualTime + "ms is greater than expected time " + 500 + "ms");
			test.log(LogStatus.PASS, "Time allocated " + actualTime + "ms is less than expected time " + 500 + "ms");
		} catch (AssertionFailedError | NullPointerException e) {
			test.log(LogStatus.FAIL, "Time allocated " + actualTime + "ms is greater than expected time " + 500 + "ms");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

}
