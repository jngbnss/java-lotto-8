package lotto.validator;

import static lotto.validator.PurchaseValidator.validateAmount;
import static lotto.validator.utilValidator.validateNumber;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class utilValidatorTest {
    @Test
    void 한글_입력시_예외() {
        assertThatThrownBy(() -> validateNumber("백만원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 숫자아닌값_입력시_예외() {
        assertThatThrownBy(() -> {
            try {
                validateNumber("백만원");
            } catch (NumberFormatException e) {
                System.out.println("예외 메시지: " + e.getMessage()); // 콘솔에 출력
                throw e; // 예외 다시 던져서 assertThatThrownBy 검증
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만");
    }

    @Test
    void 숫자아닌값_입력시_예외2() {
        assertThatThrownBy(() -> {
            try {
                validateNumber(null);
            } catch (NumberFormatException e) {
                System.out.println("예외 메시지: " + e.getMessage()); // 콘솔에 출력
                throw e; // 예외 다시 던져서 assertThatThrownBy 검증
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만");
    }
    @Test
    void 숫자아닌값_입력시_예외3() {
        assertThatThrownBy(() -> {
            try {
                validateNumber(" ");
            } catch (NumberFormatException e) {
                System.out.println("예외 메시지: " + e.getMessage()); // 콘솔에 출력
                throw e; // 예외 다시 던져서 assertThatThrownBy 검증
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만");
    }
    @Test
    void 숫자아닌값_입력시_예외4() {
        assertThatThrownBy(() -> {
            try {
                validateNumber("abc");
            } catch (NumberFormatException e) {
                System.out.println("예외 메시지: " + e.getMessage()); // 콘솔에 출력
                throw e; // 예외 다시 던져서 assertThatThrownBy 검증
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만");
    }
}