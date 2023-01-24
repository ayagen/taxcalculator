package calculator;

import java.util.Arrays;
import java.util.List;

public class FoodTax implements Tax {

	private static final List<String> FOODS = Arrays.asList(new String[] {"rice", "meat", "egg", "chocolate", "water"});
	private double rate = 0.2;
	
	@Override
	public boolean match(String item) {
		for(String f : FOODS) {
			if(item.contains(f)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public double calculateTax(String item, double price) {
		return match(item) ? price * rate : 0;
	}

}
