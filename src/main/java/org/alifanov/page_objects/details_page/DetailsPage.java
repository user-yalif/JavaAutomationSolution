package org.alifanov.page_objects.details_page;

import static org.junit.Assert.assertTrue;

import org.alifanov.page_objects.BasePage;
import org.alifanov.utility.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage extends BasePage {

	public DetailsPage(WebDriver driver) {
		super(driver);
		log = LogHelper.getLogger(DetailsPage.class);

		try {
			assertTrue(wait.appearenceOf(writeToAthor));
			log.info("PAGE: " + DetailsPage.class.getSimpleName() + " UPLOADED");
		} catch (AssertionError e) {
			log.warn("PAGE: " + DetailsPage.class.getSimpleName() + " UNABLE TO UPLOAD");
			throw new AssertionError();
		} catch (TimeoutException e) {
			log.warn("PAGE: " + DetailsPage.class.getSimpleName() + " UNABLE TO UPLOAD Time run out: " + e.getMessage());
			throw new AssertionError();
		}
	}

	// Locators
	private final By writeToAthor = By.xpath("//li//i[@data-icon='message']/following-sibling::span");

	private WebElement mileageValueLocator() {
		return getElement(By.xpath("//th[normalize-space()='Пробег']/following-sibling::td/strong"));
	}
	// end Locators

	public String getMileageValue() {
		return action.getTextOf(mileageValueLocator());
	}
}
