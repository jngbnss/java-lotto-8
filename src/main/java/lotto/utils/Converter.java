package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.validator.BonusNumberValidator;

public class Converter {
    public static Lotto lottoConverter(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers); // ✅ Lotto 내부에서 자동 검증 수행
    }

    // 타입만 검증
    public static int intConverter(String input) {
        return BonusNumberValidator.validateNumber(input); // 숫자 검증

    }
}
