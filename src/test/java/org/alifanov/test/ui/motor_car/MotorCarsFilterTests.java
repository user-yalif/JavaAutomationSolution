package org.alifanov.test.ui.motor_car;

import static org.alifanov.utility.ArayListsHelper.sortAscending;

import java.util.ArrayList;
import java.util.List;

import org.alifanov.page_objects.filters.motor_cars.MotorCarsFilterPage;
import org.alifanov.test.ui.UIBaseTest;
import org.alifanov.tests.data.MotorCarsFilterPageTestData;
import org.alifanov.utility.LogHelper;
import org.alifanov.utility.RegexHelper;
import org.junit.Assert;
import org.junit.Test;

public class MotorCarsFilterTests extends UIBaseTest {

	private MotorCarsFilterPageTestData testData;

	public MotorCarsFilterTests() {
		super();
		testLogger = LogHelper.getLogger(MotorCarsFilterTests.class);
		testData = new MotorCarsFilterPageTestData();
	}

	@Test
	public void MotorCarsFilterDefaultPlaceholders() {
		testLogger.info("TEST: Verifies default filters placeholders on the Motor Cars Filter Page");

		MotorCarsFilterPage carsFilterPage = new MotorCarsFilterPage(super.getDriver());
		testData.defaultPlaceholders = sortAscending(this.testData.defaultPlaceholders);

		List<String> actualPlaceholders = carsFilterPage.getTextFieldsHeaders();
		actualPlaceholders = sortAscending(actualPlaceholders);

		try {
			Assert.assertArrayEquals(testData.defaultPlaceholders.toArray(), actualPlaceholders.toArray());
			testLogger.info("RESULT: Placeholders on the page are as expected");
		} catch (AssertionError e) {
			testLogger.warn("Motor Cars Default Placeholders are not the same as expected " + e.toString());
			throw new AssertionError();
		}

		actualPlaceholders.clear();
	}

	@Test
	public void MotorCarsFilterAutoBrandsDropdown() {
		testLogger.info("TEST: Verifies presence of some brands in Brands dropdown on Motor Cars Filter Page");

		MotorCarsFilterPage carsFilterPage = new MotorCarsFilterPage(super.getDriver());

		carsFilterPage.clickOnBrandsTextField();
		List<String> actualBrands = carsFilterPage.getBrandDropdownItemsText();

		try {
			for (String brand : testData.getBrands()) {
				Assert.assertTrue(String.format("Brand %s does not exist in dropdown", brand),
						actualBrands.contains(brand));
				testLogger.info(String.format("EXPECTED BRAND: %s EXISTS in dropdown", brand));
			}
		} catch (AssertionError e) {
			testLogger.warn("Brands Dropdown does not contain some brands of cars " + e.toString());
			throw new AssertionError();
		}

		actualBrands.clear();
	}

	@Test
	public void MotorCarsFilterPriceTextFieldInput() {
		testLogger
				.info("TEST: Verifies that only numbers can be inputed in Price text field on Motor Cars Filter Page");

		MotorCarsFilterPage carsFilterPage = new MotorCarsFilterPage(super.getDriver());

		for (String priceInput : testData.getPriceInput()) {
			carsFilterPage.inputPriceFrom(priceInput);
			String textFieldValue = carsFilterPage.getPriceFromValue();
			String value = RegexHelper.getFirstIntegerFromString(textFieldValue);

			try {
				if (value != null && value.equals(priceInput)) {
					testLogger.info(String.format("CORRECT INPUT: %s", priceInput));
				} else if (textFieldValue.equals("÷ена от (грн.)")) {
					testLogger.info(String.format("IGNORED INPUT: %s", priceInput));
				} else {
					Assert.fail("Incorrect input");
				}
			} catch (AssertionError e) {
				testLogger.warn(String.format("INCORRECT INPUT: %s", priceInput));
				throw new AssertionError();
			}
		}
	}

	@Test
	public void MotorCarsFilterPageMileageManualInput() {
		testLogger.info("TEST: Verifies sorting cars by manual inputing of their mileage on Motor Cars Filter Page");

		MotorCarsFilterPage carsFilterPage = new MotorCarsFilterPage(super.getDriver());

		testLogger.info(String.format("TEST DATA: Mileage from: %s; Mileage to: %s", testData.getMileageFrom(),
				testData.getMileageTo()));

		carsFilterPage.inputMileageFrom(Double.toString(testData.getMileageFrom()));
		carsFilterPage.inputMileageTo(Double.toString(testData.getMileageTo()));
		carsFilterPage.clickOnSearchButton();

		String mileage = carsFilterPage.clickOnDetailsPageLink(0)
									   .getMileageValue();

		int parsedMileageValue = Integer.parseInt(RegexHelper.getSeparatedIntegerFromString(mileage));

		try {
			Assert.assertTrue(
					parsedMileageValue >= testData.getMileageFrom() && parsedMileageValue <= testData.getMileageTo());
		} catch (AssertionError e) {
			testLogger.warn(String.format("Actual mileage is out of range %s <= %s <= %s", testData.getMileageFrom(),
					parsedMileageValue, testData.getMileageTo()));
		}
	}

	@Test
	public void MotorCarsFilterPageMileageDropdownInput() {
		testLogger
				.info("TEST: Verifies sorting cars by choosing mileage values from dropdown on Motor Cars Filter Page");

		MotorCarsFilterPage carsFilterPage = new MotorCarsFilterPage(super.getDriver());

		testLogger.info(String.format("TEST DATA: Mileage from: %s; Mileage to: %s", testData.getSMileageFrom(),
				testData.getSMileageTo()));

		carsFilterPage.clickOnMileageFromTextField();
		carsFilterPage.chooseMileageFromDropdownItem(testData.getSMileageFrom());
		carsFilterPage.clickOnMileageToTextField();
		carsFilterPage.chooseMileageToDropdownItem(testData.getSMileageTo());
		carsFilterPage.clickOnSearchButton();

		String mileage = carsFilterPage.clickOnDetailsPageLink(0)
									   .getMileageValue();

		int parsedMileageValue = Integer.parseInt(RegexHelper.getSeparatedIntegerFromString(mileage));

		try {
			Assert.assertTrue(
					parsedMileageValue >= testData.getMileageFrom() && parsedMileageValue <= testData.getMileageTo());
		} catch (AssertionError e) {
			testLogger.warn(String.format("Actual mileage is out of range %s <= %s <= %s", testData.getMileageFrom(),
					parsedMileageValue, testData.getMileageTo()));
		}

	}

	@Test
	public void MotorCarsFilterPagePriceFiltering() {
		testLogger.info("TEST: Verifies price filtering on Motor Cars Filter Page");

		MotorCarsFilterPage carsFilterPage = new MotorCarsFilterPage(super.getDriver());

		testLogger.info(String.format("TEST DATA: Mileage from: %s; Mileage to: %s", testData.getPriceFrom(),
				testData.getPriceTo()));
		carsFilterPage.clickOnPriceFromTextField();
		carsFilterPage.choosePriceFromDropdownItem(testData.getPriceFrom());
		carsFilterPage.clickOnPriceToTextField();
		carsFilterPage.choosePriceToDropdownItem(testData.getPriceTo());
		carsFilterPage.clickOnSearchButton();

		List<String> prices = carsFilterPage.getPriceValues();
		List<Double> priceValues = new ArrayList<Double>();

		for (String price : prices) {
			if (price.contains("$")) {
				priceValues.add(Double.parseDouble(RegexHelper.getSeparatedIntegerFromString(price).replaceAll(" ", ""))
						* 23.2);
			} else {
				priceValues
						.add(Double.parseDouble(RegexHelper.getSeparatedIntegerFromString(price).replaceAll(" ", "")));
			}
		}

		double priceFrom = Double
				.parseDouble(RegexHelper.getSeparatedIntegerFromString(testData.getPriceFrom()).replaceAll(" ", ""));
		double priceTo = Double
				.parseDouble(RegexHelper.getSeparatedIntegerFromString(testData.getPriceTo()).replaceAll(" ", ""));

		try {
			for (Double price : priceValues) {
				testLogger.info(String.format("PRICE: %s", price.toString()));
				Assert.assertTrue(priceFrom <= price && priceTo >= price);
				testLogger.info(
						String.format("CORRECT RESULT: price is in range from %s to %s", priceFrom, priceTo));
			}
		} catch (AssertionError e) {
			testLogger.warn(
					String.format("INCORRECT RESULT: price is out of range from %s to %s", priceFrom, priceTo));
		}
	}

	@Test
	public void MotorCarsFilterPageTransmissionChexBoxes() {
		testLogger.info(
				"TEST: Verifies status of the check box All after clicking on another check box in dropdown Transmission type");

		MotorCarsFilterPage carsFilterPage = new MotorCarsFilterPage(super.getDriver());

		boolean allStatus = true;
		boolean checkboxStatus = false;

		testLogger.info(String.format("ER: All check box: CHECKED - %s; %s check box: UNCHECKED - %S: ", true,
				testData.getTransmissionType(), false));

		carsFilterPage.clickOnTransmissionField();

		allStatus = carsFilterPage.getTransmissionDropdownAllItemStatus();
		checkboxStatus = carsFilterPage.getTransmissionCheckboxItemStatus(testData.getTransmissionType());

		try {
			Assert.assertTrue(allStatus);
			Assert.assertFalse(checkboxStatus);
			testLogger.info(String.format("AR: All check box: CHECKED - %s; %s check box: UNCHECKED - %s: ", allStatus,
					testData.getTransmissionType(), checkboxStatus));
		} catch (AssertionError e) {
			testLogger.warn(String.format("WRONG AR: All check box: CHECKED - %s; %s check box: UNCHEKED -%s ",
					allStatus, testData.getTransmissionType(), checkboxStatus));
		}

		carsFilterPage.clickOnTransmissionDropdownItem(testData.getTransmissionType());
		carsFilterPage.clickOnSearchButton();
		carsFilterPage.clickOnTransmissionField();

		testLogger.info(String.format("ER: All check box: CHECKED - %s; %s check box: UNCHECKED - %S: ", false,
				testData.getTransmissionType(), true));

		allStatus = carsFilterPage.getTransmissionDropdownAllItemStatus();
		checkboxStatus = carsFilterPage.getTransmissionCheckboxItemStatus(testData.getTransmissionType());

		try {
			Assert.assertFalse(allStatus);
			Assert.assertTrue(checkboxStatus);
			testLogger.info(String.format("AR: All check box: CHECKED - %s; %s check box: UNCHECKED - %s: ", allStatus,
					testData.getTransmissionType(), checkboxStatus));
		} catch (AssertionError e) {
			testLogger.warn(String.format("WRONG AR: All check box: CHECKED - %s; %s check box: UNCHEKED -%s ",
					allStatus, testData.getTransmissionType(), checkboxStatus));
		}

		carsFilterPage.clickOnTransmissionDropdownItem(testData.getTransmissionType());
		carsFilterPage.clickOnSearchButton();
		carsFilterPage.clickOnTransmissionField();

		testLogger.info(String.format("ER: All check box: CHECKED - %s; %s check box: UNCHECKED - %S: ", true,
				testData.getTransmissionType(), false));

		allStatus = carsFilterPage.getTransmissionDropdownAllItemStatus();
		checkboxStatus = carsFilterPage.getTransmissionCheckboxItemStatus(testData.getTransmissionType());

		try {
			Assert.assertTrue(allStatus);
			Assert.assertFalse(checkboxStatus);
			testLogger.info(String.format("AR: All check box: CHECKED - %s; %s check box: UNCHECKED - %s: ", allStatus,
					testData.getTransmissionType(), checkboxStatus));
		} catch (AssertionError e) {
			testLogger.warn(String.format("WRONG AR: All check box: CHECKED - %s; %s check box: UNCHEKED -%s ",
					allStatus, testData.getTransmissionType(), checkboxStatus));
		}
	}
}
