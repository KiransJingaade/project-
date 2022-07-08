package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgImg;

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	//business logic
		/**
		 * This method will click on Create organization image
		 */
		public void clickOnCreateOrgImg() {
			createOrgImg.click();
		}

}
