//package lotto;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.*;
//
//import lotto.view.InputView;
//import org.junit.jupiter.api.Test;
//
//class PurchaseValidatorTest {
//    @Test
//    void 숫자아닌값_입력시_예외() {
//        InputView inputView = new TestInputView("abc");
//
//        assertThatThrownBy(inputView::inputPurchaseAmount)
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("숫자만 입력 가능합니다");
//    }
//
//    @Test
//    void 천원단위아닌값_입력시_예외() {
//        InputView inputView = new TestInputView("1500");
//
//        assertThatThrownBy(inputView::inputPurchaseAmount)
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("1000원 단위");
//    }
//
//    @Test
//    void 정상_입력() {
//        InputView inputView = new TestInputView("3000");
//
//        int amount = inputView.inputPurchaseAmount();
//        assertThat(amount).isEqualTo(3000);
//    }
//}