package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GetUserProfileMapper {

	public static Map<String, String> getUserProfileMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> GetUserProfile_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_GetUserProfileAPI.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				getUserProfileMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return getUserProfileMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (getUserProfileMapper == null) {
			getUserProfileMapper = GetUserProfile_ResponseNodes();
		}
		return getUserProfileMapper;

	}

}