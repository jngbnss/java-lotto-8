package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers); // ✅ 여기서 검증
        this.numbers = List.copyOf(numbers); // 불변 리스트
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
