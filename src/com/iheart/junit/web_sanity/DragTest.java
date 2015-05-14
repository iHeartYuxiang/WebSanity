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


public class DragTest {

	 WebDriver driver;
		
	 RadioEditPage radioEditPage;
		
		
		String browser = "firefox";
		
		static String userCity = "";
		
		 
		final String URL = "http://radioedit.ihrdev.com/service/app/shell/";
		//final String URL = "http://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop";
		
		@Rule public TestName name = new TestName();
		
		
		@Before
	    public void init() {
	        driver = Utils.launchBrowser(URL, browser);
	        Page.setDriver (driver);
	        radioEditPage = PageFactory.initElements(driver, RadioEditPage.class);
	        Page.getErrors().delete(0, Page.getErrors().length());
	    }

		
		
		  
		   @Test
		 public void testDragAndDrop() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		radioEditPage.dragDrop();
		    }catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		   
		 
	    @After
	    public void tearDown() {
	    	
	    	if (Page.getErrors().length() > 0)
				 fail(Page.getErrors().toString());
	    	//driver.quit(); 
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
