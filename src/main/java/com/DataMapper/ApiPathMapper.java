package com.DataMapper;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApiPathMapper {
	

		public static Map<String, String> fileandenv = new HashMap<String, String>();
		public static Properties propMain = new Properties();
		public static Properties propPreSet = new Properties();

		public static Map<String, String> extendedPath(){

			try {
		FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir") + "/TestData/ApiPath.properties");
					propMain.load(fisDev);
		fileandenv.put("POST_USERS_DEVICE_TO_REGISTER_A_DEVICE", propMain.getProperty("POST_USERS_DEVICE_TO_REGISTER_A_DEVICE"));	
		fileandenv.put("POST_USERS_TO_CREATE_USER", propMain.getProperty("POST_USERS_TO_CREATE_USER"));
		fileandenv.put("POST_USERS_VERIFYOTP", propMain.getProperty("POST_USERS_VERIFYOTP"));
		fileandenv.put("GET_USERS_VERIFYOTP_USERNAME", propMain.getProperty("GET_USERS_VERIFYOTP_USERNAME"));
		fileandenv.put("GET_USERS_PROFILE", propMain.getProperty("GET_USERS_PROFILE"));
		fileandenv.put("GET_USERS_OTHER_PROFILE", propMain.getProperty("GET_USERS_OTHER_PROFILE"));
		fileandenv.put("PUT_USERS_UPDATE_PROFILE", propMain.getProperty("PUT_USERS_UPDATE_PROFILE"));
		fileandenv.put("PUT_USERS_UPDATE_PREFERENCES", propMain.getProperty("PUT_USERS_UPDATE_PREFERENCES"));
		fileandenv.put("GET_USERS_PREFERENCES", propMain.getProperty("GET_USERS_PREFERENCES"));
		fileandenv.put("PUT_USERS_UPDATE_PROFILE_IMAGE", propMain.getProperty("PUT_USERS_UPDATE_PROFILE_IMAGE"));
		fileandenv.put("GET_USERS_FOLLOWING_ME", propMain.getProperty("GET_USERS_FOLLOWING_ME"));
		fileandenv.put("PUT_USERS_SAVE_UPI_DETAILS", propMain.getProperty("PUT_USERS_SAVE_UPI_DETAILS"));
		fileandenv.put("PUT_USERS_SAVE_BANK_DETAILS", propMain.getProperty("PUT_USERS_SAVE_BANK_DETAILS"));
		fileandenv.put("GET_USERS_BANK_DETAILS", propMain.getProperty("GET_USERS_BANK_DETAILS"));
		fileandenv.put("DELETE_USERS_BANK_DETAILS", propMain.getProperty("DELETE_USERS_BANK_DETAILS"));
		fileandenv.put("DELETE_USERS_UPI_DETAILS", propMain.getProperty("DELETE_USERS_UPI_DETAILS"));
		fileandenv.put("POST_USERS_UNFOLLOW", propMain.getProperty("POST_USERS_UNFOLLOW"));
		fileandenv.put("POST_USERS_FOLLOW", propMain.getProperty("POST_USERS_FOLLOW"));
		
	}
			catch (Exception e) {
		System.out.println(e);
	}

	return fileandenv;


		}
		public static Map<String, String> getConfigReader(){
			if (fileandenv == null) {
				fileandenv = extendedPath();
			}
			
			return fileandenv;
		}

}
