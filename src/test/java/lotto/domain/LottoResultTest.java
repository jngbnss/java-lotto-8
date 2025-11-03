package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    @DisplayName("로또 등수 별로 당첨자수 및 수익률 계산 테스트")
    void lottoResult_shouldCalculateProfitRate() {
        LottoResult result = new LottoResult();
        result.addResult(Rank.FIRST);   // 1등 1개
        result.addResult(Rank.THIRD);   // 3등 1개

        int purchaseAmount = 2000;
        long expectedPrize = Rank.FIRST.getPrize() + Rank.THIRD.getPrize();
        double expectedRate = ((double) expectedPrize / purchaseAmount) * 100;

        assertEquals(1, result.getCount(Rank.FIRST));
        assertEquals(1, result.getCount(Rank.THIRD));
        assertEquals(expectedRate, result.calculateProfitRate(purchaseAmount));
    }

}