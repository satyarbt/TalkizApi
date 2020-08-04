package com.SaveResponseData;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.annotations.Listeners;
import com.DataMapper.EnvironmentDataMapper;
import com.Reports.ReportListner;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Listeners(ReportListner.class)
public class CaptureResponseNodeValue extends ReportListner {
	
	EnvironmentDataMapper prop = new EnvironmentDataMapper();
	

	public static void saveIntegerNodeValue(Response response, String key, String propKey) throws ConfigurationException {
	
			
			JsonPath JsPathEvaluator = response.jsonPath();
			int Node = JsPathEvaluator.get(key);
			System.out.println(Node);
			String environment = System.getProperty("env");
			
			try {
				if (environment.equalsIgnoreCase("dev")) {
			PropertiesConfiguration config = new PropertiesConfiguration(
					System.getProperty("user.dir") + "/TestData/dev.properties");
			test.log(LogStatus.INFO, propKey+":"+Node);
			config.setProperty(propKey, Node);
			config.save();
				}
				else
				{
					PropertiesConfiguration config = new PropertiesConfiguration(
							System.getProperty("user.dir") + "/TestData/production.properties");
					test.log(LogStatus.INFO, propKey+":"+Node);
					config.setProperty(propKey, Node);
					config.save();
				}
			}catch(ConfigurationException e)
			{
				test.log(LogStatus.FAIL, e.fillInStackTrace());
			}
			
			
	
		}
	
	public static void saveStringNodeValue(Response response, String key, String propKey) throws ConfigurationException {
		
		
		JsonPath JsPathEvaluator = response.jsonPath();
		String Node = JsPathEvaluator.get(key);
		System.out.println(Node);
		String environment = System.getProperty("env");
		
		
		try {
			if (environment.equalsIgnoreCase("dev")) {
		PropertiesConfiguration config = new PropertiesConfiguration(
				System.getProperty("user.dir") + "/TestData/dev.properties");
		test.log(LogStatus.INFO, propKey+":"+Node);
		config.setProperty(propKey, Node);
		config.save();
			}
			else
			{
				PropertiesConfiguration config = new PropertiesConfiguration(
						System.getProperty("user.dir") + "/TestData/production.properties");
				test.log(LogStatus.INFO, propKey+":"+Node);
				config.setProperty(propKey, Node);
				config.save();
			}
		}catch(ConfigurationException e)
		{
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
		
		

	}
}
	


