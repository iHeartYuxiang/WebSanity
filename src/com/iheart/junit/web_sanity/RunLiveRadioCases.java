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

public class RunLiveRadioCases {

	WebDriver driver;
	PopularUserFlow popPage;
	LiveRadioPage liveRadioPage;
	//String browser = "firefox";
	
	String browser = "chrome";
	
	static String userCity = "";
	
	 final String URL = "http://www.iheart.com";
	
	@Rule public TestName name = new TestName();
	
	
		
	@Before
	 public void init() {
	     driver = Utils.launchBrowser(URL,browser);
	     Page.setDriver (driver);
	     liveRadioPage = PageFactory.initElements(driver, LiveRadioPage.class);
	     Page.getErrors().delete(0,  Page.getErrors().length());
	 }
	
	  
    @Test
    public void testWEB_14441_mutePlayer() throws Exception
    {
    	System.out.println("test method:" +  name.getMethodName() );
    	try
    	{
    	   liveRadioPage.WEB_14441_mutePlayer();
        }catch(Exception e)
    	{
    		handleException(e);
    	}
    	System.out.println(name.getMethodName() + " is Done.");
    }
	
    @Test
    public void testWEB_11744_filterStation() throws Exception
    {
    	System.out.println("test method:" +  name.getMethodName() );
    	try
    	{
    	   liveRadioPage.WEB_11744_filterStation();
    	}catch(Exception e)
    	{
    		handleException(e);
    	}
    	System.out.println(name.getMethodName() + " is Done.");
    }
    
   @Test
    public void testWEB_11745_International() throws Exception
    {   
    	System.out.println("test method:" +  name.getMethodName() );
    	try
    	{
    	   liveRadioPage.WEB_11745_International();
    	}catch(Exception e)
    	{
    		handleException(e);
    	}
    	System.out.println(name.getMethodName() + " is Done.");
    }
	
	 @Test
	    public void testWEB_11796_LiveStationAutoPlay() throws Exception
	    {   
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try {
	    	   liveRadioPage.WEB_11796_LiveStationAutoPlay();
	    	}catch(Exception e)
	    	{
	    		handleException(e);
	    	}
	    	System.out.println(name.getMethodName() + " is Done.");
	    }
	    
	    @Test
	    public void testWEB_11746_PlayStopScan() throws Exception
	    {   
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try
	    	{
	    	   liveRadioPage.WEB_11746_PlayStopScan();
	    	}catch(Exception e)
	    	{
	    		handleException(e);
	    	}
	    	System.out.println(name.getMethodName() + " is Done.");
	    }
	    
	    
	   
		
	
	@Test
	 public void testWEB_11752_thumpUp() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try
    	{
	 	   liveRadioPage.WEB_11752_thumpUp();
    	}catch(Exception e)
    	{
    		handleException(e);
    	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
		
	 @Test
	 public void testWEB_11751_INT() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try
    	{   
	 	    liveRadioPage.WEB_11751_INT();
    	}catch(Exception e)
    	{
    		handleException(e);
    	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11755_favorite() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try
    	{
	 	   liveRadioPage.WEB_11755_favorite();
    	}catch(Exception e)
    	{
    		handleException(e);
    	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 @Test
	 public void testWEB_11754_thumpDown() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try
    	{
	 	    liveRadioPage.WEB_11754_thumpDown();
    	}catch(Exception e)
    	{
    		handleException(e);
    	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	 
	 @Test
	 public void testWEB_11747_adjustVolume() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try
    	{
	 		liveRadioPage.WEB_11747_adjustVolume();
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
		 // Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe"); 
		  //Runtime.getRuntime().exec("taskkill /F /IM firefox.exe"); 
	  }
}
