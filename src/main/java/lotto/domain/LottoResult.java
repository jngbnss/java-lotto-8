package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);

    public LottoResult() {
        //초기화
        initializeResults();
    }

    private void initializeResults() {
        //초기화
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    // 당첨 결과 추가
    public void addResult(Rank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return results.get(rank);
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = results.entrySet().stream()
                .mapToLong(e ->
                        (long) e.getKey().getPrize() * e.getValue())
                .sum();
        // 현재 필드에 있는 키(FIRST)의 상금 * 현재 필드에 있는 벨류(당첨자 수)를 더하기
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }
}
