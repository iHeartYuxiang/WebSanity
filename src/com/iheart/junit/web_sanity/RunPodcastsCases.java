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


public class RunPodcastsCases {
	
	WebDriver driver;
	PopularUserFlow popPage;
	PodcastsPage podcastsPage;
	//String browser = "firefox";
	String browser = "chrome";

	 final String URL = "http://www.iheart.com";
	
	
	@Rule public TestName name = new TestName();
	
	
		
	@Before
	 public void init() {
	     driver = Utils.launchBrowser(URL, browser);
	     Page.setDriver (driver);
	     podcastsPage = PageFactory.initElements(driver, PodcastsPage.class);
	     
	     Page.getErrors().delete(0,  Page.getErrors().length());
	     
	     
	 }
	
	 
	 @Test
	 public void testWEB_11772_browsePodcasts() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	    	podcastsPage.WEB_11772_browsePodcasts();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  	
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11773_playPodAfterLogin() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 	   podcastsPage.WEB_11773_playPodAfterLogin();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}     
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11774_filterPodAfterLogin() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		podcastsPage.WEB_11774_filterPodAfterLogin();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  	
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11775_addShowToFavorite() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		podcastsPage.WEB_11775_addShowToFavorite();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  	
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11776_thumpUp() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		podcastsPage.WEB_11776_thumbUp();
	 	}catch(Exception e)
	 	{   e.printStackTrace();
	 	    
	 		
	 	}  	
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11777_skipLimitless() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		podcastsPage.WEB_11777_skipLimitless();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  	
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
		
	 @Test
	 public void testWEB_11778_pauseResume() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		podcastsPage.WEB_11778_pauseResume();
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
	   //  driver.quit();
	     
	    
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
		//  Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe"); 
		//  Runtime.getRuntime().exec("taskkill /F /IM firefox.exe"); 
	  }
	
		

}
