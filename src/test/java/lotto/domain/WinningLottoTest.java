package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.validator.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLotto 테스트")
class WinningLottoTest {
    @Test
    @DisplayName("정상적으로 WinningLotto 생성")
    void 정상_생성() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        assertThat(winningLotto.getWinningNumbers().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    void 보너스_중복_예외() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 3; // 당첨 번호와 중복
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_NOT_DUPLICATE.getMessage());
    }
}
