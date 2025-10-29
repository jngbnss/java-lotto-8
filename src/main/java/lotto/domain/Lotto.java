package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        // inputNumbers가 불변일 수 있으므로 새 ArrayList로 복사
        List<Integer> numbersCopy = new ArrayList<>(inputNumbers);
        Collections.sort(numbersCopy);

        this.numbers = numbersCopy;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
