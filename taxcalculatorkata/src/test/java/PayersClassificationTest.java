import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;

public class PayersClassificationTest {
    @Test
    public void returns_male_tax_calculator() {
        assertClassification(40, Individual.Gender.MALE, MaleTaxCalculator.class);
    }

    @Test
    public void returns_female_tax_calculator() {
        assertClassification(40, Individual.Gender.FEMALE, FemaleTaxCalculator.class);
    }

    @Test
    public void returns_senior_tax_calculator() {
        assertClassification(60, Individual.Gender.MALE, SeniorCitizenTaxCalculator.class);
        assertClassification(58, Individual.Gender.FEMALE, SeniorCitizenTaxCalculator.class);
    }

    private void assertClassification(int age, Individual.Gender gender, Class calculatorClass) {
        TaxCalculator calculator = new PayersClassification(age, gender).classify();

        assertThat(calculator, new InstanceOf(calculatorClass));
    }
}