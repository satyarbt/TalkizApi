package com.User;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


import com.ApiConfig.HeaderConfig;
import com.DataMapper.ApiPathMapper;
import com.DataMapper.EnvironmentDataMapper;
import com.EmailConfig.EmailReports;
import com.Reports.ReportListner;
import com.RequestBuilder.RequestBody;
import com.Utility.TestDataUtils;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;


@Listeners(ReportListner.class)
public class BaseTest extends ReportListner {

	HeaderConfig header = new HeaderConfig();
	RequestBody builder = new RequestBody();
	TestDataUtils utils = new TestDataUtils();
	String errorMessage = null;
	String filePath = System.getProperty("user.dir") + "/" + "Zeel-cover-02.jpg";
	File testUploadFile = new File(filePath);
	
	public void POST_CreateUser() throws IOException, ConfigurationException
	{
		test.log(LogStatus.INFO, "API test has been started...");

		Response response = RestAssured.given().when().headers(header.defaultHeaderWithToken())
				.body(builder.RequestBody_CreateUser()).when()
				.post(ApiPathMapper.extendedPath().get("POST_USERS_TO_CREATE_USER"));
		System.out.println(response.getBody().asString());
		test.log(LogStatus.INFO, "Response body is " + response.getBody().asString());
	}

	@BeforeSuite
	public void def_baseUrl() throws IOException

	{
		RestAssured.baseURI = EnvironmentDataMapper.envAndFile().get("baseUrl");
	}
	
	
	@AfterSuite
	public void SM() {
		EmailReports ER = new EmailReports();
		ER.sendMail();
	}
}
