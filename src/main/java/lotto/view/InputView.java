package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class InputView {public int inputPurchaseAmount() {
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

    public List<Lotto> generateUserLottos(int count) {
    //뷰의 책임으로 부적절하다고 생각됨
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public String inputWinningNumbers() {
    // 여기 고쳐보자
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
