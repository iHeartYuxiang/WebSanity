package com.iheart.junit.web_sanity;


import com.iheart.selenium.web_sanity.*;

import static org.junit.Assert.*; 

import org.junit.Test; 
import org.junit.Ignore; 
import org.junit.Before; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class DemoTest {

	 WebDriver driver;
		
		HomePage homePage;
		LiveRadioPage liveRadioPage;
		CustomRadioPage customRadioPage;
		PodcastsPage podcastsPage;
		PerfectForPage perfectForPage;
		ProfilePage profilePage;
		
	
		
		String browser = "firefox";
		//String browser = "chrome";
		
		static String userCity = "";
		
		 
		final String URL = "http://www.iheart.com";
		
		@Rule public TestName name = new TestName();
		
		
		@Before
	    public void init() {
	        driver = Utils.launchBrowser(URL, browser);
	        Page.setDriver (driver);
	        homePage = PageFactory.initElements(driver, HomePage.class);
	        liveRadioPage = PageFactory.initElements(driver, LiveRadioPage.class);
	        customRadioPage = PageFactory.initElements(driver, CustomRadioPage.class);
	        podcastsPage = PageFactory.initElements(driver, PodcastsPage.class);
	        perfectForPage = PageFactory.initElements(driver, PerfectForPage.class);
	        profilePage = PageFactory.initElements(driver, ProfilePage.class);
	       
	        Page.getErrors().delete(0, Page.getErrors().length());
	    }

		
	  
		@Test
	     public void testWEB_11754_thumpDownLiveRadio() throws Exception
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
	     public void testWEB_11776_thumbUpPodcasts() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	             podcastsPage.WEB_11776_thumbUp();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }      
	         System.out.println(name.getMethodName() + " is Done.");
	     }
		 
		 /*
		  
		  @Test
	        public void testWEB_11740_search() throws Exception
	        {
	            System.out.println("test method:" +  name.getMethodName() );
	            try{
	                   homePage.WEB_11740_search();
	            }catch(Exception e)
	             {
	                 handleException(e);
	             }        
	            System.out.println(name.getMethodName() + " is Done.");
	        }
	        
	        
	         @Test
	        public void testWEB_18302_PopularUserFlow() 
	        {
	            System.out.println("test method:" +  name.getMethodName() );
	            driver.get("http://www.z100.com");
	            homePage.flowAlong();
	            System.out.println(name.getMethodName() + " is Done.");
	        }
		 */
		  
		 
		
		
		
	    @After
	    public void tearDown() throws Exception{
	    	driver.quit(); 
	    	if (Page.getErrors().length() > 0)
				 fail(Page.getErrors().toString());
	    	
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
	    
	    //to handle firefox v37.0 specific issue on windows 7
	    public void closeBrowserSession() throws Exception 
		  { 
		    	
			 Runtime.getRuntime().exec("taskkill /F /IM firefox.exe"); 
		  }
}
