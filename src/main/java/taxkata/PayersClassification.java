package taxkata;

public class PayersClassification {
    private final int age;
    private final Individual.Gender gender;

    public PayersClassification(int age, Individual.Gender gender) {
        this.age = age;
        this.gender = gender;
    }

    public TaxCalculator classify() {
        if (gender == Individual.Gender.MALE) {
            if (age < 60)
                return new MaleTaxCalculator();
            else
                return new SeniorCitizenTaxCalculator();
        }
        else {
            if (age < 58)
                return new FemaleTaxCalculator();
            else
                return new SeniorCitizenTaxCalculator();
        }
    }
}
