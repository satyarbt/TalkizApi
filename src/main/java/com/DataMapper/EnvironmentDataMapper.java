package com.DataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvironmentDataMapper {

	public static Map<String, String> fileandenv = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> envAndFile(){

		String environment = System.getProperty("env");
		try {
			if (environment.equalsIgnoreCase("dev")) {

				FileInputStream fisDev = new FileInputStream(
						System.getProperty("user.dir") + "/TestData/dev.properties");
				propMain.load(fisDev);
				fileandenv.put("baseUrl", propMain.getProperty("baseUrl"));
				fileandenv.put("deviceType_Android", propMain.getProperty("deviceType_Android"));
				fileandenv.put("deviceType_IOS", propMain.getProperty("deviceType_IOS"));
				fileandenv.put("phoneNumber", propMain.getProperty("phoneNumber"));
				fileandenv.put("phoneNumber_Existing", propMain.getProperty("phoneNumber_Existing"));
				fileandenv.put("baseToken", propMain.getProperty("baseToken"));
				fileandenv.put("deviceID", propMain.getProperty("device_ID"));
				fileandenv.put("deviceToken", propMain.getProperty("device_Token"));
				fileandenv.put("user_id", propMain.getProperty("user_id"));
				fileandenv.put("otp", propMain.getProperty("otp"));
				fileandenv.put("device_location", propMain.getProperty("device_location"));
				fileandenv.put("under18", propMain.getProperty("under18"));
				fileandenv.put("phoneNumber_Existing", propMain.getProperty("phoneNumber_Existing"));
				fileandenv.put("ResponseTime", propMain.getProperty("ResponseTime"));
				fileandenv.put("token", propMain.getProperty("token"));
				fileandenv.put("id", propMain.getProperty("OtherUser_id"));
				fileandenv.put("full_name", propMain.getProperty("full_name"));
				fileandenv.put("dob", propMain.getProperty("dob"));
				fileandenv.put("email", propMain.getProperty("email"));
				fileandenv.put("gender", propMain.getProperty("gender"));
				fileandenv.put("mobile", propMain.getProperty("phoneNumber_Existing"));
				fileandenv.put("display_language", propMain.getProperty("display_language"));
				fileandenv.put("file", propMain.getProperty("file"));
				fileandenv.put("transaction_source_upi", propMain.getProperty("transaction_source_upi"));
				fileandenv.put("upi", propMain.getProperty("upiID"));
				fileandenv.put("transaction_source_bank", propMain.getProperty("transaction_source_bank"));
				fileandenv.put("bank_account_full_name", propMain.getProperty("bank_account_full_name"));
				fileandenv.put("accountNumber", propMain.getProperty("accountNumber"));
				fileandenv.put("ifscCode", propMain.getProperty("ifscCode"));
				fileandenv.put("accountType", propMain.getProperty("accountType"));

			} else {
				FileInputStream fisProd = new FileInputStream(
						System.getProperty("user.dir") + "/TestData/production.properties");
				propMain.load(fisProd);
				fileandenv.put("baseUrl", propMain.getProperty("baseUrl"));
				fileandenv.put("deviceType_Android", propMain.getProperty("deviceType_Android"));
				fileandenv.put("deviceType_IOS", propMain.getProperty("deviceType_IOS"));
				fileandenv.put("phoneNumber", propMain.getProperty("phoneNumber"));
				fileandenv.put("phoneNumber_Existing", propMain.getProperty("phoneNumber_Existing"));
				fileandenv.put("baseToken", propMain.getProperty("baseToken"));
				fileandenv.put("deviceID", propMain.getProperty("device_ID"));
				fileandenv.put("deviceToken", propMain.getProperty("device_Token"));
				fileandenv.put("user_id", propMain.getProperty("user_id"));
				fileandenv.put("otp", propMain.getProperty("otp"));
				fileandenv.put("device_location", propMain.getProperty("device_location"));
				fileandenv.put("under18", propMain.getProperty("under18"));
				fileandenv.put("phoneNumber_Existing", propMain.getProperty("phoneNumber_Existing"));
				fileandenv.put("ResponseTime", propMain.getProperty("ResponseTime"));
				fileandenv.put("token", propMain.getProperty("token"));
				fileandenv.put("id", propMain.getProperty("OtherUser_id"));
				fileandenv.put("full_name", propMain.getProperty("full_name"));
				fileandenv.put("dob", propMain.getProperty("dob"));
				fileandenv.put("email", propMain.getProperty("email"));
				fileandenv.put("gender", propMain.getProperty("gender"));
				fileandenv.put("mobile", propMain.getProperty("phoneNumber_Existing"));
				fileandenv.put("display_language", propMain.getProperty("display_language"));
				fileandenv.put("file", propMain.getProperty("file"));
				fileandenv.put("transaction_source_upi", propMain.getProperty("transaction_source_upi"));
				fileandenv.put("upi", propMain.getProperty("upiID"));
				fileandenv.put("transaction_source_bank", propMain.getProperty("transaction_source_bank"));
				fileandenv.put("bank_account_full_name", propMain.getProperty("bank_account_full_name"));
				fileandenv.put("accountNumber", propMain.getProperty("accountNumber"));
				fileandenv.put("ifscCode", propMain.getProperty("ifscCode"));
				fileandenv.put("accountType", propMain.getProperty("accountType"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return fileandenv;
	}

	public static Map<String, String> getConfigReader(){
		if (fileandenv == null) {
			fileandenv = envAndFile();
		}
		return fileandenv;

	}

}
