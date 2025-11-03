package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResultDto;

public class OutputView {

    public void showCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void showLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 등수별 통계 출력
    public void printStatics(List<LottoResultDto> dtos) {
        System.out.println("\n당첨 통계\n---");
        for (LottoResultDto dto : dtos) {
            System.out.printf(
                    "%d개 일치%s (%s원) - %d개\n",
                    dto.getMatchCount(),
                    dto.isBonus() ? ", 보너스 볼 일치" : "",
                    String.format("%,d", dto.getPrize()),
                    dto.getCount()
            );
        }
    }

    // DTO에서 수익률 출력
    public void printProfitRate(List<LottoResultDto> dtos) {
        if (dtos.isEmpty()) return; // 안전하게 처리
        double profitRate = dtos.get(0).getProfitRate(); // 모든 DTO에 동일한 값
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
