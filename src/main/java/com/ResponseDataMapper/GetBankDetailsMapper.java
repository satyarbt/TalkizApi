package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GetBankDetailsMapper {

	public static Map<String, String> getBankdetailsMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> GetBank_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_GetBankDetails.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				getBankdetailsMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return getBankdetailsMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (getBankdetailsMapper == null) {
			getBankdetailsMapper = GetBank_ResponseNodes();
		}
		return getBankdetailsMapper;

	}

}