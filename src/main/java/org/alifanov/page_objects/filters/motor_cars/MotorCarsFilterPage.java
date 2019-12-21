package org.alifanov.page_objects.filters.motor_cars;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.alifanov.page_objects.details_page.DetailsPage;
import org.alifanov.page_objects.filters.BaseFilterPage;
import org.alifanov.utility.LogHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MotorCarsFilterPage extends BaseFilterPage {
	private Logger log = LogHelper.getLogger(MotorCarsFilterPage.class);

	public MotorCarsFilterPage(WebDriver driver) {
		super(driver);
		
		try {
			assertTrue(super.wait.appearenceOf(motorCarsFilterPageHeader));
			log.info("PAGE: Motor Cars Filter Page UPLOADED");
			super.closeCookieMessage();
		} catch (AssertionError e) {
			log.warn("PAGE: Motor Cars Filter Page UNABLE TO UPLOAD");
			throw new AssertionError();
		}
	}

	// Locators
	private final By motorCarsFilterPageHeader = By.xpath("//span[@id='main-category-choose-label']");
	private final By brandDropdown = By.xpath("//li[@id='param_subcat']//ul");
	private final By priceValue = By.xpath("//div[contains(@class, 'filter-item-from') and contains(@class, 'price')]//a[not(contains(@class, 'hidden'))]/span[@class='header block']");
	private final By priceFromDropdown = By.xpath("//div[contains(@class, 'filter-item-from') and contains(@class, 'price')] and @style='display: block;']");
	private final By mileageFromDropdown = By.xpath(
			"//li[@data-key='motor_mileage']//div[contains(@class, 'filter-item-from')]//ul[contains(@class, 'small suggestinput') and @style='display: block;']");
	private final By mileageToDropdown = By.xpath(
			"//li[@data-key='motor_mileage']//div[contains(@class, 'filter-item-to')]//ul[contains(@class, 'small suggestinput') and @style='display: block;']");
		
	private List<WebElement> textFieldsHeadersLocator() {
		return super.getElements(By.xpath("//span[contains(@class, 'header block')]"));
	}

	private WebElement brandTextFieldLocator() {
		return super.getElement(By.xpath("//span[normalize-space()='Марка']"));
	}

	private List<WebElement> brandDropDownItemsLocator() {
		return super.getElements(By.xpath("//ul//a[@data-name='search[category_id]']"));
	}

	private WebElement priceFromTextFieldLocator() {
		return super.getElement(By.xpath("//div[contains(@class, 'filter-item-from') and contains(@class, 'price')]"));
	}

	private WebElement priceFromValueLocator() {
		return this.priceFromTextFieldLocator().findElement(By.xpath("//span[@class='header block']"));
	}

	private WebElement priceFromInputLocator() {
		return super.getElement(By.xpath("//li[@id='param_price']//input[@defaultval='от...']"));
	}

	private WebElement mileageFromTextFieldLocator() {
		return super.getElement(By.xpath("//li[@data-key='motor_mileage']//div[contains(@class, 'filter-item-from')]"));
	}

	private WebElement mileageFromInputLocator() {
		return super.getElement(By.xpath("//li[@id='param_motor_mileage']//input[@defaultval='от...']"));
	}

	private WebElement mileageToTextFieldLocator() {
		return super.getElement(By.xpath("//li[@data-key='motor_mileage']//div[contains(@class, 'filter-item-to')]"));
	}

	private WebElement mileageToInputLocator() {
		return super.getElement(By.xpath("//li[@id='param_motor_mileage']//input[@defaultval='до...']"));
	}

	private WebElement searchButtonLocator() {
		return super.getElement(By.xpath("//span[contains(@class, 'button search')]"));
	}

	private List<WebElement> detailsPageLinkLocators() {
		return super.getElements(By.xpath("//td[@class='title-cell']//a[contains(@class, 'detailsLink')]"));
	}
	// end Locators

	public List<String> getTextFieldsHeaders() {
		List<WebElement> textFields = this.textFieldsHeadersLocator();
		List<String> headers = new ArrayList<String>();

		for (WebElement element : textFields) {
			headers.add(super.action.getTextOf(element));
		}

		return headers;
	}

	public void clickOnBrandsTextField() {
		super.action.clickOn(brandTextFieldLocator());
		super.wait.appearenceOf(brandDropdown);
	}

	public List<String> getBrandDropdownItemsText() {
		List<WebElement> items = this.brandDropDownItemsLocator();
		List<String> itemsText = new ArrayList<String>();

		for (WebElement item : items) {
			itemsText.add(super.action.getTextOf(item));
		}

		return itemsText;
	}

	public void inputPriceFrom(String price) {
		super.action.clickOn(priceFromTextFieldLocator());
		super.action.clear(priceFromInputLocator());
		super.action.clickOn(priceFromTextFieldLocator());

		super.inputTextField(priceFromInputLocator(), price);
		super.action.submitOf(priceFromInputLocator());
		super.wait.disappearenceOf(priceFromDropdown);
	}

	public String getPriceFromValue() {
		super.wait.appearenceOf(priceValue);
		return super.action.getTextOf(priceFromValueLocator());
	}

	public void inputMileageFrom(String mileage) {
		super.action.clickOn(mileageFromTextFieldLocator());
		super.action.clear(mileageFromInputLocator());
		super.action.clickOn(mileageFromTextFieldLocator());

		super.inputTextField(mileageFromInputLocator(), mileage);
		super.action.submitOf(mileageFromInputLocator());
		super.action.pressEnter();
		super.wait.disappearenceOf(mileageFromDropdown);
	}

	public void inputMileageTo(String mileage) {
		super.action.clickOn(mileageToTextFieldLocator());
		super.action.clear(mileageToInputLocator());
		super.action.clickOn(mileageToTextFieldLocator());

		super.inputTextField(mileageToInputLocator(), mileage);
		super.action.submitOf(mileageToInputLocator());
		super.action.pressEnter();
		super.wait.disappearenceOf(mileageToDropdown);
	}

	public void clickOnSearchButton() {
		super.action.clickOn(searchButtonLocator());
		super.waitForPageLoaded();
	}

	public DetailsPage clickOnDetailsPageLink(int linkIndex) {
		super.action.clickOn(detailsPageLinkLocators().get(linkIndex));
		return new DetailsPage(super.getWebDriver());
	}
}
