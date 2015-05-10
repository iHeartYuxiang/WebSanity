package com.iheart.junit.web_sanity;


import com.iheart.selenium.web_sanity.*;

import static org.junit.Assert.*; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RunCustomRadioCases {

	
	WebDriver driver;
	PopularUserFlow popPage;
	CustomRadioPage customRadioPage;
	String browser = "firefox";
	//String browser = "chrome";
	
	
	
	 final String URL = "http://www.iheart.com";
	
	@Rule public TestName name = new TestName();
	
	
		
	@Before
	 public void init() {
	     driver = Utils.launchBrowser(URL,browser);
	     Page.setDriver (driver);
	     customRadioPage = PageFactory.initElements(driver, CustomRadioPage.class);
	     Page.getErrors().delete(0,  Page.getErrors().length());
	 }
	
	
	 @Test
	 public void testWEB_11758_browseCustomBeforeLogin() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	   customRadioPage.WEB_11758_browseCustomBeforeLogin();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 
	 @Test
	 public void testWEB_11761_filterAndPlayCustomAfterLogin() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	   customRadioPage.WEB_11761_filterAndPlayCustomAfterLogin();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11762_skipLimit() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	   customRadioPage.WEB_11762_skipLimit();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11760_playCustom() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	    customRadioPage.WEB_11760_playCustom();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 

	 @Test
	 public void testWEB_11764_addCustomStationToFavorite() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	    customRadioPage.WEB_11764_addCustomStationToFavorite();
	    }catch(Exception e)
	 	{
	 		handleException(e);
	 	}  
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11765_CustomStationPlayStop() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	   customRadioPage.WEB_11765_CustomStationPlayStop();
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
		  Runtime.getRuntime().exec("taskkill /F /IM chrome.exe"); 
		  Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe"); 
		  Runtime.getRuntime().exec("taskkill /F /IM firefox.exe"); 
	  }
		
}
