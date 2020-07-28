package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GetProfileMapper {
	
	public static Map<String, String> getProfileMapper=new HashMap<String, String>();
	public static Properties propMain=new Properties();
	public static Properties propPreSet=new Properties();

	public static Map<String, String> GetProfile_ResponseNodes()
	{
		try {
				FileInputStream APINodes=new FileInputStream(System.getProperty("user.dir")+"/TestData/Nodes_GetProfileAPI.properties");
				propMain.load(APINodes);
				for(int i=1; i<=propMain.size();i++)
				{
					getProfileMapper.put(propMain.getProperty("Node"+i), propMain.getProperty("Node"+i));
				}			
				
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return getProfileMapper;	
	}
	
	public static Map<String, String> getConfigReader()
	{
		if(getProfileMapper==null)
		{
			getProfileMapper=GetProfile_ResponseNodes();
		}
		return getProfileMapper;
		
	}

}