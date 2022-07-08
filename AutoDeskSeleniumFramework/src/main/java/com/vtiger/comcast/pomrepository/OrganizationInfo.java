package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.ExcelUtility;

public class OrganizationInfo extends ExcelUtility {

	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successImage;

	
	public WebElement getSuccessImage() {
		return successImage;
	}

	public String ActualOrgName() {
		return successImage.getText();
	}
	
}
