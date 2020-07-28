package com.RequestBuilder;

import java.util.HashMap;
import java.util.Map;

import com.DataMapper.EnvironmentDataMapper;

public class RequestBody {
	
	public Map<String, String> RequestBody_DeviceRegister()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("device_id", EnvironmentDataMapper.envAndFile().get("deviceID"));
		body.put("under18", "flase");
		body.put("device_location", "hyderabad");
		body.put("device_type", EnvironmentDataMapper.envAndFile().get("deviceType_IOS"));
		body.put("device_token", EnvironmentDataMapper.envAndFile().get("deviceToken"));
		return body;
	}
	
	public Map<String, String> RequestBody_CreateUser()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("mobile", EnvironmentDataMapper.envAndFile().get("phoneNumber"));
		body.put("deviceType", EnvironmentDataMapper.envAndFile().get("deviceType_IOS"));
		body.put("user_id", EnvironmentDataMapper.envAndFile().get("user_id"));
		return body;
	}
	
	public Map<String, String> RequestBody_VerifyOTP()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("mobile", EnvironmentDataMapper.envAndFile().get("phoneNumber"));
		body.put("deviceType", EnvironmentDataMapper.envAndFile().get("deviceType_IOS"));
		body.put("user_id", EnvironmentDataMapper.envAndFile().get("user_id"));
		body.put("device_id", EnvironmentDataMapper.envAndFile().get("deviceID"));
		body.put("device_location", EnvironmentDataMapper.envAndFile().get("device_location"));
		body.put("device_token", EnvironmentDataMapper.envAndFile().get("deviceToken"));
		body.put("otp", EnvironmentDataMapper.envAndFile().get("otp"));
		body.put("username", EnvironmentDataMapper.envAndFile().get("username"));
		return body;
	}
	
	public Map<String, String> QueryParams_VerifyUserName()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("username", EnvironmentDataMapper.envAndFile().get("username"));
		return body;
	}
	
	public Map<String, String> QueryParams_VerifyOTP()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("otp", EnvironmentDataMapper.envAndFile().get("otp"));
		body.put("mobile", EnvironmentDataMapper.envAndFile().get("phoneNumber"));
		body.put("user_id", EnvironmentDataMapper.envAndFile().get("user_id"));
		return body;
	}
	
	public Map<String, String> RequestBody_VerifyOTPUsername()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("otp", EnvironmentDataMapper.envAndFile().get("otp"));
		body.put("mobile", EnvironmentDataMapper.envAndFile().get("phoneNumber_Existing"));
		body.put("user_id", EnvironmentDataMapper.envAndFile().get("user_id"));
		body.put("username", EnvironmentDataMapper.envAndFile().get("username"));
		body.put("under18", EnvironmentDataMapper.envAndFile().get("under18"));	
		return body;
	}
	
	public Map<String, String> RequestBody_Login()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("mobile", EnvironmentDataMapper.envAndFile().get("phoneNumber_Existing"));
		body.put("deviceType", EnvironmentDataMapper.envAndFile().get("deviceType_IOS"));
		body.put("user_id", EnvironmentDataMapper.envAndFile().get("user_id"));
		return body;
	}
	
	public Map<String, String> QueryParams_GetOtherUserProfile()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("id", EnvironmentDataMapper.envAndFile().get("id"));
		return body;
	}

	public Map<String, String> RequestBody_UpdateProfile()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("full_name", EnvironmentDataMapper.envAndFile().get("full_name"));
		body.put("dob", EnvironmentDataMapper.envAndFile().get("dob"));
		body.put("email", EnvironmentDataMapper.envAndFile().get("email"));
		body.put("gender", EnvironmentDataMapper.envAndFile().get("gender"));
		body.put("mobile", EnvironmentDataMapper.envAndFile().get("phoneNumber_Existing"));
		return body;
	}
	
	public Map<String, String> RequestBody_UpdatePreference()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("display_language", EnvironmentDataMapper.envAndFile().get("display_language"));
		return body;
	}
	public Map<String, String> RequestBody_UpdateProfileImage()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		String Filepath=System.getProperty("user.dir");
		System.out.println(Filepath);
		body.put("file", Filepath+"/"+EnvironmentDataMapper.envAndFile().get("file"));
		return body;
	}
	
	public Map<String, String> QueryParams_UsersFollowingMe()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("id", EnvironmentDataMapper.envAndFile().get("id"));
		return body;
	}
	
	public Map<String, String> RequestBody_UpdateUPIDetails()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("transaction_source", EnvironmentDataMapper.envAndFile().get("transaction_source_upi"));
		body.put("upi", EnvironmentDataMapper.envAndFile().get("upi"));
		return body;
	}
	
	public Map<String, String> RequestBody_UpdateBankDetails()
	{
		
		Map<String, String> body=new HashMap<String, String>();
		body.put("transaction_source", EnvironmentDataMapper.envAndFile().get("transaction_source_bank"));
		body.put("bank_account_full_name", EnvironmentDataMapper.envAndFile().get("bank_account_full_name"));
		body.put("accountNumber", EnvironmentDataMapper.envAndFile().get("accountNumber"));
		body.put("ifscCode", EnvironmentDataMapper.envAndFile().get("ifscCode"));
		body.put("accountType", EnvironmentDataMapper.envAndFile().get("accountType"));
		return body;
	}


}
