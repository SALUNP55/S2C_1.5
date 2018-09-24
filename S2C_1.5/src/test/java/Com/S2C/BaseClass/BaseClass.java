package Com.S2C.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidKeyCode;


public class BaseClass {
	
	public static AndroidDriver<WebElement> driver;
	public static URL remoteUrl;
	public File propertyfile;
	public static Properties properties;
	public WebDriverWait wait;
	public static  String str;
	
	
	
	public void intilization() throws Exception{
		System.out.println("Inside Initilization");
		FileInputStream file = new FileInputStream("//Users//vishalkadam//Documents//workspace//S2C_1.5//src//test//java//Com//S2C//BaseClass//PropertyFile.properties"); 
	    properties = new Properties();
		properties.load(file);
		
		
		
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		   desiredCapabilities.setCapability("deviceName", properties.getProperty("deviceName"));
		   desiredCapabilities.setCapability("platformName", properties.getProperty("platformName"));
		   desiredCapabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
		   desiredCapabilities.setCapability("appPackage", properties.getProperty("appPackage"));
		   desiredCapabilities.setCapability("appActivity", properties.getProperty("appActivity"));
		  
		
		   remoteUrl = new URL("http://localhost:4723/wd/hub");
           driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
           Thread.sleep(10000);
           System.out.println("End of Initilization");
           wait=new WebDriverWait(driver, 100);
           System.out.println("Inside LoginTest Method" );
           driver.findElement(By.id(properties.getProperty("usernameID"))).sendKeys(properties.getProperty("Username"));
           driver.findElement(By.id(properties.getProperty("passwordID"))).sendKeys(properties.getProperty("Password"));
           driver.findElement(By.id(properties.getProperty("loginButttonID"))).click();
           System.out.println("Login Sucessfull"); 
           str=properties.getProperty("macID");
           
            

	}


}

/*{
 "deviceName": “moto_g__5_”,
 "udid": “ZY3223FQLL”,
 "platformName": "Android",
 "platformVersion": "7.0",
 "appPackage": "com.whirlpool.android.wpapp",
 "appActivity": "com.whirlpool.android.smartgrid.controller.home.LaunchActivity”
}*/
