package taxkata;

import java.math.BigDecimal;

public class MaleTaxCalculator implements TaxCalculator {

    @Override
    public BigDecimal calculate(int income) {
        if (income <= 1_60_000)
            return new BigDecimal(0);

        return taxCalculator.calculate(income);
    }
}
