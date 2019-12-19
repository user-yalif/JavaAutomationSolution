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
			assertTrue("�������� ������".equals(super.action.getTextOf((writeToAthorLocator()))));
		} catch (Exception e) {
			log.warn("Detail Page was not downloaded!");
		}

		log.info("Detail Page was downloaded");
	}

	// Locators
	private WebElement writeToAthorLocator() {
		return super.getElement(By.xpath("//li//i[@data-icon='message']/following-sibling::span"));
	}
	
	private WebElement mileageValueLocator() {
		return super.getElement(By.xpath("//th[normalize-space()='������']/following-sibling::td/strong"));
	}
	// end Locators
	
	public String getMileageValue() {
		return super.action.getTextOf(mileageValueLocator());
	}
}
