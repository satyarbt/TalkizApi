package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class UpdateUPIDetailsMapper {

	public static Map<String, String> updateUpidetailsMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> UpdateUpi_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_UpdateUpiDetails.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				updateUpidetailsMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return updateUpidetailsMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (updateUpidetailsMapper == null) {
			updateUpidetailsMapper = UpdateUpi_ResponseNodes();
		}
		return updateUpidetailsMapper;

	}

}
