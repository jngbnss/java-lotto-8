package lotto.utils;

import static lotto.validator.ErrorMessage.INPUT_NULL;

import lotto.validator.ErrorMessage;

public class inputHandler {
    public static String emptyCheck(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getMessage());
        }
        return input.trim();
    }
}
