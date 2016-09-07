import java.math.BigDecimal;

public class SeniorCitizenTaxCalculator implements TaxCalculator {
    @Override
    public BigDecimal calculate(int income) {
        if (income <= 2_40_000)
            return new BigDecimal(0);

        return taxCalculator.calculate(income);
    }
}
