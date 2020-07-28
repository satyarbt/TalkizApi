package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class VerifyUserNameMapper {
	
	public static Map<String, String> userNameMapper=new HashMap<String, String>();
	public static Properties propMain=new Properties();
	public static Properties propPreSet=new Properties();

	public static Map<String, String> UserName_ResponseNodes()
	{
		try {
				FileInputStream APINodes=new FileInputStream(System.getProperty("user.dir")+"/TestData/Nodes_VerifyUserNameAPI.properties");
				propMain.load(APINodes);
				for(int i=1; i<=propMain.size();i++)
				{
					userNameMapper.put(propMain.getProperty("Node"+i), propMain.getProperty("Node"+i));
				}
				
				
				
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return userNameMapper;	
	}
	
	public static Map<String, String> getConfigReader()
	{
		if(userNameMapper==null)
		{
			userNameMapper=UserName_ResponseNodes();
		}
		return userNameMapper;
		
	}


}
