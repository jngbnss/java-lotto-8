package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);

    public LottoResult(UserLottos userLottos, LottoChecker checker) {


        //초기화
        for (Rank rank : Rank.values()) {
            results.put(rank,0);
        }

        //결과 집계
        for (Lotto userLotto : userLottos.getLottos()) {
            Rank rank = checker.match(userLotto);
            results.put(rank,results.get(rank)+1);

        }
    }


    public int getCount(Rank rank) {
        return results.get(rank);
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = results.entrySet().stream()
                .mapToLong(e -> (long) e.getKey().getPrize() * e.getValue())
                .sum();
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }
}
