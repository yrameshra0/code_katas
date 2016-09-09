package taxkata;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class Individual {
    private final String name;
    private final int income;
    private final TaxCalculator taxCalculator;

    public Individual(String name, int income, PayersClassification payersClassification) {
        this.name = name;
        this.income = income;
        taxCalculator = payersClassification.classify();
    }

    public Individual(String name, String gender, int age, int income) {
        this(name, income, new PayersClassification(age, Gender.transform(gender)));
    }

    public BigDecimal calculateTax() {
        return taxCalculator.calculate(income);
    }

    public enum Gender {
        MALE("male"),
        FEMALE("female");

        private final String genderId;

        Gender(String genderId) {
            this.genderId = genderId;
        }

        public static Gender transform(String genderId) {
            return Stream.of(Gender.values())
                    .filter(gender -> genderId.toLowerCase().equals(gender.genderId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException(genderId + " is not supported gender"));
        }
    }
}
