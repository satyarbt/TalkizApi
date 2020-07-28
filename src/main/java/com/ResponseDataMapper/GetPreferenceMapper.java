package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GetPreferenceMapper {

	public static Map<String, String> getPreferenceMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> GetPreference_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_GetPreference.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				getPreferenceMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return getPreferenceMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (getPreferenceMapper == null) {
			getPreferenceMapper = GetPreference_ResponseNodes();
		}
		return getPreferenceMapper;

	}

}
