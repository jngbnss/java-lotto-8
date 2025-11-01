package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.*;
import lotto.utils.converter;
import lotto.validator.utilValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.validator.utilValidator;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void run() {
        try {

            //1금액 입력
            inputView.intPurchaseAmount(); // 뷰화면 보여주고
            //int purchaseAmount = inputPurchaseView();
            //검증도 컨트롤러에서 하지말자 구매관련도 도메인 만들자

            String  purchasePrice = readLine();
            Purchasement purchasement = new Purchasement(purchasePrice);
            // 내부에서 검증하고 통과하면
            // int count / 1000;

            //PurchaseValidator.validateAmount(purchaseAmount);
            int count = purchasement.getValue() / 1000;

            //2로또 랜덤 번호 생성

            outputView.showCount(count);
            //로또 랜덤 번호 생성 및 검증 진행
            GenerateLottoNumbers generateLottoNumbers = generateNumbers(count);

            // 랜덤으로 생성된 로또번호 보여주기
            outputView.showLottos(generateLottoNumbers);

            //3당첨 번호 입력 + 보너스
            // 중간에 검증하고 바로 만드는게 좋겠다

            //당첨번호 입력
            // 1️⃣ 사용자 입력
            String winningNumbersInput = inputView.inputWinningNumbers();
            // 변환하기 이걸 어디서 해야할까 변환하는 도메인을 따로 만들자
            // 여기부터 유틸즈에 컨버터넣기

            Lotto winningNumber = converter.lottoConverter(winningNumbersInput);
            // 로또를 만들면서 내부에서 자동검증 수행
            int bonusNumber = inputView.inputBonusNumber();
            // 검증
            //보너스 검증도 만들면서 진행
            WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);


            /// // 오케이 일단 이 위까지는 통과
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


    //여기 진행중
    private int inputPurchaseView() {
        inputView.intPurchaseAmount();
        String input = readLine();
        utilValidator.validateNumber(input); // 숫자 검증
        return Integer.parseInt(input); // 숫자 변환
        //뷰에서 구입금액을 입력해 주세요를 보여주고
        // 아뷰에서 검증하지말라고
        // 입력받기
    }

    private void showCount(int count) {
        outputView.showCount(count);
    }

    private GenerateLottoNumbers generateNumbers(int count) {
        return new GenerateLottoNumbers(count);
    }


}