package lotto.validator;

public class PurchaseAmountValidator {

    private static final int MIN_AMOUNT = 1000;
    private static final int MAX_AMOUNT = 100_000;

    public static int validateAndParse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getMessage());
        }
        int value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }

        if (value <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_OR_ZERO_AMOUNT.getMessage());
        }
        if (value < MIN_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_AMOUNT.getMessage());
        }
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT_AMOUNT.getMessage());
        }
        if (value > MAX_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.MAXIMUM_AMOUNT.getMessage());
        }

        return value;
    }
}
