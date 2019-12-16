package org.alifanov.page_objects.motor_cars;

import java.util.List;

import org.alifanov.page_objects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MotorCarsPage extends BasePage {
	public MotorCarsPage(WebDriver driver) {
		super(driver);		
	}
	
	private List<WebElement> DefaultTextFieldsHeaders(){
		return super.getElements(By.xpath("//span[contains(@class, 'header block')]"));
	}
	
	public List<WebElement> GetTextFieldsHeaders(){
		return this.DefaultTextFieldsHeaders();
	}
}
