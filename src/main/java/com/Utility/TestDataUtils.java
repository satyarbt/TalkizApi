package com.Utility;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.RandomStringUtils;

import com.DataMapper.EnvironmentDataMapper;

public class TestDataUtils {

		
		public static String randomNumber() throws ConfigurationException, IOException
		{
			String chars = "0123456789";
			String name="Automation";
			int length = 4;
			String randomString = RandomStringUtils.random(length, chars);
			System.out.println(randomString);
			String PhoneNumber = EnvironmentDataMapper.envAndFile().get("phoneNumber");
			String PhNo = PhoneNumber.substring(0, 6);
			String PhNumber = PhNo.concat(randomString);
			String userName=name.concat(randomString);
			System.out.println(PhNumber);
			PropertiesConfiguration config=new PropertiesConfiguration(System.getProperty("user.dir")+"/TestData/dev.properties");
			config.setProperty("phoneNumber", PhNumber);
			config.setProperty("PhNo_New", PhNo);
			config.setProperty("username", userName);
			config.save();
			return PhNumber;
			
		}

	}



