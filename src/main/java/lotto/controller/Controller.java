package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.*;
import lotto.validator.PurchaseValidator;
import lotto.validator.utilValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void run() {
        try {

            //1금액 입력
            int purchaseAmount  = inputPurchaseView();
            //검증
            PurchaseValidator.validateAmount(purchaseAmount);
            int count = purchaseAmount/1000;
            //2로또 랜덤 번호 생성
            outputView.showCount(count);
            //3당첨 번호 입력 + 보너스
            //랜덤번호 생성
            GenerateLottoNumbers generateLottoNumbers = generateNumbers(count);
            outputView.showLottos(generateLottoNumbers);
            //검증
            //4로또 검사 및 결과 생성
            //결과 출력

            //여기서 검증한번하면 좋은데
            //outputView.showCount1(count, generateLottoNumbers);

            //DTO를 통해 당첨 정보 생성
            String winningNumbersInput = inputView.inputWinningNumbers();//1,2,3
            // 여기서 오류 난다

            int bonusNumber = inputView.inputBonusNumber();

            WinningLottoDto winningLottoDto = new WinningLottoDto(winningNumbersInput, bonusNumber);

            // 정답 구하는  로직
            LottoChecker checker = new LottoChecker(
                    new Lotto(winningLottoDto.getNumbers()),
                            winningLottoDto.getBonusNumber()
                    );

            LottoResult lottoResult = new LottoResult(generateLottoNumbers, checker);

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



    private int inputPurchaseView() {
        inputView.intPurchaseAmount();
        String input = readLine();
        utilValidator.validateNumber(input); // 숫자 검증
        return Integer.parseInt(input); // 숫자 변환
        //뷰에서 구입금액을 입력해 주세요를 보여주고
        // 입력받기
    }

    private void showCount(int count){
        outputView.showCount(count);
    }
    private GenerateLottoNumbers generateNumbers(int count) {
        return new GenerateLottoNumbers(count);
    }


}