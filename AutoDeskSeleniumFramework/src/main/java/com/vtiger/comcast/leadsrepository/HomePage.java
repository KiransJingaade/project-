package com.vtiger.comcast.leadsrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Leads")
	private WebElement leadslink;

	@FindBy(linkText="Organizations")
	private WebElement organizationlink;

	@FindBy(linkText="Contacts")
	private WebElement contactsLink;

	@FindBy(linkText="Products")
	private WebElement productsLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimg;

	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;

	public WebElement getOrganizationlink() {
		return organizationlink;
	}
	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLeadslink() {
		return leadslink;
	}
	public WebElement getProductsLink() {
		return productsLink;
	}


	public WebElement getSignouticonimage() {
		return administratorimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	//business logic
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganizationLink() {
		organizationlink.click();
	}
	public void clickOnLeadsLink() {
		leadslink.click();
	}
	/**
	 * This method will logout the application
	 * @param driver
	 */
	public void  logOut(WebDriver driver) {
		mouseOverOnElement(driver,administratorimg);
		signoutlink.click();
	}
}

