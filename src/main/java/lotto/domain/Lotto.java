package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;
    // 여기가 정답인 부분이어야해

    public Lotto(List<Integer> inputNumbers) {

        LottoValidator.validate(inputNumbers);
        this.numbers = inputNumbers;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
