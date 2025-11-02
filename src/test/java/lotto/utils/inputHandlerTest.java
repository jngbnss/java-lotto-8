package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.PurchaseAmount;
import lotto.validator.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class inputHandlerTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    @DisplayName("공백 또는 탭 입력 예외")
    void 공백_입력_예외(String input) {
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_NULL.getMessage());
    }

}