import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class IndividualTest {

    TaxCalculator taxCalculator = mock(TaxCalculator.class);
    PayersClassification payersClassification = mock(PayersClassification.class);

    @Before
    public void setUp() {
        when(payersClassification.classify()).thenReturn(taxCalculator);
    }

    @Test
    public void throws_exception_for_unsupported_gender() {
        try {
            new Individual("Joe Doe", "some", 40, 40_000);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("some is not supported gender"));
        }
    }

    @Test
    public void verify_tax_calculator_interactions() {
        Individual individual = new Individual("Joe Doe", 40_000, payersClassification);
        individual.calculateTax();

        verify(taxCalculator).calculate(40_000);
    }

    @Test
    public void individual_tax_calculation() {
        Individual individual = new Individual("Jon Doe", "male", 40, 2_60_000);

        assertThat(individual.calculateTax().doubleValue(), is(26000D));
    }
}
