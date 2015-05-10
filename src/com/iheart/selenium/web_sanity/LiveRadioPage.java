package com.iheart.selenium.web_sanity;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*; 


public class LiveRadioPage extends Page {
	
	@FindBy(css="li.tile:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > button:nth-child(2)")
		private WebElement firstLive;
	@FindBy(css="li.tile:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1)")
        private WebElement firstLiveTextLink;
	
	//Volume
		@FindBy(css=".volume > button:nth-child(1)") public WebElement volumeButton;
		@FindBy(css="#player > div.player-center > div > div > button > i") public WebElement iconMute;
		
		//Filter station
		@FindBy(css="#main > div > div > div.form-group.ui-inline-block.country-filter > div > select") public WebElement country;
		@FindBy(css="#main > div > div > div.form-group.ui-inline-block.market-filter > div > select") public WebElement city;
		@FindBy(css="#main > div > div > div.form-group.ui-inline-block.genre-filter > div > select") public WebElement genres;
		@FindBy(css="#main > div > section > ul > li:nth-child(1) > div > div.station-thumb-wrapper.ui-on-dark > a > div.hover > button > i") public WebElement firstStation;
		@FindBy(css="#main > div > section > ul > li:nth-child(1) > div > div.station-text > a") public WebElement firstStationLabel;
		@FindBy(css=".player-station") public WebElement stationPlaying;
		
		//h3 title
		@FindBy(css=".section-header") public WebElement h3_header;
		
		//International
		@FindBy(css="#main > div > section > ul > li:nth-child(1) > div > div.station-thumb-wrapper.ui-on-dark > a > div.hover > button > i") public WebElement firstINT;
		@FindBy(css="#hero > div.hero-content > div > div.profile-info > div > button > i") public WebElement firstINT_playButton;
		@FindBy(css="#player > div.player-center > div > button.playing.btn-circle.medium.play > i") public WebElement firstINT_stopPlayButton;
		
		//autoPlay
		@FindBy(css="#main > div > section > ul > li:nth-child(1) > div > div.station-text > a") public WebElement liveRadio_firstLink;
		@FindBy(css="#hero > div.hero-content > div > div.profile-info > div > button > i") public WebElement player_stopButton;
		
		//Play/stop/resume/scan
		//@FindBy(css="#player > div.player-center > div > button.idle.btn-circle.medium.play > i") public WebElement icon_play;
		//@FindBy(css="#player > div.player-center > div > button.playing.btn-circle.medium.play > i") public WebElement icon_stop;
		
	//	@FindBy(css="#player > div.player-center > div > button.btn.text.no-border.xsmall > span") public WebElement icon_scan;
		//@FindBy(css="#player > div.player-left > div.player-info > a.player-artist.type-secondary.type-xsmall") public WebElement songPlaying;
		@FindBy(css=".player-artist") public WebElement songAfterSkip;
		
		//Volume Bar
	    @FindBy(css=".slider-range-appearance") private WebElement volumeBar;
	    
		
	public void WEB_14441_mutePlayer()
	{   
		gotoExplorerOption(option_liveRadio, "Live");
		volumeButton.click();
		if (!iconMute.getAttribute("class").equalsIgnoreCase("icon-mute"))
			handleError("Player is not muted.", "WEB_14441_mutePlayer");
	    
	}
	
	public void WEB_11744_filterStation()
	{   
		gotoExplorerOption(option_liveRadio, "Live");
		new Select(country).selectByVisibleText("Mexico");
		WaitUtility.sleep(1000);
		new Select(city).selectByIndex(3);
		WaitUtility.sleep(1000);
		new Select(genres).deselectByIndex(2);
		
		String chosenStation = firstStationLabel.getText();
		System.out.println("chosen station:" + chosenStation);
		firstStation.click();
		
		WaitUtility.sleep(31000);//wait for the pre-roll done
		
		String playingStation = stationPlaying.getText();
		System.out.println("station PLAYING:" + playingStation);
		
		if (!chosenStation.equalsIgnoreCase(playingStation))
			handleError("Filter is not working.", "WEB_11744_filterStation");
	}
	
	

	public void WEB_11745_International()
	{  
		gotoExplorerOption(option_liveRadio, "Live");
		do{
		  new Select(city).selectByVisibleText("All Stations, INT");
		  WaitUtility.sleep(500);
		}while(!h3_header.getText().contains("All Stations, INT"));
		
		WaitUtility.sleep(500);
		
		firstINT.click();
		firstINT_playButton.click();
		
		//Verify that it is indeed playing
		if (!firstINT_stopPlayButton.getAttribute("class").equalsIgnoreCase("icon-stop"))
			handleError("The chosen station is not playing.", "WEB_11745_International");
	}
	
	public void WEB_11796_LiveStationAutoPlay(){
		gotoExplorerOption(option_liveRadio, "Live");
		
		firstLiveTextLink.click();
		WaitUtility.sleep(1000);
		System.out.println("SEE new url:"  + driver.getCurrentUrl()+ "?autoplay=true" );
		driver.get(driver.getCurrentUrl()+ "?autoplay=true");
		WaitUtility.sleep(1000);
		//verify that the player is indeed playing
		verifyPlayer("Auto Play", "WEB_11796_LiveStationAutoPlay");
		
		/*
		if (!player_stopButton.getAttribute("class").equalsIgnoreCase("icon-stop"))
			handleError("Auto play is not working.", "WEB_11796_LiveStationAutoPlay");
		*/	
	}
	
	public void WEB_11746_PlayStopScan(){
		gotoExplorerOption(option_liveRadio, "Live");
		icon_play.click();
		
		makeSureItIsPlaying();
		
		icon_stop.click();
		
		icon_play.click();
		//here, get the song that is playing
		String songTitle = player_song.getText();
		System.out.println("song playing:" + songTitle);
		icon_scan.click();
		WaitUtility.sleep(1000);
		String songAfter = player_song.getText();
		System.out.println("after skip:"  + songAfter);
		if (songTitle.equalsIgnoreCase(songAfter))
			handleError("Scan button is not working.", "WEB_11746_PlayStopScan" );
	}
	
	
	//For logged in cases
	public void WEB_11752_thumpUp()
	{   login();
		
		gotoExplorerOption(option_liveRadio, "Live");
		
		do {
			firstLive.click();
			WaitUtility.sleep(300);
		}while (driver.getTitle().contains("Popular"));	
		makeSureItIsPlaying();
		
		doThumbUp("WEB_11752_thumpUp");
	}
	
	public void WEB_11751_INT()
	{   
		login();
		
		WEB_11745_International();
	}
	
	public void WEB_11755_favorite()
	{  //fOR FAVORITE, make sure that the player is not playing to circuit pre-roll
		login();
		
		gotoExplorerOption(option_liveRadio, "Live");
		firstLive.click();
		makeSureItIsNotPlaying();
		
		doFavorite("WEB_11755_favorite");
		/*
		favorite.click();
		WaitUtility.sleep(500);
		String _growls = growls.getText();
		System.out.println("See growls:" + _growls);
		if (!_growls.contains("Favorite"))
		   handleError("Add to Favorite failed.", "WEB_11755_favorite");
		   
		*/   
	}
	
	
	public void WEB_11754_thumpDown()
	{   login();
		gotoExplorerOption(option_liveRadio, "Live");
		firstLive.click();
		makeSureItIsPlaying();
		
		//Keep scan if the thumbDown icon is disabled
		
		while (!thumbDown.isEnabled())
		{	
			icon_scan.click();
			WaitUtility.sleep(3000);
		}
		
		thumbDown.click();
		WaitUtility.sleep(200);
		//String hint = growls.getText();
		String response = driver.findElement(By.className("growls")).getText();
		System.out.println("See growls:" + response);
		if (!response.contains("Thanks for your feedback"))
			handleError("Thump Down is not working properly.", "WEB_11754_thumpDown");
	}
	
	public void WEB_11747_adjustVolume()
	{   login();
		gotoExplorerOption(option_liveRadio, "Live");
		firstLive.click();
		makeSureItIsPlaying();
		int widthOfVolumeBar = volumeBar.getSize().getWidth();
		System.out.println("See bar width:" + widthOfVolumeBar) ;
		Actions slideAction = new Actions(driver);
		slideAction.clickAndHold(volumeBar);
		slideAction.moveByOffset(widthOfVolumeBar, 0).build().perform();
		//Need to add acceptance criteria
		
	}
	
	

}
