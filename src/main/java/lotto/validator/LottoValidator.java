package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.ErrorMessage;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
        checkSort(numbers);
    }

    private static void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private static void checkRange(List<Integer> numbers) {
        for (Integer n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
            }
        }
    }

    private static void checkSort(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) > numbers.get(i)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_SORTED_LOTTO_NUMBER.getMessage());
            }
        }
    }

    // 추후 WinningNumber 입력 검증용 메서드 추가 가능
    public static void validateWinningNumber(List<Integer> numbers) {
        validate(numbers);
    }
}