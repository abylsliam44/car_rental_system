package billing;

import java.util.HashMap;
import java.util.Map;

public class DiscountInterpreter {
    private Map<String, Boolean> discountRules = new HashMap<>();

    public DiscountInterpreter() {
        discountRules.put("holiday_discount", true); // Example rule
        discountRules.put("long_term_rental", false);
    }

    public boolean interpret(String rule, Customer customer) {
        if (discountRules.containsKey(rule)) {
            return discountRules.get(rule) && customer.getRentalDays() > 10;
        }
        return false;
    }
}
