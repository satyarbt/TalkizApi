package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DeleteUpiDetailsMapper {

	public static Map<String, String> deleteUpidetailsMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> DeleteUpi_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_DeleteUpiDetails.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				deleteUpidetailsMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return deleteUpidetailsMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (deleteUpidetailsMapper == null) {
			deleteUpidetailsMapper = DeleteUpi_ResponseNodes();
		}
		return deleteUpidetailsMapper;

	}

}
