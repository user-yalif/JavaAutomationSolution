package org.alifanov.page_objects.motor_cars;

import java.util.List;

import org.alifanov.page_objects.BasePage;
import org.alifanov.utility.LogHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MotorCarsPage extends BasePage {
	private Logger log = LogHelper.getLogger(MotorCarsPage.class);

	public MotorCarsPage(WebDriver driver) {
		super(driver);
		log.info("MotorCarsPage constructor");
	}

	private List<WebElement> TextFieldsHeaders() {
		return super.getElements(By.xpath("//span[contains(@class, 'header block')]"));
	}

	public List<WebElement> GetTextFieldsHeaders() {
		return this.TextFieldsHeaders();
	}
}
