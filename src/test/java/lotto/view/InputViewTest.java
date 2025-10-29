package lotto.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    // 상속과 오버라이드를 이용한 테스트용 입력 주입
    // 테스트용 InputView 클래스
    static class TestInputView extends InputView {
        private final String input;

        public TestInputView(String input) {
            this.input = input;
        }

        @Override
        protected String readLine() {
            return input; // 테스트용 입력 반환
        }
    }

    @Test
    void 숫자아닌값_입력시_예외() {
        InputView inputView = new TestInputView("abc");

        assertThatThrownBy(inputView::inputPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다");
    }

    @Test
    void 천원단위아닌값_입력시_예외() {
        InputView inputView = new TestInputView("1500");

        assertThatThrownBy(inputView::inputPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위");
    }

    @Test
    void 정상_입력() {
        InputView inputView = new TestInputView("3000");

        int amount = inputView.inputPurchaseAmount();
        assertThat(amount).isEqualTo(3000);
    }
}
