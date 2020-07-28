package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class VerifyOTPUsernameMapper {
	
	public static Map<String, String> otpUsernameMapper=new HashMap<String, String>();
	public static Properties propMain=new Properties();
	public static Properties propPreSet=new Properties();

	public static Map<String, String> OTPUsername_ResponseNodes()
	{
		try {
				FileInputStream APINodes=new FileInputStream(System.getProperty("user.dir")+"/TestData/Nodes_VerifyotpusernameAPI.properties");
				propMain.load(APINodes);
				for(int i=1; i<=propMain.size();i++)
				{
					otpUsernameMapper.put(propMain.getProperty("Node"+i), propMain.getProperty("Node"+i));
				}
				
				
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return otpUsernameMapper;	
	}
	
	public static Map<String, String> getConfigReader()
	{
		if(otpUsernameMapper==null)
		{
			otpUsernameMapper=OTPUsername_ResponseNodes();
		}
		return otpUsernameMapper;
		
	}



}
