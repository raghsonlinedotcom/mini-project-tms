/**
 * 
 */
package com.tutorials.tms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author raghavan.muthu
 *
 */
public class PropertyUtil {
	
	private static Properties _properties = new Properties();
	
	private static final String PROPS_FILE_NAME = "config.properties";
	
	static {
		loadProps();
	}
	
	public static Properties getProps() {
		return _properties;
	}
	
	public static void loadProps() 
	{
		InputStream is = null;
		String classLoaderFile = Thread.currentThread().getContextClassLoader().getResource(PROPS_FILE_NAME).getFile();
		File file = new File(classLoaderFile);
		
		System.out.println("File Object : " + file);
		System.out.println("File Path : " + file.getAbsolutePath());
		
		try {
			is = new FileInputStream(file);
			_properties.load(is);
			System.out.println("Properties has been loaded successfully with # "
						+ _properties.size() + " entries");
		}catch(FileNotFoundException fnfException) {
			System.err.println("Exception while accessing the config file - " + PROPS_FILE_NAME);
			System.err.println("Error Message : " + fnfException.getMessage());
			//TODO; Remove it in Prod, use it only in Dev
			fnfException.printStackTrace();
		} catch (IOException exception) {
			System.err.println("Exception while loading the properties");
			System.err.println("Error Message : " + exception.getMessage());
			//TODO; Remove it in Prod, use it only in Dev
			exception.printStackTrace();
		}
	}
	
	public static String getPropertyValue(String key)
	{
		return _properties.getProperty(key);
	}
}
