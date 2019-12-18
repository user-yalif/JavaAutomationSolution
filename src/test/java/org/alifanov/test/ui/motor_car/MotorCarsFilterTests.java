package org.alifanov.test.ui.motor_car;

import org.alifanov.page_objects.motor_cars.MotorCarsPage;
import org.alifanov.test.ui.UIBaseTest;
import org.alifanov.utility.LogHelper;
import org.apache.log4j.Logger;
import org.junit.Test;

public class MotorCarsFilterTests extends UIBaseTest {

	private Logger log = LogHelper.getLogger(MotorCarsFilterTests.class);

	public MotorCarsFilterTests() {
		super();
	}

	@Test
	public void DefaultFiltersFieldsTest() throws InterruptedException {
		MotorCarsPage carsPage = new MotorCarsPage(super.getDriver());
		log.info("Test");
	}
}
