package calculator;

public class ImportedTax implements Tax {
	
	private double rate = 0.2;
	@Override
	public boolean match(String item) {
		return item.contains("Imported");
	}
	
	@Override
	public double calculateTax(String item, double price) {
		return match(item) ? price * rate : 0;
	}

}
