/**
 * 
 */
package com.raghsonline.miniprojects.tms.util;

/**
 * @author raghavan.muthu
 *
 */
public class ConfigFile 
{
	private String fileName;
	
	private String absolutePath;
	
	private int noOfEntries;

	/**
	 * @param fileName
	 * @param absolutePath
	 */
	public ConfigFile(String fileName, String absolutePath) {
		super();
		this.fileName = fileName;
		this.absolutePath = absolutePath;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the absolutePath
	 */
	public String getAbsolutePath() {
		return absolutePath;
	}

	/**
	 * @param absolutePath the absolutePath to set
	 */
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	/**
	 * @return the noOfEntries
	 */
	public int getNoOfEntries() {
		return noOfEntries;
	}

	/**
	 * @param noOfEntries the noOfEntries to set
	 */
	public void setNoOfEntries(int noOfEntries) {
		this.noOfEntries = noOfEntries;
	}
	

	@Override
	public String toString() {
		return "ConfigFile [" 
				+ " hashCode()= " + hashCode() 
				+ ", fileName=" + fileName 
				+ ", absolutePath=" + absolutePath 
				+ ", noOfEntries=" + noOfEntries;
	}
}
