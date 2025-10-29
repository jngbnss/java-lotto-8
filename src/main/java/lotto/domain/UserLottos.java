package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLottos {
    private static final int MIN_COUNT = 1;   // 최소 구매 가능 개수
    private static final int MAX_COUNT = 100; // 최대 구매 가능 개수
    private static final int LOTTO_SIZE = 6;  // 한 장당 숫자 개수
    private static final int MIN_NUMBER = 1;  // 숫자 최소값
    private static final int MAX_NUMBER = 45; // 숫자 최대값

    private final List<Lotto> lottos;

    // 생성자에서 count만 받아서 내부에서 랜덤 로또 생성
    public UserLottos(int count) {
        validateCount(count);
        this.lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            this.lottos.add(new Lotto(numbers));
        }
    }

    private void validateCount(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 개수는 최소 " + MIN_COUNT + "개 이상이어야 합니다.");
        }
        if (count > MAX_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또는 최대 " + MAX_COUNT + "개까지만 구매할 수 있습니다.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    @Test
    @DisplayName("로또 구매 개수가 1개일 때도 정상적으로 생성된다")
    void count가_1일때_정상() {
        UserLottos userLottos = new UserLottos(1);
        assertThat(userLottos.getLottos()).hasSize(1);
    }
    @Test
    @DisplayName("로또 구매 개수가 100개일 때도 정상적으로 생성된다")
    void count가_100일때_정상() {
        UserLottos userLottos = new UserLottos(100);
        assertThat(userLottos.getLottos()).hasSize(100);
    }

}
