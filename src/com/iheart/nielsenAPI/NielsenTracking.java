package com.iheart.nielsenAPI;


import com.iheart.selenium.web_sanity.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.mba.proxylight.RequestProcessor;

public class NielsenTracking extends LiveRadioPage{

	
	 CustomRadioPage customRadioPage;
	
	
		public void playFor3Minutes()
	    {   
	    	comeToThisPage_direct();
	    	
	    	WaitUtility.sleep(1000);
	    	driver.findElement(By.cssSelector(".icon-play")).click();
	    	//driver.findElement(By.xpath("//*[@id='player']/div[2]/div/button[3]/i")).click();
	    	//play for 3 minutes and 20 seconds
	    	WaitUtility.sleep(3*60*1000 + 2 * 1000);
	    	
	    	if (!is_IVD_ok())
	    		errors.append("I, P, D ping doesn't work properly.");
	    	
			
			
	    }
		
		public void playPausePlay()
	    {   
	    	comeToThisPage_direct();
	    	
	    	WaitUtility.sleep(1000);
	    	//play for 2 minutes and 2 seconds
	    	driver.findElement(By.cssSelector(".icon-play")).click();
	    	WaitUtility.sleep(2*60*1000 + 1 * 1000);
	    	if (!is_IVD_ok())
	    		errors.append("I, P, D ping doesn't work properly.");
	    	
	    	clearNielsenRequest();
	    	//stop, then pause for 2 minutes
	    	driver.findElement(By.cssSelector(".icon-stop")).click();
	    	WaitUtility.sleep(2*60*1000 + 1 * 1000);
	        int newCount = getNielsenRequest().size();
	        if (newCount > 0  )
	        	errors.append("No ping shall be sent out after audio is paused.");
	       
	    	
	    	//play again for 2 minutes and 2 seconds
	    	driver.findElement(By.cssSelector(".icon-play")).click();
	    	WaitUtility.sleep(2*60*1000 + 1 * 1000);
	    	
	    	if (!is_IVD_ok())
	    		errors.append("I, P, D ping doesn't work properly after stream is restarted.");
	    	
			
	    }
		
		
		//opt-out, opt-in
		public void privacyPolicy()
		{  
			//To be done: OPT OUT
			driver.findElement(By.cssSelector("div.copyright:nth-child(3) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();
			//switch window
			switchWindow();
			
			driver.findElement(By.cssSelector(".detailContent > p:nth-child(58) > a:nth-child(1)")).click();
			switchWindow();
			WaitUtility.sleep(20*1000);//extremely slow to check the status
			try {
			   driver.findElement(By.id("selectAllACTIVE")).click();
			
			   driver.findElement(By.cssSelector("#ooSubmitACTIVE > input:nth-child(2)")).click();
			   WaitUtility.sleep(10000);  //SLOW
			}catch(Exception e)
			{
				System.out.println("Opted out already.");
			}
	        
			 clearNielsenRequest();
			//Then play a little
			driver.get("http://www.iheart.com/live/country/US/city/new-york-ny-159/");
	    	
	    	WaitUtility.sleep(1000);
	    	
	    	//play for 2 minutes and 2 seconds
	    	driver.findElement(By.cssSelector(".icon-play")).click();
	    	WaitUtility.sleep(1*60*1000 + 1 * 1000);
	        
	    	System.out.println("See nielsen request count:" + getNielsenRequest().size());
	    	
	    	if (is_IVD_ok())
	    		errors.append("No ping shall be sent over to nielsen after user opt out.");
			
		}
		
		public void switchStation()
		{
			comeToThisPage_direct();
	    	
	    	WaitUtility.sleep(1000);
	    	//play for 2 minutes , then kill the browser
	    	driver.findElement(By.cssSelector(".icon-play")).click();
	    	WaitUtility.sleep(2*60*1000 + 1 * 1000);
		    clearNielsenRequest();
			//change station
	    	driver.findElement(By.cssSelector("button.text:nth-child(4)")).click();
	    	WaitUtility.sleep(2*60*1000 + 1 * 1000);
	    	
	    	if (!is_IVD_ok())
	    		errors.append("I, P, D ping doesn't work properly after stream is restarted.");
	    	
		}
		
		public void browserExit()
		{
			comeToThisPage_direct();
	    	
	    	WaitUtility.sleep(1000);
	    	//play for 2 minutes , then kill the browser
	    	driver.findElement(By.cssSelector(".icon-play")).click();
	    	WaitUtility.sleep(2*60*1000 + 1 * 1000);
	    	
	    	//Verify result: I V D pings + D ping with cr = _11
	    	
	    	if (!is_IVD_ok())
	    		errors.append("I, P, D ping doesn't work properly.");
	    	
	    	clearNielsenRequest();
	    	
	    	driver.quit();
	    	
	    	List<String> urls = RequestProcessor.getNielsenRequests();
	    	
	    	boolean isPendingOK = false;
	    	
			for (String url: urls)
			{	System.out.println(url);
		         if (isPendingPing(url))
		        	isPendingOK = isPendingPingOK(url);
			}
	    	
		    if (! isPendingOK )
		    	errors.append("No pending ping is sent over.");
		}
		
		public void stationNotMeasured()
		{
			//Play a customer station
			 customRadioPage = PageFactory.initElements(driver, CustomRadioPage.class);
			 customRadioPage.playCustom();
			 WaitUtility.sleep(5000);
			
			 List<String> urls = RequestProcessor.getNielsenRequests();
				for (String url: urls)
				{	System.out.println(url);
				    if (isImpressionPingOK(url) )
				    {
				    	errors.append("Customer station shall not be measured.");
				    	break;
				    }
				}
		}
		
		
		
		public List<String> getNielsenRequest()
		{
			List<String> urls = RequestProcessor.getNielsenRequests();
				for (String url: urls)
				{	System.out.println(url);
			         
				}
			
			return urls;
		}	
		
		public void  clearNielsenRequest()
		{
			 RequestProcessor.clearNielsenRequests();
		}	

		// I, V, D 
		public boolean is_IVD_ok()
		{
			boolean isImpressionOK = false;
	    	boolean isViewOK = false;
	    	boolean isDurationOK = false;
	    	
	    	List<String> urls = RequestProcessor.getNielsenRequests();
			for (String url: urls)
			{	//System.out.println(url);
		        if (isImpressionPing(url)) 
		        {	System.out.println("IMpression ping: " + url);
		        	isImpressionOK = isImpressionPingOK(url);
		        }else if (isViewPing(url))
		        {	isViewOK = isViewPingOK(url);
		        	System.out.println("View ping: " + url);
		        }
		        else if (isDurationPing(url))
		        {	
		        	isDurationOK = isDurationPingOK(url);
		        	System.out.println("Duration ping: " + url);
		        }
			}
	    	
			System.out.println("IVD:" + isImpressionOK + "/" + isViewOK + "/" + isDurationOK);
			
		    return (isImpressionOK && isViewOK && isDurationOK);
		    	
		}
		
		
	
		/*
		 * at=start
		 * ci=..
		 * c18, c19, c20
		 */
		
		public boolean isImpressionPingOK(String request)
		{   boolean isOK = false;
		
		    try {
		    	isOK =  (request.substring(request.indexOf("cr="))).contains("_I") 
			    		&&   isC18_19_20_OK(request);
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
		    
		    System.out.println("isImpressionPingOK:" + isOK);
		    return  isOK;
		   
		}
		
		public boolean isImpressionPing(String url)
		{
			return url.contains("at=start");
		}
		
		public boolean isViewPing(String url)
		{
			return url.contains("at=view");
		}
		
		public boolean isDurationPing(String url)
		{
			return url.contains("at=timer");
		}
		
		public boolean isPendingPing(String url)
		{
			return url.contains("at=timer") && url.contains("_11");
		}
		
		public boolean isViewPingOK(String request)
		{
		    return  (request.substring(request.indexOf("cr="))).contains("_V")
		    		&& request.contains("at=view")
		    		&&  isC18_19_20_OK(request);
		   
		}
		
		public boolean isDurationPingOK(String request)
		{
			return   request.contains("at=timer")
					&&(request.substring(request.indexOf("cr="))).contains("_D") 
					//&&(request.contains("11111"))
		    		&&   isC18_19_20_OK(request);
					
		}
		
		
		public boolean isQuaterlyPingOK(String request)
		{
			return   request.contains("at=timer")
					&&(request.substring(request.indexOf("cr="))).contains("_Q") 
					&&(request.contains("11111"))
		    		&&  isC18_19_20_OK(request);
					
		}
		
	
		public boolean isPendingPingOK(String request)
		{
			return   request.contains("at=timer")
					&&(request.substring(request.indexOf("cr="))).contains("_11") 
					&&(request.contains("11111"))
		    		&&  isC18_19_20_OK(request);
					
		}
		
		
		public boolean isHelloPingOK(String request)
		{
		   return  request.startsWith("https")
				   && request.contains("cfg?")
				   && request.contains("apid");
			
		}
		
		public boolean isGoodbyePingOK(String request)
		{
			 return  request.startsWith("https")
					   && request.contains("cfg?")
					   && request.contains("uoo=true");
		}
		
		private boolean isC18_19_20_OK(String request)
		{  String c18 = request.substring(request.indexOf("c18="));
			String c19 = request.substring(request.indexOf("c19="));
			String c20 = request.substring(request.indexOf("c20="));
			System.out.println("c18:" + c18);
			System.out.println("c19:" + c19);
			System.out.println("c20:" + c20);
			
			boolean isOK = (request.substring(request.indexOf("c18="))).contains("clb")
		    		&& (request.substring(request.indexOf("c19="))).contains("stntyp,2")
		    		&& (request.substring(request.indexOf("c20="))).contains("prvd,Clear");
			
			System.out.println("isC18_19_20_OK:" + isOK);
			
			return isOK;  
		}
		
	
}
