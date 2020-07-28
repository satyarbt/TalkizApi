package com.ApiConfig;

import java.util.HashMap;
import java.util.Map;

import com.DataMapper.EnvironmentDataMapper;

public class HeaderConfig {

public Map<String, String> defaultHeader(){
		
		Map<String, String> defaultHeader=new HashMap<String, String>();
		defaultHeader.put("Content-Type", "application/json");
		return defaultHeader;
		
	}
	
public Map<String, String> defaultHeaderWithToken(){
		
		Map<String, String> defaultHeaderWithToken=new HashMap<String, String>();
		defaultHeaderWithToken.put("Content-Type", "application/json");
		defaultHeaderWithToken.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqd3REYXRhIjp7InVzZXJfaWQiOjIxMjIsIm1vYmlsZSI6Ijk3MDM3MzQ3MzQifSwiaWF0IjoxNTkxNTIzNzM2fQ.dGCfzafNLiyeiMgCH2msixMiS6Nnkj-spBvdCMwPbHI");
		return defaultHeaderWithToken;
		
	}

public Map<String, String> HeaderWithUpdatedToken(){
	
	Map<String, String> defaultHeaderWithToken=new HashMap<String, String>();
	defaultHeaderWithToken.put("Authorization", "Bearer "+EnvironmentDataMapper.fileandenv.get("token"));
	return defaultHeaderWithToken;
	
}
public Map<String, String> DefalutHeaderWithUpdatedToken(){
	
	Map<String, String> defaultHeaderWithToken=new HashMap<String, String>();
	defaultHeaderWithToken.put("Content-Type", "application/json");
	defaultHeaderWithToken.put("Authorization", "Bearer "+EnvironmentDataMapper.fileandenv.get("token"));
	return defaultHeaderWithToken;
	
}
public Map<String, String> HeaderWithMultipartANDUpdatedToken(){
	
	Map<String, String> defaultHeaderWithToken=new HashMap<String, String>();
	defaultHeaderWithToken.put("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");
	defaultHeaderWithToken.put("Authorization", "Bearer "+EnvironmentDataMapper.fileandenv.get("token"));
	return defaultHeaderWithToken;
	
}

}
