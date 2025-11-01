package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.*;
import lotto.utils.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void run() {
        try {
            //1금액 입력
            inputView.intPurchaseAmount();
            String inputPrice = readLine();
            Purchasement purchasement = new Purchasement(inputPrice);// 내부에서 검증
            int count = purchasement.getValue() / 1000;

            //2로또 랜덤 번호 생성
            outputView.showCount(count);
            GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers(count);//로또 랜덤 번호 생성 후 로또 클래스에서 검증 진행
            outputView.showLottos(generateLottoNumbers);// 랜덤으로 생성된 로또번호 보여주기

            //3당첨 번호 입력 + 보너스
            inputView.inputWinningNumbers(); //당첨번호 입력
            String winningNumbersInput = readLine();
            Lotto winningNumber = Converter.lottoConverter(winningNumbersInput);
            // 컨버터에서 lotto 타입으로 변경 및 검증 진행
            inputView.inputBonusNumber();
            String inputBonusNumber = readLine();
            int bonusNumber = Converter.intConverter(inputBonusNumber);// 컨버터에서 int 타입으로 변경 및 숫자범위 검증 진행
            WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber); // 보너스 넘버 중복 검증
            // 여기까지 완료

            //4로또 검사 및 결과 생성
            LottoChecker lottoChecker = new LottoChecker(winningLotto.getWinningNumbers(),
                    winningLotto.getBonusNumber());

            LottoResult result = new LottoResult(generateLottoNumbers, lottoChecker);
            //결과 출력

            outputView.printStatics(result);
            outputView.printProfitRate(result.calculateProfitRate(purchasement.getValue()));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}