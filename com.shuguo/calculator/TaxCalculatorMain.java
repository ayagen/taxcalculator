package calculator;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorMain {
	
	public static final double ROUND_UP_FACTOR = 20.0;
	
	public static void main(String[] args) {
		SpecialTaxRuleChain chain = new SpecialTaxRuleChain();
		
		Tax importedTax = new ImportedTax();
		Tax foodTax = new FoodTax();
		Tax entertainTax = new EntertainmentTax();
		//If we have more different kinds of Tax rate, add a new class which implements the Tax interface
		chain.addFilter(importedTax);
		chain.addFilter(foodTax);
		chain.addFilter(entertainTax);
		
		//Here is some examples of the products
		List<Product> products = new ArrayList<>();
		products.add(new Product("Imported chocolate", 3, 2));
		products.add(new Product("water", 4, 3));
		products.add(new Product("Imported rice", 5, 4)); 
		
		
		double totalTax = 0;
		for(Product item : products) {
			double taxes = round(item.getQuantity() * chain.doFilter(item.getName(), item.getPrice()));
			System.out.println("Tax for " + item.getName() + ": " + taxes);
			totalTax += taxes;
		}
		System.out.println("Total tax: " + totalTax);
	}
	
	private static double round(double price) {
		return Math.round(price * ROUND_UP_FACTOR) / ROUND_UP_FACTOR;
	}
}
