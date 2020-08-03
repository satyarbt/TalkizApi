package com.ResponseValidator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import com.DataMapper.EnvironmentDataMapper;
import com.Reports.ReportListner;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import junit.framework.AssertionFailedError;

@Listeners(ReportListner.class)
public class ResponseValidation extends ReportListner {

	EnvironmentDataMapper prop = new EnvironmentDataMapper();
	

	public static void responseCodeValidation(Response response, int statusCode) {

		
			Assert.assertEquals(response.getStatusCode(), statusCode, "Getting status code " + response.getStatusCode()
					+ " instead of expected status code " + statusCode);
			test.log(LogStatus.PASS, "Status code " + statusCode + " validated successfully");

			/*
			 * } catch (AssertionFailedError | Exception e) { test.log(LogStatus.FAIL,
			 * "Getting status code " + response.getStatusCode() +
			 * " instead of expected status code " + statusCode);
			 * 
			 * }
			 */
	}

	public static void responseKeyValidation(Response response, String fileName) throws IOException {

		SoftAssert softAssert=new SoftAssert();
		String res = response.getBody().asString();
		Properties propData = new Properties();
		FileInputStream nodeData = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/" + fileName + ".properties");
		propData.load(nodeData);
		int i = 1;
		int errorCount=0;
		int length_nodes = propData.size();
		try {
			for (i = 1; i <= length_nodes; i++) {
				softAssert.assertTrue(res.contains(propData.getProperty("Node" + i)),
						propData.getProperty("Node" + i) + " node is not present in the response body");
				//test.log(LogStatus.PASS, prop.getProperty("Node" + i) + " node is present in the response body");
	
			}
			softAssert.assertAll();
		}catch(AssertionFailedError | Exception e)
		{
			
			Assert.fail("Test Failed");//Throwable error1=e.fillInStackTrace();
			errorCount=errorCount+1;
		}
if(errorCount>0)
{
	test.log(LogStatus.FAIL,  "Test Failed");
}
		

	}

	public static void responseTimeValidation(Response response) {

		// TimeUnit tu=TimeUnit.MILLISECONDS;
		long actualTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		String ExpectedTime = EnvironmentDataMapper.fileandenv.get("ResponseTime");
		long ET = Long.valueOf(ExpectedTime);

		//try {

			Assert.assertTrue(actualTime <= ET,
					"Time allocated " + actualTime + "ms is greater than expected time " + ET + "ms");
			test.log(LogStatus.PASS,
					"Time allocated " + actualTime + "ms is less than expected time " + ET + "ms");

			/*
			 * } catch (AssertionFailedError | Exception e) { test.log(LogStatus.FAIL,
			 * e.fillInStackTrace());
			 * 
			 * }
			 */

	}
}