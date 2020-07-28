package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class UpdateProfileImageMapper {

	public static Map<String, String> updateProfileImageeMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> UpdateProfileImage_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_UpdateProfileImage.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				updateProfileImageeMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return updateProfileImageeMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (updateProfileImageeMapper == null) {
			updateProfileImageeMapper = UpdateProfileImage_ResponseNodes();
		}
		return updateProfileImageeMapper;

	}

}
