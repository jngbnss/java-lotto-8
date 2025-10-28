package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public String makeNumbers(){
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        integers.sort(Comparator.naturalOrder());
        // 리스트를 문자열로 변환하고 ,로 연결
        String randomNumbers = integers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return randomNumbers;
    }
}
