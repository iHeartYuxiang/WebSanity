package com.iheart.nielsenAPI;


import com.iheart.selenium.web_sanity.*;
import com.mba.proxylight.RequestProcessor;
import com.mba.proxylight.Response;

import static org.junit.Assert.*; 

import org.junit.Test; 
import org.junit.Ignore; 
import org.junit.BeforeClass;  
import org.junit.Before; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class RunNielsenTests {

	 WebDriver driver;
	 static Proxy proxy; 
	 Response response;
		
	 
	 HomePage homePage;
	 NielsenTracking liveRadioPage;
	 CustomRadioPage customRadioPage;
		
	static String browser = "firefox";
   //static String browser = "chrome";
	
	 
	final String URL = "http://www.iheart.com";
	//final String URL = "http://stage.iheart.com";
	
	@Rule public TestName name = new TestName();
	
	
	@Before
    public void init() {
		
		 proxy = new Proxy();
		 proxy.initProxy(browser);
		 
		driver = Utils.launchBrowserWithProxy(URL, browser);
	
		 Page.setDriver (driver);
	  //   response = proxy.fetch();
      
        homePage = PageFactory.initElements(driver, HomePage.class);
        liveRadioPage = PageFactory.initElements(driver, NielsenTracking.class);
        customRadioPage = PageFactory.initElements(driver, CustomRadioPage.class);
       
        Page.getErrors().delete(0, Page.getErrors().length());
        RequestProcessor.clearNielsenRequests();
    }
	
	@Test
	 public void testPlay5Minutes() throws Exception
	 {  
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		
	 	    liveRadioPage.playFor5Minutes();
	 		
	 		
	 	     proxy.proxy.stop();
	 		 
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	 
	
	
	
	@Test
	 public void testPlayPausePlay() throws Exception
	 {  
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		 liveRadioPage.playPausePlay();
	 	     proxy.proxy.stop();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }

	@Test
	 public void testSwitchStation() throws Exception
	 {  
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		 liveRadioPage.switchStation();
	 	     proxy.proxy.stop();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }

	
	
	@Test
	 public void testStationNotMeasured() throws Exception
	 {  
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		 liveRadioPage.stationNotMeasured();
	 	     proxy.proxy.stop();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }

	@Test
	 public void testPrivacyPolicy() throws Exception
	 {  
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		 liveRadioPage.privacyPolicy();
	 	     proxy.proxy.stop();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
	
    @After
    public void tearDown() throws Exception{
        //driver.quit(); 
       
    	if (Page.getErrors().length() > 0)
			 fail(Page.getErrors().toString());
    	
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
    
   
}

