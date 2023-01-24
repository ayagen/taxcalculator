package calculator;

import java.util.Arrays;
import java.util.List;

public class EntertainmentTax implements Tax {

	private static final List<String> ENTERTAINMENT = Arrays.asList(new String[] {"music", "film", "tape"});
	private double rate = 0.2;
	
	@Override
	public boolean match(String item) {
		for(String f : ENTERTAINMENT) {
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
