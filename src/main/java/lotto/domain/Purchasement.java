package lotto.domain;

public class Purchasement {

    private final int purchasement;

    public Purchasement(String purchasePrice) {
        this.purchasement = parseAndValidate(purchasePrice);
    }

    private int parseAndValidate(String purchasePrice) {
        int value;
        try {
            value = Integer.parseInt(purchasePrice);  // 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        if (value <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야합니다.");
        }
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        if (value < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 최소 1000원 이상이어야 합니다.");
        }
        if (value > 100_000) {
            throw new IllegalArgumentException("[ERROR] 금액은 10만원 이하여야 합니다(1인당 100매까지 가능).");
        }

        return value;
    }

    public int getValue() {
        return purchasement;
    }
}
