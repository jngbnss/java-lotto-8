package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.GenerateLottoNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoResult;
import lotto.domain.LottoResultDto;
import lotto.domain.Rank;

public class LottoResultService {

    // 1️⃣ 로또 결과 계산
    public LottoResult calculateResult(GenerateLottoNumbers generatedNumbers, LottoChecker checker) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : generatedNumbers.getRandomlyGeneratedLotteries()) {
            Rank rank = checker.match(lotto);
            result.addResult(rank);
        }
        return result;
    }

    // 2️⃣ DTO 변환 (수익률 포함)
    public List<LottoResultDto> toDtoList(LottoResult lottoResult, int purchaseAmount) {
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        List<LottoResultDto> dtos = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE || rank.getMatchCount() < 3) continue;
            dtos.add(new LottoResultDto(
                    rank.getMatchCount(),
                    rank.isBonus(),
                    rank.getPrize(),
                    lottoResult.getCount(rank),
                    profitRate
            ));
        }
        return dtos;
    }
}
