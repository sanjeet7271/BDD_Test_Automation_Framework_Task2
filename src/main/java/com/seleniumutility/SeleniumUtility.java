package com.seleniumutility;

import java.util.Random;

public class SeleniumUtility {

	public int getRandomNumberUsingNextInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}
}
