package com.RequestBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.DataMapper.EnvironmentDataMapper;

public class RequestBody {

	Properties request = new Properties();

	public Map<String, String> RequestBody_DeviceRegister() throws IOException {
		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/RequestBody_DeviceRegister.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}
		return body;
	}

	public Map<String, String> RequestBody_CreateUser() throws IOException {
		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/CreateUser.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}
		return body;
	}

	public Map<String, String> RequestBody_VerifyOTP() throws IOException {
		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/RequestBody_VerifyOTP.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();

		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}
		return body;
	}

	public Map<String, String> QueryParams_VerifyUserName() throws IOException {
		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/QueryParams_VerifyUserName.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}

		return body;
	}

	public Map<String, String> QueryParams_VerifyOTP() throws IOException {

		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/QueryParams_VerifyOTP.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}

		return body;
	}

	public Map<String, String> RequestBody_VerifyOTPUsername() throws IOException {

		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/RequestBody_VerifyOTPUsername.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}
		return body;
	}

	public Map<String, String> RequestBody_Login() throws IOException {

		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/RequestBody_Login.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}
		return body;
	}

	public Map<String, String> QueryParams_GetOtherUserProfile() throws IOException {

		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/QueryParams_GetOtherUserProfile.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}
		return body;
	}

	public Map<String, String> RequestBody_UpdateProfile() throws IOException {

		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/RequestBody_UpdateProfile.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}

		return body;
	}

	public Map<String, String> RequestBody_UpdatePreference() throws IOException {

		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/RequestBody_UpdatePreference.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}

		return body;
	}

	public Map<String, String> RequestBody_UpdateProfileImage() {

		Map<String, String> body = new HashMap<String, String>();
		String Filepath = System.getProperty("user.dir");
		System.out.println(Filepath);
		return body;
	}

	public Map<String, String> QueryParams_UsersFollowingMe() throws IOException {

		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/QueryParams_UsersFollowingMe.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}

		return body;
	}

	public Map<String, String> RequestBody_UpdateUPIDetails() throws IOException {
		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/RequestBody_UpdateUPIDetails.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}
		return body;

	}

	public Map<String, String> RequestBody_UpdateBankDetails() throws IOException {

		FileInputStream fisDev = new FileInputStream(
				System.getProperty("user.dir") + "/TestData/RequestBody_UpdateBankDetails.properties");
		request.load(fisDev);
		Map<String, String> body = new HashMap<String, String>();
		for (int i = 1; i <= request.size(); i++) {
			body.put(request.getProperty("key" + i),
					EnvironmentDataMapper.envAndFile().get(request.getProperty("key" + i)));
		}

		return body;
	}
}
