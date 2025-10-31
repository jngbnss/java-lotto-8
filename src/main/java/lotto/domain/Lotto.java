package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;
    // 여기가 정답인 부분이어야해

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers); // ✅ 여기서 검증
        this.numbers = List.copyOf(numbers);
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
