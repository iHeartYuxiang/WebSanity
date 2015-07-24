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

public class sanityTest {

	
	    WebDriver driver;
		
		HomePage homePage;
		LiveRadioPage liveRadioPage;
		CustomRadioPage customRadioPage;
		PodcastsPage podcastsPage;
		PerfectForPage perfectForPage;
		ProfilePage profilePage;
		
		
		
	   // String browser = "firefox";
		//String browser = "chrome";
		String browser = "IE";
		   
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
		 public void testWEB_11749_playStationAfterLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		liveRadioPage.WEB_11749_playStationAfterLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		
		 @Test
		 public void testWEB_11743_playLiveWithoutLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		liveRadioPage.WEB_11743_playLiveWithoutLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		
		
		 @Test
		 public void testWEB_11757_liveShare() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		liveRadioPage.WEB_11757_liveShare();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_21226_playDefaultByLocation() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		homePage.WEB_21226_playDefaultByLocation();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		
		
		
		 @Test
		 public void testWEB_14440_playerUponFirstLaunch() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		homePage.WEB_14440_playerUponFirstLaunch();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_11736_signUp() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		homePage.WEB_11736_signUp();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 
		 @Test
		 public void testWEB_11738_FACEBOOKsignUp() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		homePage.WEB_11738_FACEBOOKsignUp();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_11741_searchAfterLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		homePage.WEB_11741_searchAfterLogin();
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
	    public void testWEB_8823_FaceBookSignUp() throws Exception
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
	    
	    //&&&&&&&&  LIVE RADIO &&&&&&&&
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
		 public void testWEB_11748_ThumbUpAndDownLiveWithoutLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		liveRadioPage.WEB_11748_ThumbUpAndDownLiveWithoutLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_11753_favStationAndListenHistoryOnPlayer() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		liveRadioPage.WEB_11753_favStationAndListenHistoryOnPlayer();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		
		 @Test
		 public void testWEB_11785_playStationFromGenreProfile() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		liveRadioPage.WEB_11785_playStationFromGenreProfile();
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
			 public void testWEB_11756_LivePlayStopScanAfterLogin() throws Exception
			 {   
			 	System.out.println("test method:" +  name.getMethodName() );
			 	try{
			 		liveRadioPage.WEB_11756_LivePlayStopScanAfterLogin();
			 	}catch(Exception e)
			 	{
			 		handleException(e);
			 	}  	
			 	System.out.println(name.getMethodName() + " is Done.");
			 }   
		   
			
		
		@Test
		 public void testWEB_11752_thumbUpLiveRadio() throws Exception
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
		 
		 
		 //********** custom radio **********
		 
		 @Test
		 public void testWEB_11758_browseCustomBeforeLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   customRadioPage.WEB_11758_browseCustomBeforeLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_11761_filterAndPlayCustomAfterLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   customRadioPage.WEB_11761_filterAndPlayCustomAfterLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11762_skipLimit() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   customRadioPage.WEB_11762_skipLimit();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11763_thumpUpCustom() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   customRadioPage.WEB_11763_thumpUpCustom();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11760_playCustom() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	    customRadioPage.WEB_11760_playCustom();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 

		 @Test
		 public void testWEB_11764_addCustomStationToFavorite() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	    customRadioPage.WEB_11764_addCustomStationToFavorite();
		    }catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11765_CustomStationPlayStop() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   customRadioPage.WEB_11765_CustomStationPlayStop();
		    }catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 //&&&&&&&&&& podcasts *********
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
		 
		 
		 //************* Perfect For ************
		 @Test
		 public void testWEB_11766_browsePerfect() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	    perfectForPage.WEB_11766_browsePerfect();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_11769_skipLimit() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   perfectForPage.WEB_11769_skipLimit();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}   
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11768_addToFavorite() throws Exception
		 {  
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	    perfectForPage.WEB_11768_addToFavorite();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_11770_thumbUpPerfect() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   perfectForPage.WEB_11770_thumpUpPerfect();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_11771_pauseResume() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		    	perfectForPage.WEB_11771_pauseResume();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_11767_filterAfterLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   perfectForPage.WEB_11767_filterAfterLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}   
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 //******** profile ********
		 @Test
		 public void testWEB_11779_playStations() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   profilePage.WEB_11779_playStations();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11780_playStationsInMyStationsPage() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		    	profilePage.WEB_11780_playStationsInMyStationsPage();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_11781_playStationsInListenHistoryPage() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		    	profilePage.WEB_11781_playStationsInListenHistoryPage();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11782_friendPage() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	    profilePage.WEB_11782_friendPage();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}    
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11783_logout() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		    	profilePage.WEB_11783_logout();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
	 
	    
	    @After
	    public void tearDown() throws Exception {
	    	driver.quit();
	    	 if (Page.getErrors().length() > 0)
				 fail(Page.getErrors().toString());
	    	 
	    //	closeBrowserSession();
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
	    	
		  //Runtime.getRuntime().exec("taskkill /F /IM chrome.exe"); 
		 // Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe"); 
		  Runtime.getRuntime().exec("taskkill /F /IM firefox.exe"); 
	  }
}
