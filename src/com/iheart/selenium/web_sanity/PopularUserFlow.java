package com.iheart.selenium.web_sanity;


import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import java.util.*;


public class PopularUserFlow extends Page {

	
	//Signup info
	private final String _EMAIL = "iheartRadio.tribecca@gmail.com";
	private final String _PASSWORD = "iheart001";
	
	@FindBy(css="body > div.pageWrapper > div.nowPlayingWrapper.full > div > a > span.cta > span:nth-child(1)")
		private WebElement listenLive;
	
	
	@FindBy(css="[name='userName'][type='text']")  private WebElement email;
	@FindBy(css="[name='password'][type='password']")  private WebElement password;
	
	@FindBy(css="#dialog > div > div.dialog.ui-on-grey > div.wrapper > div > div > form > div:nth-child(3) > section > input[type='text']")
		private WebElement zipCode;
	
	@FindBy(name="birthYear") private WebElement birthYear; 
	
	@FindBy(css="#dialog > div > div.dialog.ui-on-grey > div.wrapper > div > div > form > div:nth-child(4) > div > label:nth-child(1) > span.input-radio > input[type='radio']")
			private WebElement gender_female;		
	
	@FindBy(name="termsAcceptanceDate") private WebElement termsAcceptanceDate;
	
	@FindBy(css="#dialog > div > div.dialog.ui-on-grey > div.wrapper > div > div > form > button") private WebElement signUp;

	
	 public PopularUserFlow() {
			
	}
		
	public PopularUserFlow(WebDriver driver) {
			super(driver);
	}
	
	public void  flowAlong()
	{
		listenLive.click();
		makeSureItIsPlaying();
		
		String winHandleBefore = driver.getWindowHandle();
		
		//Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	    //Signup 
		signUp();
	}
	
	
	public void comeToThisPage()
	{
		//DO NOTHING
	}
	
}
