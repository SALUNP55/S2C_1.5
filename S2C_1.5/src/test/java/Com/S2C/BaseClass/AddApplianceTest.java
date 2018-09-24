package Com.S2C.BaseClass;

	import java.util.ArrayList;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;
    import io.appium.java_client.android.AndroidKeyCode;






	@SuppressWarnings("deprecation")
	public class AddApplianceTest extends BaseClass{
		
		WebElement addappliancebutton;
		WebElement beginbutton;
		WebElement denybutton;
		WebElement settingbutton;
		WebElement Manuallyentercodebutton;
		WebElement entersaidtextbox;
		WebElement entermacidtextbox;
		WebElement selectappliaceType;
		WebElement returnthis;
		WebElement enterSAIDtextbox;
		WebElement enterSAIDNextButton;
	
		
		
	
	
		
		
		
		
		public WebElement addApplianceButtonElement(){
			addappliancebutton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(properties.getProperty("addApplianceButtonId")))));
			return addappliancebutton;
		}
		public WebElement begibButtonElement(){
			beginbutton=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.whirlpool.android.s2ckit.wp_staging:id/letsconn_next_button"))));
			return beginbutton;
		}
		public WebElement denyButtonElement(){
			denybutton=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.android.packageinstaller:id/permission_deny_button"))));
			return denybutton;
		}
		public WebElement settingButtonElement(){
			settingbutton =wait.until(ExpectedConditions.visibilityOf(driver.findElementById("android:id/button1")));
			return settingbutton;
		}
		public WebElement Manuallyentercode(){
			Manuallyentercodebutton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.whirlpool.android.s2ckit.wp_staging:id/provisioning_scan_text3")))) ;
			return Manuallyentercodebutton;
			
		}
		public WebElement enterSAIDTextBoxElement(){
			entersaidtextbox=wait.until(ExpectedConditions.visibilityOf(driver.findElementById(properties.getProperty("enterSAIDTextBoxId"))));
			return entersaidtextbox;
		}
		public WebElement enterMACTextBoxElement(){
			entermacidtextbox=wait.until(ExpectedConditions.visibilityOf(driver.findElementById(properties.getProperty("enterMACTextBoxId"))));
			return entermacidtextbox;
		}
		
		public WebElement enterSAIDElement(){
			enterSAIDtextbox = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(properties.getProperty("enterSAIDTextBoxId")))));
			return enterSAIDtextbox;
		}
		
		public WebElement enterSAIDNextButtonElement(){
			enterSAIDNextButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(properties.getProperty("enterSAIDScreenNextButtonId")))));
			return enterSAIDNextButton;
		}
		public WebElement applianceTypeWebElement(String appliancename){
			
		
			
		  switch(appliancename)	{
		  
		  case "Air Conditioner":
			  returnthis=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.LinearLayout[1]"))));
			  break;
			 
		  case "Washer":
			  returnthis=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.LinearLayout[2]"))));
			  break;
			
		  case "Dryer":
			  returnthis= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.LinearLayout[3]"))));
			  break;
			 
			}
		  
		  return returnthis;
		  
		  
			}

			
			
			
			
			
			
	
		
	
		
		
		@BeforeSuite
		public void setEnvironment() throws Exception{
			intilization();
		}
		@BeforeMethod
		public void waitTime(){
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		

		@Test(priority=0)
		public void addApplianceTest() throws Exception{
			
			addApplianceButtonElement().click();
			begibButtonElement().click();
			denyButtonElement().click();
			settingButtonElement().click();
			driver.pressKeyCode(AndroidKeyCode.BACK);
			Manuallyentercode().click();
			
		}
		@Test(priority=1)
		public void testApplianceModelNumbers() throws Exception{
			String hello=properties.getProperty("macID");
			enterMACTextBoxElement().clear();
			enterMACTextBoxElement().sendKeys(properties.getProperty("macID"));
			enterSAIDElement().sendKeys(properties.getProperty("SAID"));
			driver.hideKeyboard();
			enterSAIDNextButtonElement().click();


			
			

		
			
		
				   

			
			
		}
	
	}
	
	
	
		
			
			
			
			
		
		    	
	
		     
			
		  
		
					
				
		
			
	
				
	
		





	