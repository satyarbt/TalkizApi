package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class UpdateProfileMapper {

	public static Map<String, String> updateProfileMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> UpdateProfile_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_UpdateProfile.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				updateProfileMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return updateProfileMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (updateProfileMapper == null) {
			updateProfileMapper = UpdateProfile_ResponseNodes();
		}
		return updateProfileMapper;

	}

}