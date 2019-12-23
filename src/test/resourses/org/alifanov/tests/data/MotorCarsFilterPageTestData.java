package org.alifanov.tests.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class MotorCarsFilterPageTestData {

	public List<String> defaultPlaceholders;
	private @Getter List<String> brands;
	private @Getter List<String> priceInput;;
	private @Getter int mileageFrom;
	private @Getter int mileageTo;
	private @Getter String sMileageFrom;
	private @Getter String sMileageTo;
	private @Getter String priceFrom;
	private @Getter String priceTo;
	private @Getter String transmissionType;

	public MotorCarsFilterPageTestData() {
		defaultPlaceholders = new ArrayList<String>(
				List.of(
						"Марка",
						"Район",
						"Цена от (грн.)",
						"Цена до (грн.)",
						"Год выпуска от",
						"Год выпуска до",
						"Пробег от",
						"Пробег до",
						"Объем двигателя от",
						"Объем двигателя до",
						"Тип кузова",
						"Вид топлива",
						"Цвет",
						"Коробка передач",
						"Состояние машины",
						"Доп. опции",
						"Растаможена"
						));
		brands = new ArrayList<String>(
				List.of(
						"Audi",
						"BMW",
						"Suzuki",
						"Ford",
						"Toyota",
						"Mazda",
						"Mercedes-Benz"
						));
		priceInput = new ArrayList<String>(
				List.of(
						"52000",
						"CharacterS",
						"!@#$%^&*()",
						"12358$%9"
						));
		mileageFrom = 100000;
		mileageTo = 200000;
		sMileageFrom = "100 000 км";
		sMileageTo = "200 000 км";
		priceFrom = "100 000 грн.";
		priceTo = "500 000 грн.";
		transmissionType = "Вариатор";
	}
}						
