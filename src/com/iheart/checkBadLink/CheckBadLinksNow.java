package com.iheart.checkBadLink;


import com.iheart.selenium.web_sanity.Utils;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;




@RunWith(Parameterized.class)

public class CheckBadLinksNow {

@Parameters
public static Collection<Object[]> data() {
	Collection<Object[]> params = new ArrayList<>(100);
	
	List<String> siteList = ExcelUtility.readSiteList();	
	for (String site: siteList)
		params.add(new Object[] { site});
	
	//params.add(new Object[] {  "http://www.iheart.com/live/country/US/?genreId=1"});
  //  params.add(new Object[] {  "http://www.iheart.com/live/country/US/?genreId=2"});
     
    return params;
}
protected static DesiredCapabilities dCaps;

	private final String url;
	
	WebDriver driver;
	
	
		
	String browser = "firefox";
   //String browser = "chrome";
	
	
	
	public CheckBadLinksNow(String url) {
		this.url = url;
	
	}
	
	@Rule public TestName name = new TestName();
	

	/* run headless
	@Before
	public void setUp() throws Exception {

		Page.setURL(url);
		
		
		//System.setProperty("phantomjs.binary.path", "C:\\Users\\1111128\\workspace\\lib\\phantomjs-2.0.0-windows\\bin\\phantomjs.exe");
		System.setProperty("phantomjs.binary.path", "/Users/1111128/git/lib/phantomjs-2.0.0-macosx/bin/phantomjs");
		
		
		dCaps = new DesiredCapabilities();
		dCaps.setJavascriptEnabled(true);
		dCaps.setCapability("takesScreenshot", true);
		
		driver = new PhantomJSDriver(dCaps);
		driver.get(url + "/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 Page.setDriver (driver);
	     homePage = PageFactory.initElements(driver, Z100HomePage.class);
	     articlePage = PageFactory.initElements(driver, ArticlePage.class);
	     header = PageFactory.initElements(driver, Header.class);
	        
	      Page.getErrors().delete(0, Page.getErrors().length());
	}
	
	*/
	
//headful run
	
	@Before
   public void init() {
       driver = Utils.launchBrowser(url, browser);
      	Page.setURL(url);
      
       Page.setDriver (driver);
       
       Page.getErrors().delete(0, Page.getErrors().length());
   }

	
	
	
	@Test
	 public void testBadLinks() throws Exception
	 {   
	 	System.out.println("test method:" +  name.getMethodName() );
	 	try{
	 		Page.goThroughLinks();
	 	}catch(Exception e)
	 	{
	 		handleException(e);
	 	}  	
	 	System.out.println(name.getMethodName() + " is Done.");
	 }
   
  
	 @After
	    public void tearDown() throws Exception{
	    	driver.quit(); 
	    	if (Page.getErrors().length() > 0)
				 fail(Page.getErrors().toString());
	    	
	    }
	
	    private void handleException(Exception e)
	    {   Page.getErrors().append("Exception is thrown.");
	        e.printStackTrace();
	        /*
	        try{
	    	   Page.takeScreenshot(driver, name.getMethodName());
            }catch(Exception eX)
            {
            	
            }
            */
	    }
	    
	   

}