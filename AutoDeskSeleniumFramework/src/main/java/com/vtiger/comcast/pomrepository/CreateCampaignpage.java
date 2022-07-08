package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtility;

public class CreateCampaignpage extends WebDriverUtility {

	public CreateCampaignpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="Campaigns")
	private WebElement campaignlink;

	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createcampaignimg;

	@FindBy(name="campaignname")
	private WebElement entercampaignname;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement campaignsavebutton;

	@FindBy(className="dvHeaderText")
	private WebElement successImg;



	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getCreatecampaignimg() {
		return createcampaignimg;
	}


	public WebElement getEntercampaignname() {
		return entercampaignname;
	}

	public WebElement getCampaignsavebutton() {
		return campaignsavebutton;
	}

	public WebElement getSuccessImg() {
		return successImg;
	}

	public void clickOnCampaignLink() {
		campaignlink.click();
		createcampaignimg.click();
	}
	public void enterCampaignName(String campaignName) {
		entercampaignname.sendKeys(campaignName);
	}

	public void clickOnSaveButton(WebDriver driver) {
		campaignsavebutton.click();
		
	}
	public String ActualCampaignName() {
		return successImg.getText();
	}
}
