package lotto.service;

import lotto.domain.GenerateLottoNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class LottoResultService {
    // 로또 결과 계산
    public LottoResult calculateResult(GenerateLottoNumbers generatedNumbers, LottoChecker checker) {
        LottoResult result = new LottoResult();

        for (Lotto lotto : generatedNumbers.getRandomlyGeneratedLotteries()) {
            Rank rank = checker.match(lotto);
            result.addResult(rank);
        }

        return result;
    }
}
