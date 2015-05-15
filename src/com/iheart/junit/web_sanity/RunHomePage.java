package com.iheart.junit.web_sanity;

import com.iheart.selenium.web_sanity.*;

import static org.junit.Assert.*; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RunHomePage {

	 WebDriver driver;
		//PopularUserFlow popPage;
		HomePage homePage;
		String browser = "chrome";
		
		static String userCity = "";
		
		 final String URL = "http://www.iheart.com";
		
		@Rule public TestName name = new TestName();
		
		
		@Before
	    public void init() {
	        driver = Utils.launchBrowser(URL,browser);
	        Page.setDriver (driver);
	        homePage = PageFactory.initElements(driver, HomePage.class);
	        
	        Page.getErrors().delete(0, Page.getErrors().length());
	    }

	    
	    @Test
	    public void testWEB_11734_startUp() throws Exception
	    {
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
	    	   homePage.WEB_11734_startUp();
	     	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}    
	    	System.out.println(name.getMethodName() + " is Done.");
	    	
	    }
	    
	    @Test
	    public void testWEB_11759_Hero() throws Exception
	    {
	       
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
		    	   homePage.WEB_11759_Hero();
	    	}catch(Exception e)
		 	{
		 		handleException(e);
		 	} 	   
	    	System.out.println(name.getMethodName() + " is Done.");
	    	
	    }
	    
	    @Test
	    public void testWEB_11790_Hero() throws Exception
	    {
	       
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
		    	   homePage.WEB_11790_Hero();
	    	}catch(Exception e)
		 	{
		 		handleException(e);
		 	} 	   
	    	System.out.println(name.getMethodName() + " is Done.");
	    	
	    }
	    
	    
	    @Test
	    public void testWEB_11735_explorerMenu() throws Exception
	    {
	       
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
		    	   homePage.WEB_11735_explorerMenu();
	    	}catch(Exception e)
		 	{
		 		handleException(e);
		 	} 
	    	System.out.println(name.getMethodName() + " is Done.");
	    	
	    }
	    
	    
	    @Test
	    public void testWEB_11784_signUp() throws Exception
	    {
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
		    	   homePage.WEB_11784_signUp();
	    	}catch(Exception e)
		 	{
		 		handleException(e);
		 	} 
		     System.out.println(name.getMethodName() + " is Done.");
	    	
	    }
	    
	    
	    @Test
	    public void testFaceBookSignUp() throws Exception
	    {
	       
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
		    	   homePage.WEB_8823_faceBooksignUp();
	    	}catch(Exception e)
		 	{
		 		handleException(e);
		 	} 
	    	System.out.println(name.getMethodName() + " is Done.");
	    	
	    }
	    
	    
	    @Test
	    public void testWEB_11737_loginWithEmail() throws Exception
	    {
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
		    	   homePage.WEB_11737_loginWithEmail();
	    	}catch(Exception e)
		 	{
		 		handleException(e);
		 	} 	   
	    	System.out.println(name.getMethodName() + " is Done.");
	    	
	    }
	    
	    
	    @Test
	    public void testWEB_11739_loginWithGoog() throws Exception
	    {
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
		    	   homePage.WEB_11739_loginWithGoog();
	    	}catch(Exception e)
		 	{
		 		handleException(e);
		 	} 	   
	    	System.out.println(name.getMethodName() + " is Done.");
	    }
	    
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
	    public void testWEB_11742_searchWihoutLogin() throws Exception
	    {
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
		    	   homePage.WEB_11742_searchWihoutLogin();
	    	}catch(Exception e)
		 	{
		 		handleException(e);
		 	} 	   
	    	System.out.println(name.getMethodName() + " is Done.");
	    }
	    
	    
	    @Test
	    public void testWEB_11902_GeographySearch() throws Exception
	    {   //first, find out where user is based on its IP address:
	    	
 	    driver.get("http://www.iplocation.net");
	        WaitUtility.sleep(1000);
	        String city = driver.findElement(By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(4)")).getText();
	    
	        if (city.contains(" City"))
			   userCity = city.substring(0, city.length()-4).trim();
			System.out.println("See user's city after TRIM:" + userCity);
			
			//Now go back to iheart page
		    driver.get(URL);
		    Page.setDriver (driver);
	        homePage = PageFactory.initElements(driver, HomePage.class);
	    	
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
		    	   homePage.WEB_11902_GeographySearch(userCity);
	    	}catch(Exception e)
		 	{
		 		handleException(e);
		 	} 	   
	    	System.out.println(name.getMethodName() + " is Done.");
	    }
	    
	    
	   
	    
	    @After
	    public void tearDown() throws Exception {
	    	 if (Page.getErrors().length() > 0)
				 fail(Page.getErrors().toString());
	    	 
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
