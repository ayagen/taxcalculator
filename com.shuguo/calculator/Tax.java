package calculator;

public interface Tax {
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean match(String name);
	
	/**
	 * 
	 * @param name
	 * @param price
	 * @return
	 */
	public double calculateTax(String name, double price);
}
