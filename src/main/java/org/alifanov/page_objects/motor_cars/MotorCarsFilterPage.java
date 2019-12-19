package org.alifanov.page_objects.motor_cars;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.alifanov.utility.LogHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MotorCarsFilterPage extends BaseFilterPage {
	private Logger log = LogHelper.getLogger(MotorCarsFilterPage.class);

	public MotorCarsFilterPage(WebDriver driver) {
		super(driver);
		
		super.wait.waitThread(5);
		
		try {
			assertTrue("Легковые автомобили".equals(super.action.getTextOf(motorCarsFilterPageHeader())));
		} catch (Exception e) {
			log.warn("Motor Cars Filter Page was not downloaded!");
		}
		
		log.info("MotorCarsFilterPage was downloaded");
	}

	// Locators
	private WebElement motorCarsFilterPageHeader() {
		return super.getElement(By.xpath("//span[@id='main-category-choose-label']"));
	}
	
	private List<WebElement> textFieldsHeadersLocator() {
		return super.getElements(By.xpath("//span[contains(@class, 'header block')]"));
	}
	
	private WebElement brandDropDownLocator() {
		return super.getElement(By.xpath("//span[normalize-space()='Марка']"));
	}
	
	private List<WebElement> brandDropBoxItemsLocator(){
		return super.getElements(By.xpath("//ul//a[@data-name='search[category_id]']"));
	}
	
	private WebElement priceFromTextFieldLocator() {
		return super.getElement(By.xpath("//div[contains(@class, 'filter-item-from') and contains(@class, 'price')]"));
	}
	
	private WebElement priceFromInputLocator() {
		return super.getElement(By.xpath("//li[@id='param_price']//input[@defaultval='от...']"));
	}
	
	private WebElement priceFromValueLocator() {
		return super.getElement(By.xpath("//div[contains(@class, 'filter-item-from') and contains(@class, 'price')]//span[@class='header block']"));
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
	
	public void clickOnBrandsDropdown() {
		super.action.clickOn(brandDropDownLocator());
		super.wait.waitThread(3);
	}
	
	public List<String> getBrandDropdownItemsText(){
		List<WebElement> items = this.brandDropBoxItemsLocator();
		List<String> itemsText = new ArrayList<String>();
		
		for (WebElement item : items) {
			itemsText.add(super.action.getTextOf(item));
		}
		
		return itemsText;
	}
	
	private void clickOnPriceFromTextField() {
		super.action.clickOn(priceFromTextFieldLocator());
		super.wait.waitThread(3);
	}
	
	public void inputPriceFrom(String price) {
		this.clickOnPriceFromTextField();
		super.action.clear(priceFromInputLocator());
		this.clickOnPriceFromTextField();
		super.inputPrice(priceFromInputLocator(), price);
	}
	
	public void removePriceFromValue() {
		super.clickOnCrossIcon(priceFromTextFieldLocator());
	}
	
	public String getPriceFromValue() {
		return super.getTextFieldValue(priceFromValueLocator());
	}
}
