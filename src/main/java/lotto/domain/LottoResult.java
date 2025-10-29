//package lotto.domain;
//
//import java.util.ArrayList;
//import java.util.EnumMap;
//import java.util.List;
//import java.util.Map;
//
//public class LottoResult {
//    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);
//
//    public LottoResult(List<Lotto> userLottos, WinningLotto winningLotto) {
//        for (Rank rank : Rank.values()) {
//            results.put(rank, 0);
//        }
//        for (Lotto lotto : userLottos) {
//            Rank rank = winningLotto.match(lotto);
//            results.put(rank, results.get(rank) + 1);
//        }
//    }
//
//    public int getCount(Rank rank) {
//        return results.get(rank);
//    }
//
//    public double calculateProfitRate(int purchaseAmount) {
//        long totalPrize = results.entrySet().stream()
//                .mapToLong(e -> (long) e.getKey().getPrize() * e.getValue())
//                .sum();
//        return ((double) totalPrize / purchaseAmount) * 100;
//    }
//
//    public Map<Rank, Integer> getResults() {
//        return results;
//    }
//}
