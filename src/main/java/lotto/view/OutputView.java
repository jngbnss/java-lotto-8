package lotto.view;

import lotto.domain.Lotto;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.GenerateLottoNumbers;

public class OutputView {

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
        //여기서 enum값 받아서 반복문으로 돌리기
        // 이걸 여기서 왜해
        for (Rank rank : Rank.values()) {
            // NONE 또는 3개 미만 일치한 경우는 출력하지 않음
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
    public void printProfitRate(double rate) {
        System.out.println("총 수익률은 " + String.format("%.2f", rate) + "%입니다.");
    }

    public void showCount1(int count, GenerateLottoNumbers lottos) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getNumbers()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void showLottos(GenerateLottoNumbers generateLottoNumbers) {
        for (Lotto lotto : generateLottoNumbers.getNumbers()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
