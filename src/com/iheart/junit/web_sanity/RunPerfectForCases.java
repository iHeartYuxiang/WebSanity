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

public class RunPerfectForCases {
	WebDriver driver;
	PopularUserFlow popPage;
	PerfectForPage perfectForPage;
	//String browser = "firefox";
	String browser = "chrome";
	
	 final String URL = "http://www.iheart.com";
	 
	@Rule public TestName name = new TestName();
	
		
	@Before
	 public void init() {
	     driver = Utils.launchBrowser(URL,browser);
	     Page.setDriver (driver);
	     perfectForPage = PageFactory.initElements(driver, PerfectForPage.class);
	     
	     Page.getErrors().delete(0,  Page.getErrors().length());
	     
	 }
	
	 
	 @Test
	 public void testWEB_11766_browsePerfect() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	    perfectForPage.WEB_11766_browsePerfect();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 
	 @Test
	 public void testWEB_11769_skipLimit() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	   perfectForPage.WEB_11769_skipLimit();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}   
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11768_addToFavorite() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	    perfectForPage.WEB_11768_addToFavorite();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 
	 @Test
	 public void testWEB_11770_thumpUpPerfect() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	   perfectForPage.WEB_11770_thumpUpPerfect();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 
	 @Test
	 public void testWEB_11771_pauseResume() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	    	perfectForPage.WEB_11771_pauseResume();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}	
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 
	 @Test
	 public void testWEB_11767_filterAfterLogin() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	   perfectForPage.WEB_11767_filterAfterLogin();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}   
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 
	 @After
	 public void tearDown() throws Exception {
		 if ( Page.getErrors().length() > 0)
			 fail( Page.getErrors().toString());
	     driver.quit();
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
