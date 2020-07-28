package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GetUsersFollowingMe {

	public static Map<String, String> getUsersFollowingMeMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> GetUsersFollowingMe_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_UsersFollowingMe.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				getUsersFollowingMeMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return getUsersFollowingMeMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (getUsersFollowingMeMapper == null) {
			getUsersFollowingMeMapper = GetUsersFollowingMe_ResponseNodes();
		}
		return getUsersFollowingMeMapper;

	}

}
