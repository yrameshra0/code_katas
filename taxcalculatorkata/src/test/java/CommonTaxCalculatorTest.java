import org.junit.Test;

/**
 * Created by yrameshrao on 11/05/16.
 */
public class CommonTaxCalculatorTest extends AbstractTaxCalculatorTest {

    @Override
    TaxCalculator getTaxCalculator() {
        return new CommonTaxCalculator();
    }

    @Test
    public void slab_10_percent() {
        assertCalculation(3_00_000, 30000.0D);
    }

    @Test
    public void slab_20_percent() {
        assertCalculation(3_00_001, 60000.2D);
        assertCalculation(5_00_000, 100000D);
    }

    @Test
    public void slab_30_percent() {
        assertCalculation(5_00_001, 150000.2D);
    }
}