package taxkata;

import java.math.BigDecimal;

public class FemaleTaxCalculator implements TaxCalculator {
    @Override
    public BigDecimal calculate(int income) {
        if (income <= 1_90_000)
            return new BigDecimal(0);

        return taxCalculator.calculate(income);
    }
}
