package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.WebDriverUtility;
/**
 * This class is to click on organizations link
 * @author Kiran S
 *
 */
public class CreateNewOrganizationPage extends WebDriverUtility {

	//initialization of webelements
		public CreateNewOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//declaraion of webelements
		
		@FindBy(name="accountname")
		private WebElement  OrgNameTextField;
		
		@FindBy(name="industry")
		private WebElement Industry;
		
		public WebElement getIndustry() {
			return Industry;
		}

		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement  SaveButton;

		public WebElement getOrgNameTextField() {
			return OrgNameTextField;
		}

		public WebElement getSaveButton() {
			return SaveButton;
		}
		
		/**
		 * This method will enter organization name
		 * @param orgName
		 */
		public void createNewOrg(String orgName) {
			OrgNameTextField.sendKeys(orgName);
		}
		public void selectHealthcare() {
		select(Industry,"Healthcare");
		}
		
		/**
		 * This method click on save button
		 */
		public void SaveOrgButton(WebDriver driver) {
			SaveButton.click();
			waitForElementToBeClickable(driver,SaveButton);
		}			
	}


