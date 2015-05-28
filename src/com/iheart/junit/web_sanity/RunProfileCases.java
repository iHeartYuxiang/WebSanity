package com.iheart.junit.web_sanity;

import com.iheart.selenium.web_sanity.*;

import static org.junit.Assert.*; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.BeforeClass; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	
import org.openqa.selenium.support.PageFactory;

public class RunProfileCases {

	WebDriver driver;
	PopularUserFlow popPage;
	ProfilePage profilePage;
	//String browser = "firefox";
	String browser = "chrome";
	
	static String userCity = "";
	
	 final String URL = "http://www.iheart.com";
	 
	@Rule public TestName name = new TestName();
	
		
	@Before
	 public void init() {
	     driver = Utils.launchBrowser(URL,browser);
	     Page.setDriver (driver);
	     profilePage = PageFactory.initElements(driver, ProfilePage.class);
	     
	     Page.getErrors().delete(0, Page.getErrors().length());
	     
	 }
	
	 
	 @Test
	 public void testWEB_11779_playStations() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	   profilePage.WEB_11779_playStations();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11780_playStationsInMyStationsPage() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	    	profilePage.WEB_11780_playStationsInMyStationsPage();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  	
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 
	 @Test
	 public void testWEB_11781_playStationsInListenHistoryPage() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	    	profilePage.WEB_11781_playStationsInListenHistoryPage();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11782_friendPage() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	    profilePage.WEB_11782_friendPage();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}    
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11783_logout() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	    	profilePage.WEB_11783_logout();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  	
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 
	 @After
	 public void tearDown() throws Exception {
		 driver.quit();
		 if ( Page.getErrors().length() > 0)
			 fail( Page.getErrors().toString());
	    
	     closeBrowserSession();
	    
	 }
		
	 
	 private void handleException(Exception e)
	 {   Page.getErrors().append("Exception is thrown.");
	        e.printStackTrace();
       try{
    	   Page.takeScreenshot(driver, name.getMethodName());
       }catch(Exception eX)
       {
       	
       }
	 }
	 
	 public void closeBrowserSession() throws Exception 
	  { 
		//  Runtime.getRuntime().exec("taskkill /F /IM chrome.exe"); 
		//  Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe"); 
		  Runtime.getRuntime().exec("taskkill /F /IM firefox.exe"); 
	  }
	
		
}
