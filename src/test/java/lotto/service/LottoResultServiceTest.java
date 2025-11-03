package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.GenerateLottoNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

class LottoResultServiceTest {

    @Test
    void service_shouldCalculateResultCorrectly() {
        // 1. 테스트용 고정 로또 목록
        List<Lotto> fixedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8))  // 3등
        );

        // 2. GenerateLottoNumbers 테스트용 생성자
        GenerateLottoNumbers generated = new GenerateLottoNumbers(fixedLottos);

        // 3. 체크용 당첨 번호
        LottoChecker checker = new LottoChecker(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
        );

        // 4. 서비스 호출
        LottoResultService service = new LottoResultService();
        LottoResult result = service.calculateResult(generated, checker);

        // 5. 결과 검증
        assertEquals(1, result.getCount(Rank.FIRST));
        assertEquals(1, result.getCount(Rank.SECOND));
        assertEquals(1, result.getCount(Rank.THIRD));
        assertEquals(0, result.getCount(Rank.FOURTH));
        assertEquals(0, result.getCount(Rank.FIFTH));

        // 6. 수익률 계산 테스트
        int purchaseAmount = 3000; // 로또 3개 구입
        double expectedProfitRate = ((double)(
                Rank.FIRST.getPrize() +
                        Rank.SECOND.getPrize() +
                        Rank.THIRD.getPrize()
        ) / purchaseAmount) * 100;

        assertEquals(expectedProfitRate, result.calculateProfitRate(purchaseAmount));
    }
}
