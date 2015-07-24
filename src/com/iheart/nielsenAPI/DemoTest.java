package com.iheart.nielsenAPI;


import com.iheart.selenium.web_sanity.*;
import com.mba.proxylight.RequestProcessor;
import com.mba.proxylight.Response;

import static org.junit.Assert.*; 

import org.junit.Test; 
import org.junit.Ignore; 
import org.junit.Before; 
import org.junit.BeforeClass; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ArrayList;

public class DemoTest {

	 WebDriver driver;
	 static Proxy proxy; 
	 Response response;
		
	 
	 HomePage homePage;
		LiveRadioPage liveRadioPage;
		CustomRadioPage customRadioPage;
		PodcastsPage podcastsPage;
		PerfectForPage perfectForPage;
		ProfilePage profilePage;
		
	   
		
		//static String browser = "firefox";
	   static String browser = "chrome";
		
		static String userCity = "";
		
		 
		final String URL = "http://www.iheart.com";
		
		@Rule public TestName name = new TestName();
		
		//@BeforeClass
	   // public static void addProxy() {
			
			// proxy = new Proxy();
		//	proxy.initProxy(browser);
			
	//	}
		
		@Before
	    public void init() {
			
			//driver = Utils.launchBrowserWithProxy(URL, browser);
			
		
			 driver = Utils.launchBrowser(URL, browser);
			 Page.setDriver (driver);
			// System.out.println("see page:" + driver.getPageSource());
			 
		   //  response = proxy.fetch();
		    
	       
	      
	        homePage = PageFactory.initElements(driver, HomePage.class);
	        liveRadioPage = PageFactory.initElements(driver, LiveRadioPage.class);
	        customRadioPage = PageFactory.initElements(driver, CustomRadioPage.class);
	       
	       
	        Page.getErrors().delete(0, Page.getErrors().length());
	    }
		
		@Test
		 public void testNielsenTracking() throws Exception
		 {  
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		
		 	//	liveRadioPage.playStationAfterLogin();
		 		WaitUtility.sleep(2*60*1000);
		 		/*
		 		List<String> urls = RequestProcessor.getNielsenRequests();
		 	    for (String url: urls)
		 			System.out.println(url);
		 	*/	
		 		//customRadioPage.playCustom();
		 	  // WaitUtility.sleep(2*60*1000);
		 	//	 proxy.proxy.stop();
		 		 
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
	    
	    //to handle firefox v37.0 specific issue on windows 7
	    public void closeBrowserSession() throws Exception 
		  { 
		    	
			 Runtime.getRuntime().exec("taskkill /F /IM firefox.exe"); 
		  }
}
