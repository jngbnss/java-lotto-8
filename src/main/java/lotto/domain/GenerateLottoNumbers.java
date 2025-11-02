package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.LottoCountsValidator;

public class GenerateLottoNumbers {
    private static final int LOTTO_SIZE = 6;  // 한 장당 숫자 개수
    private static final int MIN_NUMBER = 1;  // 숫자 최소값
    private static final int MAX_NUMBER = 45; // 숫자 최대값

    private final List<Lotto> randomlyGeneratedLotteries;

    public GenerateLottoNumbers(int count) {
        LottoCountsValidator.validateCount(count); // 공통 validator 사용
        this.randomlyGeneratedLotteries = generateLottos(count); // 랜덤 생성
    }

    private List<Lotto> generateLottos(int count) {

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER,
                            LOTTO_SIZE)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottos.add(new Lotto(numbers)); // 검증진행
        }
        return lottos;
    }


    public List<Lotto> getRandomlyGeneratedLotteries() {
        return randomlyGeneratedLotteries;
    }

}
