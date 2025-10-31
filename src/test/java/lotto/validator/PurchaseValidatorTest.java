package lotto.validator;

import static lotto.validator.PurchaseValidator.validateAmount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

class PurchaseValidatorTest {
    @Test
    void 천원단위아닌값_입력시_예외() {
        assertThatThrownBy(() -> {
            try {
                validateAmount(1500);
            } catch (IllegalArgumentException e) {
                System.out.println("예외 메시지: " + e.getMessage()); // 콘솔에 출력
                throw e; // 예외 다시 던져서 assertThatThrownBy 검증
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위");
    }


    @Test
    void 숫자아닌값_입력시_예외() {
        assertThatThrownBy(() -> {
            try {
                validateAmount(0);
            } catch (IllegalArgumentException e) {
                System.out.println("예외 메시지: " + e.getMessage()); // 콘솔에 출력
                throw e; // 예외 다시 던져서 assertThatThrownBy 검증
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000");
    }

    @Test
    void 음수_금액_입력시_예외() {
        assertThatThrownBy(() -> validateAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다 커야");
    }

    @Test
    void 너무_큰_금액_입력시_예외() {
        assertThatThrownBy(() -> validateAmount(200_000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("십만원");
    }



//    @Test
//    void 정상_입력() {
//        InputView inputView = new TestInputView("3000");
//
//        int amount = inputView.inputPurchaseAmount();
//        assertThat(amount).isEqualTo(3000);
//    }

}