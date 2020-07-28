package com.DataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EmailMapper {
	
	public static Map<String, String> emaildata=new HashMap<String, String>();
	public static Properties propMain=new Properties();
	public static Properties propPreSet=new Properties();

	public static Map<String, String> emailDataMap()
	{
		try {
				FileInputStream fileEmail=new FileInputStream(System.getProperty("user.dir")+"/TestData/email.properties");
				propMain.load(fileEmail);
				emaildata.put("host_Key", propMain.getProperty("host_Key"));
				emaildata.put("host_value", propMain.getProperty("host_value"));
				emaildata.put("socketfactory_port_key", propMain.getProperty("socketfactory_port_key"));
				emaildata.put("socketfactory_port_value", propMain.getProperty("socketfactory_port_value"));
				emaildata.put("socketfactory_key", propMain.getProperty("socketfactory_key"));
				emaildata.put("socketfactory_value", propMain.getProperty("socketfactory_value"));
				emaildata.put("auth_key", propMain.getProperty("auth_key"));
				emaildata.put("auth_value", propMain.getProperty("auth_value"));
				emaildata.put("smtp_port_key", propMain.getProperty("smtp_port_key"));
				emaildata.put("smtp_port_value", propMain.getProperty("smtp_port_value"));
				emaildata.put("email", propMain.getProperty("email"));
				emaildata.put("password", propMain.getProperty("password"));
				emaildata.put("receipient_email", propMain.getProperty("receipient_email"));
				emaildata.put("projectName", propMain.getProperty("projectName"));
				
				
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return emaildata;	
	}
	
	public static Map<String, String> getConfigReader()
	{
		if(emaildata==null)
		{
			emaildata=emailDataMap();
		}
		return emaildata;
		
	}

}
