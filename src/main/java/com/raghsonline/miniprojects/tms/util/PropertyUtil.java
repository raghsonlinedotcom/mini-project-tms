/**
 * 
 */
package com.raghsonline.miniprojects.tms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author raghavan.muthu
 *
 */
public class PropertyUtil 
{	
	private static List<ConfigFile> configFileList = new ArrayList<>();

	private static Properties _properties = new Properties();
	
	private static Properties _dbProperties = new Properties();
	
	private static Properties _dbUserProperties = new Properties();
	
	private static Properties _emailProperties = new Properties();
	
	private static Properties _emailUserProperties = new Properties();
	
	private static final String PROPS_FILE_NAME = "config.properties";
	
	private static final String DB_PROPS_FILE_NAME = "dbconfig.properties";
	
	private static final String DB_PROPS_USER_FILE_NAME = "dbconfig-user.properties";
	
	private static final String EMAIL_PROPS_FILE_NAME = "emailconfig.properties";
	
	private static final String EMAIL_PROPS_USER_FILE_NAME = "emailconfig-user.properties";
	
	public static final String KEY_APP_MODE = "app.mode";
	
	static {
		loadProps();
	}
	
	public static void loadProps() {
		_properties = loadProps(PROPS_FILE_NAME);
		_dbProperties = loadProps(DB_PROPS_FILE_NAME);
		_dbUserProperties = loadProps(DB_PROPS_USER_FILE_NAME);
		_emailProperties = loadProps(EMAIL_PROPS_FILE_NAME);
		_emailUserProperties = loadProps(EMAIL_PROPS_USER_FILE_NAME);
		
		System.out.println("--------------------");
		System.out.println("configFileList :: " + configFileList);
		System.out.println("--------------------");
	}
	
	public static Properties getProps() {
		return _properties;
	}
	
	public static Properties getDBProps() {
		return _dbProperties;
	}
	
	public static Properties getEmailProps() {
		return _emailProperties;
	}
	
	/**
	 * @return the configFileList
	 */
	public static List<ConfigFile> getConfigFileList() {
		return configFileList;
	}

	/**
	 * @param configFileList the configFileList to set
	 */
	public static void setConfigFileList(List<ConfigFile> configFileList) {
		PropertyUtil.configFileList = configFileList;
	}
	
	public static Properties loadProps(String propFileName) 
	{
		Properties _properties = new Properties();
		InputStream is = null;
		String classLoaderFile = Thread.currentThread().getContextClassLoader()
					.getResource(propFileName).getFile();
		File file = new File(classLoaderFile);
		
		System.out.println("File Object : " + file);
		System.out.println("File Path : " + file.getAbsolutePath());
		
		storeFilePath(file.getAbsolutePath());
		
		try {
			is = new FileInputStream(file);
			_properties.load(is);
			System.out.println("Properties has been loaded successfully with # "
						+ _properties.size() + " entries");
		}catch(FileNotFoundException fnfException) {
			System.err.println("Exception while accessing the config file - " + propFileName);
			System.err.println("Error Message : " + fnfException.getMessage());
			if(AppUtil.isAppDevMode) {
				fnfException.printStackTrace();
			}
		} catch (IOException exception) {
			System.err.println("Exception while loading the properties");
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		
		return _properties;
	}
	
	private static void storeFilePath(String absolutePath) 
	{
		if(StringUtil.isEmpty(absolutePath)) {
			System.err.println("ERROR!!! File Path [" + absolutePath + "] is empty/null.");
			return;
		}
		
		char pathSeparator = File.separatorChar;
		System.out.println("absolutePath : [" + absolutePath + "]");
		System.out.println("pathSeparator : " + pathSeparator);
		int lastIndexOfSeparator = absolutePath.lastIndexOf(pathSeparator);
		String fileName = absolutePath.substring(lastIndexOfSeparator+1);
		
		ConfigFile configFile = new ConfigFile(fileName, absolutePath);
		PropertyUtil.getConfigFileList().add(configFile);
	}

	public static String getPropertyValue(String key)
	{	
		return _properties.getProperty(key);
	}
	
	public static boolean isAppModeDev()
	{
		String value = _properties.getProperty(KEY_APP_MODE);
		
		return null!=value && value.equalsIgnoreCase("dev");
	}
	
	
	public static String getDBPropertyValue(String key)
	{
		String value = _dbProperties.getProperty(key);
		
		if(value.contains("${user}")) 
		{
			System.out.println("Key [" + key + "] is user specific. looking into the user property file.");
			
			value = _dbUserProperties.getProperty(key);
			
			if(StringUtil.isValid(value)) {
				System.out.println("....A valid value is obtained.");
			}
		}
		
		if(null==value || value.trim().length()<0) {
			//TODO Exception
			/* Mostly should be handled via GRC */
		}
		
		return value;
	}
	
	public static String getEmailPropertyValue(String key)
	{
		String value = _emailProperties.getProperty(key);
		
		if(value.contains("${user}")) 
		{
			System.out.println("Key [" + key + "] is user specific. looking into the user property file.");
			
			value = _emailUserProperties.getProperty(key);
			
			if(StringUtil.isValid(value)) {
				System.out.println("....A valid value is obtained.");
			}
		}
		
		if(null==value || value.trim().length()<0) {
			//TODO Exception
			/* Mostly should be handled via GRC */
		}
		
		return value;
	}
}
