package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UnfollowUserMapper {

	public static Map<String, String> UnfollowUserMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> UnfollowUser_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_UnfollowUser.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				UnfollowUserMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return UnfollowUserMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (UnfollowUserMapper == null) {
			UnfollowUserMapper = UnfollowUser_ResponseNodes();
		}
		return UnfollowUserMapper;

	}

}

