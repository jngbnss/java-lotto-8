package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.inputHandler.emptyCheck;

import java.util.List;
import lotto.domain.*;
import lotto.service.LottoResultService;
import lotto.utils.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoResultService resultService = new LottoResultService();


    public void run() {
        try {
            //1금액 입력
            inputView.intPurchaseAmount();
            String inputPrice = emptyCheck(readLine());
            // 모든 입력 받고 공백 검증은 inputHandler.emptyCheck(String input)에서 진행

            PurchaseAmount purchaseAmount = new PurchaseAmount(inputPrice);// 모델에서 검증
            int count = purchaseAmount.getValue() / 1000;

            //2로또 랜덤 번호 생성
            outputView.showCount(count); // 구매 갯수 출력

            //로또 랜덤 번호 생성 후 로또 클래스에서 검증 진행
            GenerateLottoNumbers randomlyGeneratedNumbers = new GenerateLottoNumbers(count);
            List<Lotto> lotteries = randomlyGeneratedNumbers.getRandomlyGeneratedLotteries();
            outputView.showLotteries(lotteries);// 랜덤으로 생성된 로또번호 보여주기


            //3당첨번호 입력
            inputView.inputWinningNumbers();
            String winningNumbersInput = emptyCheck(readLine());
            //컨버터로 lotto 형식으로 변환 후 lotto에서 검증 진행
            Lotto winningNumber = Converter.lottoConverter(winningNumbersInput);

            //보너스번호 입력
            inputView.inputBonusNumber();
            String inputBonusNumber = emptyCheck(readLine());
            int bonusNumber = Converter.intConverter(inputBonusNumber);// 컨버터에서 int 타입으로 변경 및 숫자범위 검증 진행

            // WinningLotto 보너스 넘버 중복 "검증"
            WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

            //4로또 검사 및 결과 생성
            // 로또 체커가 하는 일 당첨번호 "참조"
            // 로또 체커에 당첨번호를 저장후
            // 로또 체커 메서드에서 랜덤으로 발행된 로또와 비교하여
            // 당첨 등수를 계산함
            LottoChecker lottoChecker =
                    new LottoChecker(winningLotto.getWinningNumbers(), winningLotto.getBonusNumber());

            LottoResult result = resultService.calculateResult(randomlyGeneratedNumbers,lottoChecker);
            //결과 출력

            outputView.printStatics(result);
            outputView.printProfitRate(result.calculateProfitRate(purchaseAmount.getValue()));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}