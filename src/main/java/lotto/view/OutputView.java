package lotto.view;

import lotto.domain.Lotto;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.GenerateLottoNumbers;

public class OutputView {

    public void showCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void showLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
    }


    // 구매한 로또 전체 출력
    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatics(LottoResult lottoResult) {
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE || rank.getMatchCount() < 3) {
                continue;
            }

            int count = lottoResult.getCount(rank);
            System.out.printf(
                    "%d개 일치%s (%s원) - %d개\n",
                    rank.getMatchCount(),
                    rank.isBonus() ? ", 보너스 볼 일치" : "",
                    String.format("%,d", rank.getPrize()), // 천 단위 콤마 표시
                    count
            );
        }


    }

    // 총 수익률 출력
    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate); // 소수점 한 자리
    }



}
