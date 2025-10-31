package lotto.validator;

public class PurchaseValidator {
    public static void validateAmount(int amount) {
        if ( amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        if(amount<0){
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야합니다.");
        }
        if (amount < 1000 ) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000보다 커야합니다.");
        }

        if (amount > 100000 ) {
            throw new IllegalArgumentException("[ERROR] 금액은 십만원 이하여야 합니다(1인당 100매까지 가능).");
        }

    }
}
