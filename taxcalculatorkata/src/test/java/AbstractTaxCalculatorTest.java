import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;

import java.math.BigDecimal;

public abstract class AbstractTaxCalculatorTest {
    abstract TaxCalculator getTaxCalculator();

    public void assertCalculation(int income, double expectedTax) {
        assertThat(getTaxCalculator().calculate(income), is(closeTo(new BigDecimal(expectedTax), new BigDecimal(0.1))));
    }
}
