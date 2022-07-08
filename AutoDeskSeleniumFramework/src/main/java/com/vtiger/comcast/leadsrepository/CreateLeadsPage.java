package com.vtiger.comcast.leadsrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.WebDriverUtility;

public class CreateLeadsPage extends WebDriverUtility {

	public CreateLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="firstname")
	private WebElement nametextfield;

	@FindBy(id="designation")
	private WebElement titletextfield;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement successImage;

	@FindBy(xpath="//b[text()='Lead Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement leadinfosavebutton;
	
	@FindBy(name="leadsource")
	private WebElement leadsourceselect;
	
	@FindBy(name="industry")
	private WebElement selectindustry;
	
	
	@FindBy(name="annualrevenue")
	private WebElement annualRevenueTextField;
	
	@FindBy(name="noofemployees")
	private WebElement noOfEmployeesTextField;
	
	@FindBy(name="secondaryemail")
	private WebElement secondaryEmailTextField;
	
	@FindBy(id="phone")
	private WebElement phoneNumber;
	
	@FindBy(id="mobile")
	private WebElement mobileNumber;
	
	@FindBy(id="fax")
	private WebElement faxNumber;
	
	@FindBy(id="email")
	private WebElement emailId;
	
	@FindBy(name="website")
	private WebElement websiteName;
	
	@FindBy(name="leadstatus")
	private WebElement Leadstatus;
	
	@FindBy(name="rating")
	private WebElement Rating;
	
	@FindBy (name="lane")
	private WebElement streetName;
	
	@FindBy(id="code")
	private WebElement postalCode;
	
	@FindBy (id="country")
	private WebElement countryName;
	
	@FindBy (id="pobox")
	private WebElement poboxNumber;
	
	@FindBy (id="city")
	private WebElement cityName;
	
	@FindBy (id="state")
	private WebElement stateName;
	
	@FindBy(name="description")
	private WebElement descriptionInformation;
	
	
	@FindBy(xpath="//b[text()='Lead Information']/following::input[@title='Save [Alt+S]']")
	private WebElement descrptioninfosavebutton;
	
	public WebElement getDescrptioninfosavebutton() {
		return descrptioninfosavebutton;
	}


	public WebElement getStreetName() {
		return streetName;
	}


	public WebElement getPostalCode() {
		return postalCode;
	}


	public WebElement getCountryName() {
		return countryName;
	}


	public WebElement getPoboxNumber() {
		return poboxNumber;
	}


	public WebElement getCityName() {
		return cityName;
	}


	public WebElement getStateName() {
		return stateName;
	}


	public WebElement getDescriptionInformation() {
		return descriptionInformation;
	}


	public WebElement getPhoneNumber() {
		return phoneNumber;
	}


	public WebElement getRating() {
		return Rating;
	}


	public WebElement getMobileNumber() {
		return mobileNumber;
	}


	public WebElement getFaxNumber() {
		return faxNumber;
	}


	public WebElement getEmailId() {
		return emailId;
	}


	public WebElement getWebsiteName() {
		return websiteName;
	}


	public WebElement getAnnualRevenueTextField() {
		return annualRevenueTextField;
	}


	public WebElement getNoOfEmployeesTextField() {
		return noOfEmployeesTextField;
	}


	public WebElement getSecondaryEmailTextField() {
		return secondaryEmailTextField;
	}


	public WebElement getSelectindustry() {
		return selectindustry;
	}


	public WebElement getLeadstatus() {
		return Leadstatus;
	}


	public WebElement getLeadsourceselect() {
		return leadsourceselect;
	}


	public WebElement getNametextfield() {
		return nametextfield;
	}
		
	
	public WebElement getTitletextfield() {
		return titletextfield;
	}


	public WebElement getSavebutton() {
		return leadinfosavebutton;
	}
	
	public WebElement getSuccessImage() {
		return successImage;
	}

	public void TextField(String firstnametextfield,String companytitle) {
		nametextfield.sendKeys(firstnametextfield);
		titletextfield.sendKeys(companytitle);	
	}
	public String actualLeadsPage() {
		return successImage.getText();
	}
	public void clickOnSaveButton() {
		leadinfosavebutton.click();
	}
	/**
	 * method used to return actual alert message
	 * @param alertmessage
	 * @return
	 */
	public String actualAlertMessage(String alertmessage) {
		return alertmessage;
	}
	
	public void selectLeadSource() {
		select(leadsourceselect,"Partner");
	}
	public void selectIndustry() {
		select(selectindustry,"Apparel");
	}
	public void leadStatus( ) {
		select(Leadstatus,"Cold");
	}
	public void leadRating( ) {
		select(Rating," Acquired");
	}
	public void AnnualRevenue(String annualrevenue) {
		annualRevenueTextField.sendKeys(annualrevenue);
	}
	public void NoOfEmployees(String NumberOfEmployees) {
		noOfEmployeesTextField.sendKeys(NumberOfEmployees);	
	}
	
	public void SecondaryEmail(String SecondaryMail) {
		secondaryEmailTextField.sendKeys(SecondaryMail);	
	}
	
	public void Phone(String PhoneNumber) {
		phoneNumber.sendKeys(PhoneNumber);
	}
	
	public void Mobile(String MobileNumber) {
		mobileNumber.sendKeys(MobileNumber);
	}
	
	public void Fax (String FaxNumber) {
		faxNumber.sendKeys(FaxNumber);
	}
	public void Email (String EmailId) {
		emailId.sendKeys(EmailId);
		
	}
	public void Website(String WebsiteName) {
		websiteName.sendKeys(WebsiteName);
	}
	
	public void Street (String StreetName) {
		streetName.sendKeys(StreetName);
	}
	
	public void Code (String PostCode) {
		postalCode.sendKeys(PostCode);
	}
	
	public void Country(String CountryName) {
		countryName.sendKeys(CountryName);
	}
	public void PoBox(String PoBoxNumber) {
		poboxNumber.sendKeys(PoBoxNumber);
	}
	
	public void City(String CityName) {
		cityName.sendKeys(CityName);
	}
	public void State(String StateName) {
		stateName.sendKeys(StateName);
	}
	
    public void Description(String DescriptionText) {
    	descriptionInformation.sendKeys(DescriptionText);
    }
}
