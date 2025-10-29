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

        //DTO를 통해 당첨 정보 생성
        String winningNumbersInput = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        WinningLottoDto winningLottoDto = new WinningLottoDto(winningNumbersInput, bonusNumber);
        Lotto winningNumbers = winningLottoDto.toLotto();// 이거 컨트롤러에서 직접 저장을 해줘야하는건가?
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoResult result = new LottoResult(userLottos, winningLotto);
        outputView.printResult(result, purchaseAmount);
    }
}