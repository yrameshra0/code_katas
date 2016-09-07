import org.junit.Test;

public class FemaleTaxCalculatorTest extends AbstractTaxCalculatorTest {

    @Override
    TaxCalculator getTaxCalculator() {
        return new FemaleTaxCalculator();
    }

    @Test
    public void no_tax_slab() {
        assertCalculation(1_90_000, 0D);
    }

    @Test
    public void slab_10_percent() {
        assertCalculation(1_90_001, 19000.1D);
    }
}