package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(LottoResult result, int purchaseAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + result.getCount(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getCount(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getCount(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getCount(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getCount(Rank.FIRST) + "개");

        double profit = result.calculateProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profit);
    }
}
