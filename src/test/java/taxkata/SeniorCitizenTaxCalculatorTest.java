package taxkata;

import org.junit.Test;

public class SeniorCitizenTaxCalculatorTest extends AbstractTaxCalculatorTest {

    @Override
    TaxCalculator getTaxCalculator() {
        return new SeniorCitizenTaxCalculator();
    }

    @Test
    public void no_tax_slab() {
        assertCalculation(2_40_000, 0D);
    }

    @Test
    public void slab_10_percent() {
        assertCalculation(2_40_001, 24000.1D);
    }
}