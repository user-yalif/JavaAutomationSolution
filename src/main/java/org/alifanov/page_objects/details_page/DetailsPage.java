package org.alifanov.page_objects.details_page;

import static org.junit.Assert.assertTrue;

import org.alifanov.page_objects.BasePage;
import org.alifanov.utility.LogHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage extends BasePage {

	private Logger log = LogHelper.getLogger(DetailsPage.class);

	public DetailsPage(WebDriver driver) {
		super(driver);

		try {
			assertTrue(super.wait.appearenceOf(writeToAthor));
			log.info("PAGE: Detail Page UPLOADED");
		} catch (AssertionError e) {
			log.warn("PAGE: Detail Page UNABLE TO UPLOAD");
			throw new AssertionError();
		}
	}

	// Locators
	private final By writeToAthor = By.xpath("//li//i[@data-icon='message']/following-sibling::span");

	private WebElement mileageValueLocator() {
		return super.getElement(By.xpath("//th[normalize-space()='Пробег']/following-sibling::td/strong"));
	}
	// end Locators

	public String getMileageValue() {
		return super.action.getTextOf(mileageValueLocator());
	}
}
