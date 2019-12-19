package org.alifanov.test.ui.motor_car;

import static org.alifanov.utility.ArayListsHelper.sortAscending;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.alifanov.page_objects.motor_cars.MotorCarsFilterPage;
import org.alifanov.test.ui.UIBaseTest;
import org.alifanov.tests.data.MotorCarsFilterPageTestData;
import org.alifanov.utility.LogHelper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class MotorCarsFilterTests extends UIBaseTest {

	private Logger log = LogHelper.getLogger(MotorCarsFilterTests.class);
	private MotorCarsFilterPageTestData testData;

	public MotorCarsFilterTests() {
		super();
		testData = new MotorCarsFilterPageTestData();
	}

	@Test
	public void MotorCarsFilterDefaultPlaceholders() {
		log.info("TEST: Verifies default filters placeholders on the Motor Cars Filter Page");

		MotorCarsFilterPage carsFilterPage = new MotorCarsFilterPage(super.getDriver());
		testData.defaultPlaceholders = sortAscending(this.testData.getDefaultPlaceholders());

		log.info("STEP 1: Check all default filter text field's palceholders");

		List<String> actualPlaceholders = carsFilterPage.getTextFieldsHeaders();
		actualPlaceholders = sortAscending(actualPlaceholders);

		try {
			Assert.assertArrayEquals(testData.getDefaultPlaceholders().toArray(), actualPlaceholders.toArray());
		} catch (AssertionError e) {
			log.warn("Motor Cars Default Placeholders are not the same as expected " + e.toString());
			throw new AssertionError();
		}

		actualPlaceholders.clear();

		log.info("RESULT: Placeholders on the page are as expected");
	}

	@Test
	public void MotorCarsFilterAutoBrandsDropdown() {
		log.info("TEST: Verifies presence of some brands in Brands dropdown on Motor Cars Filter Page");

		MotorCarsFilterPage carsFilterPage = new MotorCarsFilterPage(super.getDriver());

		log.info("STEP 1: Check if Brand's dropdown contains some auto brands");

		carsFilterPage.clickOnBrandsDropdown();
		List<String> actualBrands = carsFilterPage.getBrandDropdownItemsText();

		try {
			for (String brand : testData.getBrands()) {
				log.info(String.format("EXPECTED BRAND: %s", brand));
				Assert.assertTrue(String.format("Brand %s does not exist in dropdown", brand),
						actualBrands.contains(brand));
			}
		} catch (AssertionError e) {
			log.warn("Brands Dropdown does not contain some brands of cars " + e.toString());
			throw new AssertionError();
		}

		actualBrands.clear();

		log.info("RESULT: Brands Dropdown contains all expected brands");
	}

	@Test
	public void MotorCarsFilterPriceTextFieldInput() {
		log.info("TEST: Verifies that only numbers can be inputed in Price text field on Motor Cars Filter Page");

		MotorCarsFilterPage carsFilterPage = new MotorCarsFilterPage(super.getDriver());

		log.info("STEP 1: Checking Price from text field.");

		for (var input : testData.getPriceInput()) {
			carsFilterPage.inputPriceFrom(input);
			var textFieldValue = carsFilterPage.getPriceFromValue();

			log.info(String.format("INPUT: %s", input));

			try {
				if (textFieldValue != null && !textFieldValue.isEmpty()) {

					Pattern pattern = Pattern.compile("[0-9]+");
					Matcher match = pattern.matcher(textFieldValue.trim());
					String value = null;

					if (match.find())
						value = match.group();
					else
						value = "There are no digits in string";

					Assert.assertTrue(String.format("Incorrect input format: %s", textFieldValue), value.equals(input));

					carsFilterPage.removePriceFromValue();

				} else if (textFieldValue == null || textFieldValue.isEmpty()) {
					Assert.assertTrue(textFieldValue == null || textFieldValue.isEmpty());
					log.info(String.format("Price from input field does not take %s input", textFieldValue));
				} else {
					Assert.fail(String.format("Price input field takes incorect value %s", textFieldValue));
				}
			} catch (AssertionError e) {
				log.warn(String.format("Price input field takes incorrect format %s", textFieldValue));
				throw new AssertionError();
			}
		}

		log.info("RESULT: Price text field takes correct input");
	}
}
