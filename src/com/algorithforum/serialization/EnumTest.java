package com.algorithforum.serialization;

import java.io.Serializable;

enum Day {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

public class EnumTest {
	public static void main(String[] args) {
		Day day = Day.MONDAY;
		String isSerializable = "Not Serializable";

		if (day instanceof Serializable) {
			isSerializable = "Serializable";
		}

		System.out.println(isSerializable);
	}
}
