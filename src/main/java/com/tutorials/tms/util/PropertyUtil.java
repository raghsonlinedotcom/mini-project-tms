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
	
	private static Properties _dbProperties = new Properties();
	
	private static final String PROPS_FILE_NAME = "config.properties";
	
	private static final String DB_PROPS_FILE_NAME = "dbconfig.properties";
	
	public static final String KEY_APP_MODE = "app.mode";
	
	static {
		loadProps();
	}
	
	public static void loadProps() {
		_properties = loadProps(PROPS_FILE_NAME);
		_dbProperties = loadProps(DB_PROPS_FILE_NAME);
	}
	
	public static Properties getProps() {
		return _properties;
	}
	
	public static Properties loadProps(String propFileName) 
	{
		InputStream is = null;
		String classLoaderFile = Thread.currentThread().getContextClassLoader()
					.getResource(propFileName).getFile();
		File file = new File(classLoaderFile);
		
		System.out.println("File Object : " + file);
		System.out.println("File Path : " + file.getAbsolutePath());
		
		try {
			is = new FileInputStream(file);
			_properties.load(is);
			System.out.println("Properties has been loaded successfully with # "
						+ _properties.size() + " entries");
		}catch(FileNotFoundException fnfException) {
			System.err.println("Exception while accessing the config file - " + propFileName);
			System.err.println("Error Message : " + fnfException.getMessage());
			//TODO; Remove it in Prod, use it only in Dev
			fnfException.printStackTrace();
		} catch (IOException exception) {
			System.err.println("Exception while loading the properties");
			System.err.println("Error Message : " + exception.getMessage());
			//TODO; Remove it in Prod, use it only in Dev
			exception.printStackTrace();
		}
		
		return _properties;
	}
	
	public static String getPropertyValue(String key)
	{
		/*if(key.startsWith("jdbc")) {
			return _dbProperties.getProperty(key); 
		}*/
		
		return _properties.getProperty(key);
	}
	
	public static boolean isAppModeDev()
	{
		String value = _properties.getProperty(KEY_APP_MODE);
		
		return null!=value && value.equalsIgnoreCase("dev");
	}
	
	public static String getDBPropertyValue(String key)
	{
		return _dbProperties.getProperty(key);
	}
}
