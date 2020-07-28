package com.DataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestSummaryMapper {
	
	public static Map<String, String> testResultMapper=new HashMap<String, String>();
	public static Properties propMain=new Properties();
	public static Properties propPreSet=new Properties();

	public static Map<String, String> resultMapper()
	{
		try {
				FileInputStream fileEmail=new FileInputStream(System.getProperty("user.dir")+"/TestData/TestResults.properties");
				propMain.load(fileEmail);
				testResultMapper.put("TestCases", propMain.getProperty("TotalCases"));
				testResultMapper.put("Passed", propMain.getProperty("TC_Passed"));
				testResultMapper.put("Failed", propMain.getProperty("TC_Failed"));
				testResultMapper.put("Skipped", propMain.getProperty("TC_Skipped"));
				testResultMapper.put("Error", propMain.getProperty("TC_Error"));
				testResultMapper.put("HostName", propMain.getProperty("HostName"));
				testResultMapper.put("OS", propMain.getProperty("OS"));
				testResultMapper.put("TestSuite", propMain.getProperty("TestSuite"));
				
				
				
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return testResultMapper;	
	}
	
	public static Map<String, String> getConfigReader()
	{
		if(testResultMapper==null)
		{
			testResultMapper=resultMapper();
		}
		return testResultMapper;
		
	}

}
