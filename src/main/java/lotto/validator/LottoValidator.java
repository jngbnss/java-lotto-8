package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
    }
    public static void validateWinningNumber(String winningNumbersInput) {

    }

    private static void checkSort(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if(numbers.get(i-1)>numbers.get(i)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 오름차순이어야 합니다.");
            }
        }
    }

    private static void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    private static void checkRange(List<Integer> numbers) {
        for (Integer n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45입니다.");
            }
        }
    }
}