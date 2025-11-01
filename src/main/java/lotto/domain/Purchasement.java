package lotto.domain;

import lotto.validator.PurchasementValidator;

public class Purchasement {

    private final int purchasement;

    public Purchasement(String purchasePrice) {
        this.purchasement = PurchasementValidator.validateAndParse(purchasePrice);
    }


    public int getValue() {
        return purchasement;
    }
}
