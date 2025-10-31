package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenerateLottoNumbersTest {
    @Test
    @DisplayName("정상 랜덤번호 6개 저장")
    void 랜덤번호_6개_숫자가_정상적으로_저장되는지() {
        int count = 5; // 예시: 5개의 로또 생성
        GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers(count);

        // 구매한 개수 확인
        assertThat(generateLottoNumbers.getNumbers().size()).isEqualTo(count);

        for (Lotto lotto : generateLottoNumbers.getNumbers()) {
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
        assertThatThrownBy(() -> new GenerateLottoNumbers(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1개 이상");
    }

    @Test
    @DisplayName("count가 0 일 때")
    void count가_0일때() {
        GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers(1);
        assertThat(generateLottoNumbers.getNumbers()).hasSize(1);
    }

    @Test
    @DisplayName("count가 100 일 때")
    void count가_100일때() {
        GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers(100);
        assertThat(generateLottoNumbers.getNumbers()).hasSize(100);
    }

    @Test
    @DisplayName("count가 0 이하일 때")
    void count가_100초과_일때_예외() {
        assertThatThrownBy(() -> new GenerateLottoNumbers(110))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("100개");
    }
    @Test
    @DisplayName("음수 count 입력 시 예외")
    void 음수_count_예외() {
        assertThatThrownBy(() -> new GenerateLottoNumbers(-5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1개 이상");
    }

    @Test
    @DisplayName("로또 번호 중복 없음")
    void 로또_번호_중복_검증() {
        GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers(5);
        for (Lotto lotto : generateLottoNumbers.getNumbers()) {
            Set<Integer> unique = new HashSet<>(lotto.getNumbers());
            assertThat(unique.size()).isEqualTo(6);
        }
    }

    @Test
    @DisplayName("로또 번호 오름차순 확인")
    void 로또_번호_오름차순() {
        GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers(5);
        for (Lotto lotto : generateLottoNumbers.getNumbers()) {
            List<Integer> numbers = lotto.getNumbers();
            for (int i = 0; i < numbers.size() - 1; i++) {
                assertThat(numbers.get(i)).isLessThan(numbers.get(i + 1));
            }
        }
    }

    @Test
    @DisplayName("로또 번호 1~45 범위 확인")
    void 로또_번호_범위() {
        GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers(5);
        for (Lotto lotto : generateLottoNumbers.getNumbers()) {
            for (int n : lotto.getNumbers()) {
                assertThat(n).isBetween(1, 45);
            }
        }
    }


}