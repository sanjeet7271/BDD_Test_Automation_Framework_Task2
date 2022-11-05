package com.resoursesreader;

import com.configuration.ConfigurationReader;

/**
 * 
 * @author Sanjeet Kumar Pandit
 *
 */
public class ResourcesURLsReader extends ConfigurationReader {

	private String getRandomBaseURI;
	private String getURI;
	private String getRandomResourceURI;
	private static ResourcesURLsReader instance = null;

	public ResourcesURLsReader() {
		setConfig();
	}

	public static ResourcesURLsReader getInstance() {
		if (null == instance) {
			instance = new ResourcesURLsReader();
		}
		return instance;
	}

	public void setConfig() {
		this.getRandomBaseURI = prop.getProperty("RANDOM_URL");
		this.getURI = prop.getProperty("URL");
		this.getRandomResourceURI = prop.getProperty("RANDOMRESOURCEURI");

	}

	public String getRandomBaseURI() {
		logger.info("Random base url is loading...");
		String getRandomBaseURI = this.getRandomBaseURI;
		return getRandomBaseURI;
	}

	public String getURL() {
		logger.info("Random Jokes base url is loading...");
		String getURI = this.getURI;
		return getURI;
	}

	public String getRandomResourceURI() {
		logger.info("Jokes endpoint url is loading...");
		String getRandomResourceURI = this.getRandomResourceURI;
		return getRandomResourceURI;
	}
}
