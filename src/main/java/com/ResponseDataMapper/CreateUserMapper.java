package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CreateUserMapper {
	
	public static Map<String, String> createUserNodes=new HashMap<String, String>();
	public static Properties propMain=new Properties();
	public static Properties propPreSet=new Properties();

	public static Map<String, String> Usercreation_ResponseNodes()
	{
		try {
				FileInputStream APINodes=new FileInputStream(System.getProperty("user.dir")+"/TestData/Nodes_CreateUserAPI.properties");
				propMain.load(APINodes);
				for(int i=1; i<=propMain.size();i++)
				{
					createUserNodes.put(propMain.getProperty("Node"+i), propMain.getProperty("Node"+i));
				}
				
				
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return createUserNodes;	
	}
	
	public static Map<String, String> getConfigReader()
	{
		if(createUserNodes==null)
		{
			createUserNodes=Usercreation_ResponseNodes();
		}
		return createUserNodes;
		
	}

}
