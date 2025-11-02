package lotto.validator;

public class BonusNumberValidator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static int validateNumber(String input) {
        int value;
        try {
            value = Integer.parseInt(input); // 숫자 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }

        // 범위 검증
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
        }

        return value;
    }
}
