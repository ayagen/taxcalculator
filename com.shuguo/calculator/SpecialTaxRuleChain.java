package calculator;

import java.util.ArrayList;
import java.util.List;


public class SpecialTaxRuleChain {
	
	
	private List<Tax> chains;
	
	public SpecialTaxRuleChain() {
		chains = new ArrayList<>();
	}
	
	public void addFilter(Tax f) {
		chains.add(f);
	}
	
	public double doFilter(String item, double price) {
		double res = 0;
		for(Tax f : chains) {
			res += f.calculateTax(item, price);
		}
		
		return res;
	}
}
