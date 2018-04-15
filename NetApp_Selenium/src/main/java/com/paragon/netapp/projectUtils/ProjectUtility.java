package com.paragon.netapp.projectUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ProjectUtility
{
	/**
	 * @param key
	 * @return
	 * Get the data from Property File attached with Projecta
	 * 
	 */
	public static String getProperty(String key)
	{
		String value="";
		
		try {
			String filepath=".//src//main//resources//config.properties";
			FileInputStream fileInput = new FileInputStream(new File(filepath));
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			value = properties.getProperty(key);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return value;
		
	}
	
	public static void main(String[] args) {
		
		ProjectUtility.getProperty("Browser");
	}

}
