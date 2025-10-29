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


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}