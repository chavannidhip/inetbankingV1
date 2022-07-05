package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fs= new FileInputStream(src);
			pro = new Properties();
			pro.load(fs);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is : "+ e);
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURl");
		return url;
	}

	public String getUserName()
	{
		String username = pro.getProperty("userName");
		return username;
	}

	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}

}
