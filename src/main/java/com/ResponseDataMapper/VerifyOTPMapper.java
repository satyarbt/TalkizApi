package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class VerifyOTPMapper {
	
	public static Map<String, String> otpMapper=new HashMap<String, String>();
	public static Properties propMain=new Properties();
	public static Properties propPreSet=new Properties();

	public static Map<String, String> OTP_ResponseNodes()
	{
		try {
				FileInputStream APINodes=new FileInputStream(System.getProperty("user.dir")+"/TestData/Nodes_VerifyotpAPI.properties");
				propMain.load(APINodes);
				for(int i=1; i<=propMain.size();i++)
				{
					otpMapper.put(propMain.getProperty("Node"+i), propMain.getProperty("Node"+i));
				}
				
				
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return otpMapper;	
	}
	
	public static Map<String, String> getConfigReader()
	{
		if(otpMapper==null)
		{
			otpMapper=OTP_ResponseNodes();
		}
		return otpMapper;
		
	}



}
