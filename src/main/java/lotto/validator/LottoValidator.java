package lotto.validator;

import lotto.domain.ErrorMessage;

public class LottoValidator {
    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 100;


    public static void validateCount(int count) {
        if (count < MIN_COUNT || count > MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
    }
}