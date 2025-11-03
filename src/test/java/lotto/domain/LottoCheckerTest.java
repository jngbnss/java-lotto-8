package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {
    @Test
    @DisplayName("로또 등수 테스트")
    void 등수_테스트() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        LottoChecker checker = new LottoChecker(winningLotto, bonusNumber);

        // 1등
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(checker.match(lotto1)).isEqualTo(Rank.FIRST);

        // 2등
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(checker.match(lotto2)).isEqualTo(Rank.SECOND);

        // 3등
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(checker.match(lotto3)).isEqualTo(Rank.THIRD);

        // 4등
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        assertThat(checker.match(lotto4)).isEqualTo(Rank.FOURTH);

        // 5등
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(checker.match(lotto5)).isEqualTo(Rank.FIFTH);

        // 낙첨
        Lotto lottoNone = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        assertThat(checker.match(lottoNone)).isEqualTo(Rank.NONE);
    }


}