package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility{

	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Products")
	private WebElement productslink;

	@FindBy(css="img[title='Create Product...']")
	private WebElement createproductsimage;

	@FindBy(name="productname")
	private WebElement productnametextfield;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	@FindBy(className="lvtHeaderText")
	private WebElement successImg;


	public WebElement getProductslink() {
		return productslink;
	}


	public WebElement getCreateproductsimage() {
		return createproductsimage;
	}


	public WebElement getProductnametextfield() {
		return productnametextfield;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}


	public WebElement getSuccessImg() {
		return successImg;
	}

	public void clickOnProducts() {
		productslink.click();
		createproductsimage.click();
	}

	public void enterProductname(String productname) {
		productnametextfield.sendKeys(productname);
	}
	public void clickOnSaveButton(WebDriver driver) {
		savebutton.click();
	}
	public String ActualProductName() {
		return successImg.getText();
	}
}
