package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class UpdatePreferenceMapper {

	public static Map<String, String> updatePreferenceMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> UpdatePreference_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_UpdatePreference.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				updatePreferenceMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return updatePreferenceMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (updatePreferenceMapper == null) {
			updatePreferenceMapper = UpdatePreference_ResponseNodes();
		}
		return updatePreferenceMapper;

	}

}
