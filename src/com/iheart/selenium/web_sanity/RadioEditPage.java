package com.iheart.selenium.web_sanity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.junit.Assert;

import static org.junit.Assert.*; 

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;




public class RadioEditPage extends Page {

	

	@FindBy(css="li.genre:nth-child(13) > div:nth-child(1) > div:nth-child(1)")
			public WebElement comedy;		
	

	
	 public RadioEditPage() {
			
	}
		
	public RadioEditPage(WebDriver driver) {
			super(driver);
	}
	
	
	public void login()
	{  //#loginForm > fieldset:nth-child(1) > input:nth-child(3)
		
		System.out.println(driver.findElement(By.tagName("iframe")).getAttribute("class"));
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		driver.findElement(By.cssSelector("#loginForm > fieldset:nth-child(1) > input:nth-child(3)")).sendKeys("1111128");
		driver.findElement(By.cssSelector("#loginForm > fieldset:nth-child(1) > input:nth-child(5)")).sendKeys("Sunnyday1");
		driver.findElement(By.cssSelector("input.button")).click();
	}
	
	public void dragDrop()
	{   login();
	
	    driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("#workspace > div > ng-include > div > ul > li > ng-include > div > a.app-open")).click();
		
		//switch to new window
		String winHandleBefore = driver.getWindowHandle();
		//Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}	
		
		driver.findElement(By.cssSelector("#body > div:nth-child(2) > div > div > div.pane.ng-isolate-scope.west.fixed > div.pane-scroller > div > ul:nth-child(1) > li:nth-child(5) > a")).click();
		driver.findElement(By.cssSelector("#select2-chosen-10")).click();
		driver.findElement(By.cssSelector("li.ng-scope:nth-child(2)")).click();
		
		
		
		Actions builder = new Actions(driver);
		WebElement src = driver.findElement(By.cssSelector("li.ng-scope:nth-child(1)")); 
		System.out.println("SRC:" + src.getText()  +"/" + src.getLocation().x + "/" + src.getLocation().y );
		WebElement dest = driver.findElement(By.cssSelector("li.ng-scope:nth-child(4)"));
		System.out.println("DEST:" + dest.getText() +"/"  + dest.getLocation().x + "/" + dest.getLocation().y );         
		
		
		builder.dragAndDropBy(src, src.getLocation().y, dest.getLocation().y + 100).perform();
      
	}
	
}
