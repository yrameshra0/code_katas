package taxkata;

import org.junit.Test;

public class MaleTaxCalculatorTest extends AbstractTaxCalculatorTest {

    @Override
    TaxCalculator getTaxCalculator() {
        return new MaleTaxCalculator();
    }

    @Test
    public void no_tax_slab() {
        assertCalculation(1_60_000, 0D);
    }

    @Test
    public void slab_10_percent() {
        assertCalculation(1_60_001, 16000.1D);
    }
}