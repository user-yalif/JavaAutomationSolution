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

	public MotorCarsFilterPageTestData() {
		this.defaultPlaceholders = new ArrayList<String>(
				List.of(
						"�����",
						"�����",
						"���� �� (���.)",
						"���� �� (���.)",
						"��� ������� ��",
						"��� ������� ��",
						"������ ��",
						"������ ��",
						"����� ��������� ��",
						"����� ��������� ��",
						"��� ������",
						"��� �������",
						"����",
						"������� �������",
						"��������� ������",
						"���. �����",
						"�����������"
						));
		this.brands = new ArrayList<String>(
				List.of(
						"Audi",
						"BMW",
						"Suzuki",
						"Ford",
						"Toyota",
						"Mazda",
						"Mercedes-Benz"
						));
		this.priceInput = new ArrayList<String>(
				List.of(
						"52000",
						"CharacterS",
						"!@#$%^&*()",
						"12358$%9"
						));
		this.mileageFrom = 100000;
		this.mileageTo = 200000;
	}
}						
