package com.vtiger.comcast.leadsrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadsIconPage {

	public CreateLeadsIconPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="img[title='Create Lead...']")
	private WebElement createleadsicon;

	public WebElement getCreateleadsicon() {
		return createleadsicon;
	}
	/**
	 * this method clicks on create new leads image
	 */
   public void createLeadsIcon() {
	   createleadsicon.click();
   }
}
