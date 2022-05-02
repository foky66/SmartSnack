package hu.smart_snack.validation;

public class AmountValidation {
    private static final int MAX_AMOUNT = 20;
    private static final int MIN_AMOUNT = 1;

    public void validate(int amount){
        if(amount < 1 || amount > 20){
            throw new IllegalArgumentException("The amount must be between " + MIN_AMOUNT + " - " + MAX_AMOUNT);
        }

    }
}
