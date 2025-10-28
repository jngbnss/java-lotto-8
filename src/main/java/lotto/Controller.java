package lotto;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        int count = purchaseAmount / 1000;

        List<Lotto> userLottos = inputView.generateUserLottos(count);
        outputView.printLottos(userLottos);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResult result = new LottoResult(userLottos, winningLotto);

        outputView.printResult(result, purchaseAmount);
    }
}