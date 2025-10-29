package lotto.view;

import lotto.domain.Lotto;
import java.util.List;

public class OutputView {

    // 구매한 로또 전체 출력
    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 당첨 통계 출력 (나중에 추가 가능)
    public void printWinningStatistics(/* 결과 객체 */) {
        // 예: "3개 일치 (5,000원) - 2개"
        // 추후 LottoResult 등 도메인 객체와 연계
    }

    // 총 수익률 출력
    public void printProfitRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    public void showCount(int count) {
        System.out.println("\n"+count+"개를 구매했습니다.");
    }
}
