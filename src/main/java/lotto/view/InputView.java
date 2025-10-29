package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            validateAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validateAmount(int amount) {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public String inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public int inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
