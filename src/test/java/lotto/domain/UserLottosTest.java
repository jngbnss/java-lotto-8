package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottosTest {
    @Test
    @DisplayName("정상 랜덤번호 6개 저장")
    void 랜덤번호_6개_숫자가_정상적으로_저장되는지() {
        int count = 5; // 예시: 5개의 로또 생성
        UserLottos userLottos = new UserLottos(count);

        // 구매한 개수 확인
        assertThat(userLottos.getLottos().size()).isEqualTo(count);

        for (Lotto lotto : userLottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();

            // 6개의 숫자가 있는지
            assertThat(numbers).hasSize(6);

            // 중복 없는지 확인
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            assertThat(uniqueNumbers.size()).isEqualTo(6);

            // 1~45 범위 확인
            for (int num : numbers) {
                assertThat(num).isBetween(1, 45);
            }

            // 오름차순 확인
            for (int i = 0; i < numbers.size() - 1; i++) {
                assertThat(numbers.get(i)).isLessThan(numbers.get(i + 1));
            }
        }
    }

    @Test
    @DisplayName("count가 0 이하일 때")
    void count가_0이하_일때_예외() {
        assertThatThrownBy(() -> new UserLottos(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1개 이상");
    }

    @Test
    @DisplayName("count가 0 일 때")
    void count가_0일때() {
        UserLottos userLottos = new UserLottos(1);
        assertThat(userLottos.getLottos()).hasSize(1);
    }

    @Test
    @DisplayName("count가 100 일 때")
    void count가_100일때() {
        UserLottos userLottos = new UserLottos(100);
        assertThat(userLottos.getLottos()).hasSize(100);
    }

    @Test
    @DisplayName("count가 0 이하일 때")
    void count가_100초과_일때_예외() {
        assertThatThrownBy(() -> new UserLottos(110))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("100개");
    }
    @Test
    @DisplayName("음수 count 입력 시 예외")
    void 음수_count_예외() {
        assertThatThrownBy(() -> new UserLottos(-5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1개 이상");
    }

}