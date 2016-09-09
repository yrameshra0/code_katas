package taxkata;

import java.math.BigDecimal;

public interface TaxCalculator {
    CommonTaxCalculator taxCalculator = new CommonTaxCalculator();

    BigDecimal calculate(int income);
}
