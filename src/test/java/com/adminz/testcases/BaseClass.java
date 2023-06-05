package com.adminz.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.adminzonrender.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger Logger;
	@SuppressWarnings("static-access")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		//String projectPathChrome = System.getProperty("user.dir");

		Logger=Logger.getLogger("eagrocommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else  if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgepath());
			driver=new EdgeDriver();
		}
		driver.get(baseURL);
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
