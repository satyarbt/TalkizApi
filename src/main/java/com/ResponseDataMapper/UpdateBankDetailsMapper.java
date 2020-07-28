package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UpdateBankDetailsMapper {

	public static Map<String, String> updateBankdetailsMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> UpdateBank_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_UpdateBankDetails.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				updateBankdetailsMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return updateBankdetailsMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (updateBankdetailsMapper == null) {
			updateBankdetailsMapper = UpdateBank_ResponseNodes();
		}
		return updateBankdetailsMapper;

	}

}