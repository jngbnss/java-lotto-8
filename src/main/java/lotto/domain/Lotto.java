package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    // 여기가 정답인 부분이어야해

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        duplicateValidate(numbers); // 여기에 호출 추가
    }

    // TODO: 추가 기능 구현
    //중복방지
    private void duplicateValidate(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numbers.size()!=numberSet.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
