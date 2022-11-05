package com.configuration;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.resoursesreader.ResourcesURLsReader;

public class BaseUI {
	
	ResourcesURLsReader resources = new ResourcesURLsReader();
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");  
		System.setProperty("selenide.browser", "Chrome");
		Configuration.browserSize = "1920x1080";
		open(resources.getURL());
	}
	
	public void closeBrowser() {
		Selenide.closeWebDriver();
	}

}
