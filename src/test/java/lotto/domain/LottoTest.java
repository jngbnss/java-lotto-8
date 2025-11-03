package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static lotto.validator.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("Lotto 도메인 테스트")
class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @Test
    @DisplayName("정상 로또 번호 입력 시 객체 생성")
    void 정상_로또_생성() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).containsExactlyElementsOf(numbers);
    }

    // 다른 테스트 문법으로도 진행 // 학습용
    @ParameterizedTest
    @MethodSource("provideValidLottoNumbers")
    @DisplayName("정상 로또 번호 입력 시 객체 생성")
    void 정상_로또_생성(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).containsExactlyElementsOf(numbers);
    }

    private static Stream<List<Integer>> provideValidLottoNumbers() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(40, 41, 42, 43, 44, 45)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidSizeLottoNumbers")
    @DisplayName("로또 번호가 6개가 아닐때")
    void 로또_사이즈_예외_6개가_아닐때(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_SIZE.getMessage());
    }

    private static Stream<List<Integer>> provideInvalidSizeLottoNumbers() {
        return Stream.of(
                List.of(1),
                List.of(1, 2, 3, 4, 5), //5개 // 서로 다른 로또에서 발행되어서 1이 중복이 되어도 문제없음
                List.of(6, 7, 8, 9, 10, 11, 12), //7개
                List.of(35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45) // 11
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDuplicateLottoNumbers")
    @DisplayName("로또 번호 안에서 중복이 있을 때")
    void 로또_번호_안에서_중복이_있는_예외(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    private static Stream<List<Integer>> provideInvalidDuplicateLottoNumbers() {
        return Stream.of(
                List.of(1, 1, 1, 1, 1, 1), // 모든 숫자가 동일 (6개 중복)
                List.of(1, 1, 2, 3, 4, 5), // 1이 2개 중복, 나머지 단일
                List.of(1, 1, 1, 2, 2, 3), // 1이 3개, 2가 2개 중복
                List.of(1, 1, 1, 2, 2, 2), // 1이 3개, 2가 3개 중복
                List.of(1, 1, 2, 2, 3, 3), // 1, 2, 3이 각각 2개씩 중복 (3쌍)
                List.of(2, 2, 2, 2, 3, 4), // 2가 4개, 나머지 단일
                List.of(2, 2, 3, 3, 4, 4)  // 2, 3, 4가 각각 2개씩 중복 (3쌍)
        );
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외 발생")
    void 로또_번호_범위_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidRangeLottoNumbers")
    @DisplayName("로또 번호가 범위 밖일 때")
    void 로또_번호가_범위_밖일_때(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
    }

    private static Stream<List<Integer>> provideInvalidRangeLottoNumbers() {
        return Stream.of(
                List.of(-1, 2, 3, 4, 5, 6),       // 음수 포함 (-1)
                List.of(0, 1, 2, 3, 4, 5),        // 0 포함 (1보다 작음)
                List.of(1, 2, 3, 4, 5, 46),       // 45 초과 (46)
                List.of(10, 20, 30, 40, 50, 60),  // 여러 숫자가 범위 초과 (50,60)
                List.of(-10, -5, 1, 2, 3, 4),     // 음수 여러개 (-10, -5)
                List.of(100, 200, 3, 4, 5, 6)     // 큰수 여러개 (100,200)
        );
    }

    // 오름차순으로 만든 리스트가 로또로 가서 검증을 진행하기 때문에
    // 오름차순이 아닌 리스트가 들어가면 예외 발생
    @Test
    @DisplayName("로또 번호가 오름차순이 아니면 예외 발생")
    void 로또_번호_오름차순_아니면_예외() {
        List<Integer> numbers = List.of(6, 3, 1, 5, 2, 4); // 섞인 순서
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_SORTED_LOTTO_NUMBER.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideNotSortedLottoNumbers")
    @DisplayName("로또 번호가 오름차순이 아니면 예외 발생")
    void 로또_번호_정렬_예외(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_SORTED_LOTTO_NUMBER.getMessage());
    }

    private static Stream<List<Integer>> provideNotSortedLottoNumbers() {
        return Stream.of(
                List.of(6, 3, 1, 5, 2, 4),
                List.of(45, 40, 35, 30, 25, 20),
                List.of(2, 1, 4, 3, 6, 5)
        );
    }

}
