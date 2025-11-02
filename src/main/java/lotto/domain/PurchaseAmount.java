package lotto.domain;

import lotto.validator.PurchasementValidator;

public class PurchaseAmount {

    private final int purchaseAmount;

    public PurchaseAmount(String purchasePrice) {
        // 구매 가격 변환 및 검증 진행
        this.purchaseAmount = PurchasementValidator.validateAndParse(purchasePrice);
    }


    public int getValue() {
        return purchaseAmount;
    }
}
