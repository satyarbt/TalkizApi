package com.ResponseDataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DeleteBankDetailsMapper {

	public static Map<String, String> deleteBankdetailsMapper = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> DeleteBank_ResponseNodes() {
		try {
			FileInputStream APINodes = new FileInputStream(
					System.getProperty("user.dir") + "/TestData/Nodes_DeleteBankDetails.properties");
			propMain.load(APINodes);

			for (int i = 1; i <= propMain.size(); i++) {
				deleteBankdetailsMapper.put(propMain.getProperty("Node" + i), propMain.getProperty("Node" + i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return deleteBankdetailsMapper;
	}

	public static Map<String, String> getConfigReader() {
		if (deleteBankdetailsMapper == null) {
			deleteBankdetailsMapper = DeleteBank_ResponseNodes();
		}
		return deleteBankdetailsMapper;

	}

}