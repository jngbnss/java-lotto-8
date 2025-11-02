package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구매금액 테스트")
class PurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000", "100000"})
    @DisplayName("구매 정상 입력 테스트")
    void 정상_입력_테스트(String input) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(input);
        int expected = Integer.parseInt(input);

        assertThat(purchaseAmount.getValue()).isEqualTo(expected);
    }
//     입력 공백은 인풋핸들러로 옮김
//    @ParameterizedTest
//    @ValueSource(strings = {"", " ", "\t"})
//    @DisplayName("공백 또는 탭 입력 예외")
//    void 공백_입력_예외(String input) {
//        assertThatThrownBy(() -> new PurchaseAmount(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ErrorMessage.INPUT_NULL.getMessage());
//    }

    @Test
    @DisplayName("null 입력 예외")
    void null_입력_예외() {
        assertThatThrownBy(() -> new PurchaseAmount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_NULL.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"천원", "abc", "4dollar"})
    @DisplayName("0이하 입력 예외")
    void 숫자_아닌_입력(String input) {
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-1000", "-10000"})
    @DisplayName("0이하 입력 예외")
    void 가격0_이하_입력(String input) {
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEGATIVE_OR_ZERO_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "2500", "3333", "9999"})
    @DisplayName("1000원단위가아닐때")
    void 구매가격_1000원_단위_예외(String input) {
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_UNIT_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "500", "999"})
    @DisplayName("1000원이하")
    void 구매가격_1000원_이하_예외(String input) {
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MINIMUM_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"101000", "500000", "900000"})
    @DisplayName("최대 10만원초과")
    void 최대구매가격_10만원_초과_예외(String input) {
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MAXIMUM_AMOUNT.getMessage());
    }


}