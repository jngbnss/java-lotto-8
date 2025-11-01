package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.LottoValidator;

public class GenerateLottoNumbers {
    private static final int MIN_COUNT = 1;   // 최소 구매 가능 개수
    private static final int MAX_COUNT = 100; // 최대 구매 가능 개수
    private static final int LOTTO_SIZE = 6;  // 한 장당 숫자 개수
    private static final int MIN_NUMBER = 1;  // 숫자 최소값
    private static final int MAX_NUMBER = 45; // 숫자 최대값

    private final List<Lotto> numbers;

    // 생성자에서 count만 받아서 내부에서 랜덤 로또 생성
    public GenerateLottoNumbers(int count) {
        validateCount(count); // 여기서 검증하는 거는 괜찮음
        this.numbers = generateLottos(count);
    }

    private List<Lotto> generateLottos(int count) {

        List<Lotto>lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottos.add(new Lotto(numbers)); // 검증진행
        }
        return lottos;
    }

    private void validateCount(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 개수는 최소 " + MIN_COUNT + "개 이상이어야 합니다.");
        }
        if (count > MAX_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또는 최대 " + MAX_COUNT + "개까지만 구매할 수 있습니다.");
        }
    }

    public List<Lotto> getNumbers() {
        return numbers;
    }

}
