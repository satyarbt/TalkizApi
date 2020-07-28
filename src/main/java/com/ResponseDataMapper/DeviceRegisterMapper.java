package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DeviceRegisterMapper {
	

		
		public static Map<String, String> deviceRegisterMapper=new HashMap<String, String>();
		public static Properties propMain=new Properties();
		public static Properties propPreSet=new Properties();

		public static Map<String, String> DeviceRegister_ResponseNodes()
		{
			try {
					FileInputStream APINodes=new FileInputStream(System.getProperty("user.dir")+"/TestData/Nodes_DeviceRegisterAPI.properties");
					propMain.load(APINodes);
					for(int i=1; i<=propMain.size();i++)
					{
						deviceRegisterMapper.put(propMain.getProperty("Node"+i), propMain.getProperty("Node"+i));
					}
					
					
					
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			return deviceRegisterMapper;	
		}
		
		public static Map<String, String> getConfigReader()
		{
			if(deviceRegisterMapper==null)
			{
				deviceRegisterMapper=DeviceRegister_ResponseNodes();
			}
			return deviceRegisterMapper;
			
		}

}
