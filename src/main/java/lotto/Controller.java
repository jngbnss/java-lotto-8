package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void run() {
        try {
            int purchaseAmount = inputView.inputPurchaseAmount();

            int count = purchaseAmount / 1000;
            UserLottos userLottos = new UserLottos(count);
            outputView.showCount(count, userLottos);

            //DTO를 통해 당첨 정보 생성
            String winningNumbersInput = inputView.inputWinningNumbers();//1,2,3
            int bonusNumber = inputView.inputBonusNumber();

            WinningLottoDto winningLottoDto = new WinningLottoDto(winningNumbersInput, bonusNumber);

            LottoChecker checker = new LottoChecker(
                    new Lotto(winningLottoDto.getNumbers()),
                            winningLottoDto.getBonusNumber()
                    );

            LottoResult lottoResult = new LottoResult(userLottos, checker);

            /*
            List<Integer> numbers = inputView.inputWinningNumbersAsList(); // List<Integer> 바로 받음
            int bonusNumber = inputView.inputBonusNumber();

            Lotto winningLotto = new Lotto(numbers);        // 생성 시 검증 + 정렬
            LottoChecker checker = new LottoChecker(winningLotto, bonusNumber);

            LottoResult lottoResult = new LottoResult(userLottos, checker);

             */

           //LottoResult(userLottos,winningLotto,bonusNumber);
            outputView.printStatics(lottoResult);
            outputView.printProfitRate(lottoResult.calculateProfitRate(purchaseAmount));


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}