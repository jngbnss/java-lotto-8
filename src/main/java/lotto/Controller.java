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

//        // LottoGenerator로 UserLottos 생성
//        UserLottos userLottos = LottoGenerator.generateUserLottos(count);
//
//        //List<Lotto> userLottos = inputView.generateUserLottos(count);
//        //outputView.printLottos(userLottos);

        //DTO를 통해 당첨 정보 생성
        String winningNumbersInput = inputView.inputWinningNumbers();//1,2,3
        int bonusNumber = inputView.inputBonusNumber();
        WinningLottoDto winningLottoDto = new WinningLottoDto(winningNumbersInput, bonusNumber);

        // 컨트롤러에서 Lotto를 직접 만들 필요 없음
        //WinningLotto winningLotto = winningLottoDto.toWinningLotto();
        //LottoResult result = new LottoResult(userLottos, winningLotto);
        //outputView.printResult(result, purchaseAmount);
    }
}