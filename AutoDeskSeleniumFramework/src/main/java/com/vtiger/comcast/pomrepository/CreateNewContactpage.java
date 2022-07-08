package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactpage {

	public CreateNewContactpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='tabUnSelected']//a[text()='Contacts']")
	private WebElement clickoncontacts;

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcontactImg;

	@FindBy(name="lastname")
	private WebElement lastNametextfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement  conSaveButton;

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successImage;

	
	public WebElement getSuccessImage() {
		return successImage;
	}

	public WebElement getClickoncontacts() {
		return clickoncontacts;
	}

	public WebElement getCreatecontactImg() {
		return createcontactImg;
	}

	public WebElement getLastName() {
		return lastNametextfield;
	}

	public WebElement getConSaveButton() {
		return conSaveButton;
	}

	public void clickOnContacts(WebDriver driver) {
		clickoncontacts.click();
		createcontactImg.click();
	}
	public void enterLastName(String lastName) {
		lastNametextfield.sendKeys(lastName);
	}
	
	public void saveContactButton() {
		conSaveButton.click();
	}
	public String ActualContactName() {
		return successImage.getText();
	}
	
}
