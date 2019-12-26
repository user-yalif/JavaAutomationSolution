package org.alifanov.page_objects.filters.motor_cars;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.alifanov.page_objects.details_page.DetailsPage;
import org.alifanov.page_objects.filters.BaseFilterPage;
import org.alifanov.utility.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MotorCarsFilterPage extends BaseFilterPage {

	public MotorCarsFilterPage(WebDriver driver) {
		super(driver);
		log = LogHelper.getLogger(MotorCarsFilterPage.class);

		try {
			assertTrue(wait.appearenceOf(motorCarsFilterPageHeader));
			log.info("PAGE: Motor Cars Filter Page UPLOADED");
			closeCookieMessage();
		} catch (AssertionError e) {
			log.warn("PAGE: Motor Cars Filter Page UNABLE TO UPLOAD");
			throw new AssertionError();
		} catch (TimeoutException e) {
			log.warn("PAGE: Motor Cars Filter Page UNABLE TO UPLOAD Time run out: " + e.getLocalizedMessage());
			throw new AssertionError();
		}
	}

// region LOCATORS
	private final By motorCarsFilterPageHeader = By.xpath("//span[@id='main-category-choose-label']");
	private final By priceValue = By.xpath(
			"//div[contains(@class, 'filter-item-from') and contains(@class, 'price')]//a[not(contains(@class, 'hidden'))]/span[@class='header block']");
	private final By dropdownLocator = By
			.xpath("//ul[contains(@class, 'small suggestinput') and contains(@style, 'display: block;')]");
	private final By priceLocator = By.xpath("//p[@class='price']");

	private List<WebElement> textFieldsHeadersLocator() {
		return getElements(By.xpath("//span[contains(@class, 'header block')]"));
	}

	private WebElement brandFieldLocator() {
		return getElement(By.xpath("//span[normalize-space()='Марка']"));
	}

	private List<WebElement> brandDropdownItemsLocator() {
		return getElements(By.xpath("//ul//a[@data-name='search[category_id]']"));
	}

	private WebElement priceFromTextFieldLocator() {
		return getElement(By.xpath("//div[contains(@class, 'filter-item-from') and contains(@class, 'price')]"));
	}

	private WebElement priceFromValueLocator() {
		return this.priceFromTextFieldLocator().findElement(By.xpath("//span[@class='header block']"));
	}

	private WebElement priceFromInputLocator() {
		return getElement(By.xpath("//li[@id='param_price']//input[@defaultval='от...']"));
	}

	private WebElement priceToTextFieldLocator() {
		return getElement(By.xpath("//div[contains(@class, 'filter-item-to') and contains(@class, 'price')]"));
	}

	private WebElement priceFromDropdownItemLocator(String item) {
		return getElement(By.xpath(String.format(
				"//li[@data-key='price']//div[contains(@class, 'filter-item-from')]/ul[contains(@style, 'display: block;')]/li[normalize-space()='%s']",
				item)));
	}

	private WebElement priceToDropdownItemLocator(String item) {
		return getElement(By.xpath(String.format(
				"//li[@data-key='price']//div[contains(@class, 'filter-item-to')]/ul[contains(@style, 'display: block;')]/li[normalize-space()='%s']",
				item)));
	}

	private WebElement mileageFromFieldLocator() {
		return getElement(By.xpath("//li[@data-key='motor_mileage']//div[contains(@class, 'filter-item-from')]"));
	}

	private WebElement mileageFromInputLocator() {
		return getElement(By.xpath("//li[@id='param_motor_mileage']//input[@defaultval='от...']"));
	}

	private WebElement mileageToFieldLocator() {
		return getElement(By.xpath("//li[@data-key='motor_mileage']//div[contains(@class, 'filter-item-to')]"));
	}

	private WebElement mileageToInputLocator() {
		return getElement(By.xpath("//li[@id='param_motor_mileage']//input[@defaultval='до...']"));
	}

	private WebElement mileageFromDropdownItemLocator(String itemName) {
		return getElement(By.xpath(String.format(
				"//li[@data-key='motor_mileage']//div[contains(@class, 'filter-item-from')]//ul[contains(@style, 'display: block;')]//li[normalize-space()='%s']",
				itemName)));
	}

	private WebElement mileageToDropdownItemLocator(String itemName) {
		return getElement(By.xpath(String.format(
				"//li[@data-key='motor_mileage']//div[contains(@class, 'filter-item-to')]//ul[contains(@style, 'display: block;')]//li[normalize-space()='%s']",
				itemName)));
	}

	private WebElement searchButtonLocator() {
		return getElement(By.xpath("//span[contains(@class, 'button search')]"));
	}

	private List<WebElement> detailsPageLinkLocators() {
		return getElements(By.xpath("//td[@class='title-cell']//a[contains(@class, 'detailsLink')]"));
	}

	private WebElement transmissionFieldLocator() {
		return getElement(By.xpath("//li[@id='param_transmission_type']"));
	}

	private WebElement transmissionDropdownAllItemLocator() {
		return getElement(By.xpath(
				"//li[@id='param_transmission_type']//ul[@style='display: block;']//label[normalize-space()='Все']//input"));
	}

	private WebElement transmissionDropdownItemLocator(String itemName) {
		return getElement(
				By.xpath(String.format("//li[@id='param_transmission_type']//input[@data-text='%s']", itemName)));
	}
// end Locators

	public List<String> getTextFieldsHeaders() {
		List<WebElement> textFields = this.textFieldsHeadersLocator();
		List<String> headers = new ArrayList<String>();

		for (WebElement element : textFields) {
			headers.add(action.getTextOf(element));
		}

		return headers;
	}

	public void clickOnBrandsTextField() {
		action.clickOn(brandFieldLocator());
		wait.appearenceOf(dropdownLocator);
	}

	public List<String> getBrandDropdownItemsText() {
		List<WebElement> items = this.brandDropdownItemsLocator();
		List<String> itemsText = new ArrayList<String>();

		for (WebElement item : items) {
			itemsText.add(action.getTextOf(item));
		}

		return itemsText;
	}

	public void clickOnPriceFromTextField() {
		action.clickOn(priceFromTextFieldLocator());
		wait.appearenceOf(dropdownLocator);
	}

	public void clickOnPriceToTextField() {
		action.clickOn(priceToTextFieldLocator());
		wait.appearenceOf(dropdownLocator);
	}

	public void choosePriceFromDropdownItem(String item) {
		action.clickOn(priceFromDropdownItemLocator(item));
		wait.disappearenceOf(dropdownLocator);
	}

	public void choosePriceToDropdownItem(String item) {
		action.clickOn(priceToDropdownItemLocator(item));
		wait.disappearenceOf(dropdownLocator);
	}

	public void inputPriceFrom(String price) {
		action.clickOn(priceFromTextFieldLocator());
		action.clear(priceFromInputLocator());
		action.clickOn(priceFromTextFieldLocator());

		inputTextField(priceFromInputLocator(), price);
		action.pressEnter();
		wait.disappearenceOf(dropdownLocator);
	}

	public String getPriceFromValue() {
		wait.appearenceOf(priceValue);
		return action.getTextOf(priceFromValueLocator());
	}

	public void clickOnMileageFromTextField() {
		action.clickOn(mileageFromFieldLocator());
		wait.appearenceOf(dropdownLocator);
	}

	public void clickOnMileageToTextField() {
		action.clickOn(mileageToFieldLocator());
		wait.appearenceOf(dropdownLocator);
	}

	public void chooseMileageFromDropdownItem(String item) {
		action.clickOn(mileageFromDropdownItemLocator(item));
	}

	public void chooseMileageToDropdownItem(String item) {
		action.clickOn(mileageToDropdownItemLocator(item));
	}

	public void inputMileageFrom(String mileage) {
		action.clickOn(mileageFromFieldLocator());
		action.clear(mileageFromInputLocator());
		action.clickOn(mileageFromFieldLocator());

		inputTextField(mileageFromInputLocator(), mileage);
		action.pressEnter();
		wait.disappearenceOf(dropdownLocator);
	}

	public void inputMileageTo(String mileage) {
		action.clickOn(mileageToFieldLocator());
		action.clear(mileageToInputLocator());
		action.clickOn(mileageToFieldLocator());

		inputTextField(mileageToInputLocator(), mileage);
		action.pressEnter();
		wait.disappearenceOf(dropdownLocator);
	}

	public void clickOnSearchButton() {
		action.clickOn(searchButtonLocator());
		waitForPageLoaded();
	}

	public DetailsPage clickOnDetailsPageLink(int linkIndex) {
		var links = detailsPageLinkLocators();
		if (links.size() > 0) {
			action.clickOn(links.get(linkIndex));
			return new DetailsPage(getWebDriver());
		} else {
			log.warn("There are no details links on the " + this.getClass().getSimpleName());
			return null;
		}
	}

	public void clickOnTransmissionField() {
		action.clickOn(transmissionFieldLocator());
		wait.appearenceOf(dropdownLocator);
	}

	public void clickOnTransmissionDropdownItem(String itemName) {
		action.clickOn(transmissionDropdownItemLocator(itemName));
	}

	public boolean getTransmissionDropdownAllItemStatus() {
		return action.isChecked(transmissionDropdownAllItemLocator());
	}

	public boolean getTransmissionCheckboxItemStatus(String itemName) {
		return action.isChecked(transmissionDropdownItemLocator(itemName));
	}

	public List<String> getPriceValues() {
		List<WebElement> priceElements = getElements(priceLocator);
		List<String> priceValues = new ArrayList<String>();

		for (WebElement element : priceElements) {
			priceValues.add(action.getTextOf(element));
		}

		return priceValues;
	}
}
