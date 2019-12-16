package org.alifanov.test.ui;

import org.alifanov.page_objects.motor_cars.MotorCarsPage;
import org.alifanov.test_cases.UIBaseTest;
import org.junit.Test;

public class MotorCarsFilterTests extends UIBaseTest {
	public MotorCarsFilterTests(){
		super();
	}
	
	@Test
	public void DefaultFiltersFieldsTest() throws InterruptedException {
		MotorCarsPage carsPage = new MotorCarsPage(super.getDriver());
		
	}
}
