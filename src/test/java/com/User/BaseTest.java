package com.User;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.ApiConfig.HeaderConfig;
import com.DataMapper.EnvironmentDataMapper;
import com.EmailConfig.EmailReports;
import com.Reports.ReportListner;
import com.RequestBuilder.RequestBody;
import com.Utility.TestDataUtils;

import io.restassured.RestAssured;

@Listeners(ReportListner.class)
public class BaseTest extends ReportListner {

	HeaderConfig header = new HeaderConfig();
	RequestBody builder = new RequestBody();
	TestDataUtils utils = new TestDataUtils();
	String errorMessage = null;
	String filePath = System.getProperty("user.dir") + "/" + "Zeel-cover-02.jpg";
	File testUploadFile = new File(filePath);

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
