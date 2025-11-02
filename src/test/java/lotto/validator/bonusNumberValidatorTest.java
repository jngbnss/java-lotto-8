package lotto.validator;

import static lotto.utils.Converter.intConverter;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("보너스 넘버 타입 검증")
class bonusNumberValidatorTest {
    @Test
    @DisplayName("정상 숫자 입력 시 보너스 넘버 검증 통과")
    void 정상_입력_보너스_넘버_통과() {
        String input = "1";
        int result = intConverter(input); // Converter에서 검증
        assertThat(result).isEqualTo(1); // 1이 반환되는지 확인
    }

    @ParameterizedTest
    @ValueSource(strings = {"백만원", "abc"})
    @DisplayName("문자예외")
    void 문자_예외(String input) {
        assertThatThrownBy(() -> intConverter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-100", "-1", "0", "46", "100"})
    @DisplayName("범위예외")
    void 범위_예외(String input) {
        assertThatThrownBy(() -> intConverter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
    }
}