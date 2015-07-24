package com.iheart.selenium.web_sanity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;


public class WaitUtility {
	
	private static final String JQUERY_LOAD_SCRIPT = "sources/jQuerify.js";
	private static final String HIJACK_AJAX_SCRIPT = "sources/injectScriptForAjaxCalls.js";


	public static void sleep(long milliSecond)
	{
		try{
			Thread.sleep(milliSecond);
		}catch(Exception e)
		{
			
		}
	}
	
	
	public static void waitForPageToLoad(WebDriver driver) {

	     ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	          return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	      };

	     Wait<WebDriver> wait = new WebDriverWait(driver,1000);
	      try {
	              wait.until(expectation);
	      } catch(Throwable error) {
	              System.out.println("Timeout waiting for Page Load Request to complete.");
	      }
	 } 
	
	public static void waitForAjax(WebDriver driver)
	{   try{ 
		    injectJQuery(driver);
		}catch(Exception e)
		{
			
		}
		//Check: how many on-going ajax call on this page?
		long ajaxCallCount = (Long)((JavascriptExecutor)driver ).executeScript("return jQuery.active");
	//	System.out.println("Ajax call count:" + ajaxCallCount);
	    while (true) // Handle timeout somewhere
	    {
	        boolean ajaxIsComplete =(Boolean) ((JavascriptExecutor)driver ).executeScript("return jQuery.active == 0");
	        if (ajaxIsComplete)
	            break;
	        sleep(1000);
	    }
	   
	    ajaxCallCount = (Long)((JavascriptExecutor)driver ).executeScript("return jQuery.active");
		System.out.println("Active Ajax call count after waiting:" + ajaxCallCount);
	}

	
	/** dynamically load jQuery */
	//Rename it when I am testing the proxy
	public static void injectJQuery_original(WebDriver driver){
	    String LoadJQuery = "(function(jqueryUrl, callback) {\n" +
	            "if (typeof jqueryUrl != 'string') {" +
	            "jqueryUrl = 'https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js';\n" +
	            "}\n" +
	            "if (typeof jQuery == 'undefined') {\n" +
	            "var script = document.createElement('script');\n" +
	            "var head = document.getElementsByTagName('head')[0];\n" +
	            "var done = false;\n" +
	            "script.onload = script.onreadystatechange = (function() {\n" +
	            "if (!done && (!this.readyState || this.readyState == 'loaded'\n" +
	            "|| this.readyState == 'complete')) {\n" +
	            "done = true;\n" +
	            "script.onload = script.onreadystatechange = null;\n" +
	            "head.removeChild(script);\n" +
	            "callback();\n" +
	            "}\n" +
	            "});\n" +
	            "script.src = jqueryUrl;\n" +
	            "head.appendChild(script);\n" +
	            "}\n" +
	            "else {\n" +
	            "callback();\n" +
	            "}\n" +
	            "})(arguments[0], arguments[arguments.length - 1]);\n";
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	   // give jQuery time to load asynchronously
	   driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	   js.executeAsyncScript(LoadJQuery);
	    System.out.println("Jquery is loaded.");
	}	
	
	
	// driver
    public static void injectJQuery(WebDriver driver) throws Exception
    {
       
        String jQueryLoader = readFile(JQUERY_LOAD_SCRIPT) ;
        System.out.println("jQueryLoader:" + jQueryLoader);
        // give jQuery time to load asynchronously
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript(jQueryLoader );
        /*
        String ajaxURL = "";
        try {
           ajaxURL = (String)js.executeAsyncScript("(function(open, callback) {" +
        		   		" var ajaxURL;" +
        		   		"XMLHttpRequest.prototype.open = function(method, url, async, user, pass) {" +
        		   		" ajaxURL =  url;" +
        		   		" open.call(this, method, url, async, user, pass);" +
        		   		" retun ajaxURL;" + 
        				"};" +
        				"callback();"+
        		"})(XMLHttpRequest.prototype.open,arguments[arguments.length - 1]);" 
           		 );  
           System.out.println("ajaxURL =" + ajaxURL);
        }catch(Exception e)
        {
        	e.printStackTrace();
        	System.out.println("Exception executing script.");
        }
        */
        
        
        // ready to rock
        
      /*
        Object phref = 
        js.executeScript(
        //    "(function($) { " +
             
            //  " alert('see href:' +  $('a[title=\"Privacy Policy\"]').attr('href')); " + 
           " var href = $('a[title=\"Privacy Policy\"]').attr('href'); " +
            // "  console.log('see href:' +  $('a[title=\"Privacy Policy\"]').attr('href')); " + 
            "  console.log('see href:' +  href); " + 
             " $('a[title=\"Privacy Policy\"]').click(); " +
             "  console.log('about to return:' +  href); " + 
             " return href; " 
        //     " }) "
           // " })(jQuery); "
        );
        */
        
        Long ajaxCalls = (Long)
                js.executeScript(
                //	"(function(open, callback) {"+	
                	" var ajaxCall;" +	
                	" var ajaxCalls = []; " +
                    " var count =0;" +
                	"	XMLHttpRequest.prototype.open = function(method, url, async, user, pass) {" +
                    " count++; " +
                	" ajaxCalls.push(url);"+ 
                	"	    console.log('see ajax calls:' + url + '/' + count + '/' + ajaxCalls.length);"+
                	"    console.log('see ALL ajax calls:' + ajaxCalls.toString());"+
                	"	    open.call(this, method, url, async, user, pass);"+
                	
                	"}; " +
                	" return count;"
                	
               );
        
        WaitUtility.sleep(5000);
        
        if (ajaxCalls != null) System.out.println("See ajax:" + ajaxCalls);  
        else 
        	System.out.println("Ajax call is null.");  
        System.out.println("Jquery is loaded.");
}						
    

	
	
	/** dynamically load jQuery */
	public static void hijackAJAX(WebDriver driver){
	    String LoadScript = "(function(open) { \n" +
	    					"XMLHttpRequest.prototype.open = function(method, url, async, user, pass) { \n" +
	    					" console.log('Ajax call:''+ url );   \n" +
	    					" open.call(this, method, rewrittenUrl, async, user, pass);\n" + 
							"}; \n" + 
							"})(XMLHttpRequest.prototype.open);\n";
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	   // give jQuery time to load asynchronously
	   driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	   js.executeAsyncScript(LoadScript);
	    System.out.println("Script for hijacking ajax calls is loaded.");
	}	

	 // helper method
    public static String readFile(String file) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(file);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        }
        finally {
            stream.close();
        }        
    }
	

	
}
