package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FollowUserMapper {

	public static Map<String, String> FollowUserMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> FollowUser_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_FollowUser.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				FollowUserMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return FollowUserMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (FollowUserMapper == null) {
			FollowUserMapper = FollowUser_ResponseNodes();
		}
		return FollowUserMapper;

	}

}