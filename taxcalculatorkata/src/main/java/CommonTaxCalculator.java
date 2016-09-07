import java.math.BigDecimal;

public class CommonTaxCalculator implements TaxCalculator {
    @Override
    public BigDecimal calculate(int income) {
        if (income <= 3_00_000)
            return new BigDecimal(0.1 * income);

        else if (income <= 5_00_000)
            return new BigDecimal(0.2 * income);

        else
            return new BigDecimal(0.3 * income);
    }
}
