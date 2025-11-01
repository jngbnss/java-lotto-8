package lotto.domain;

public enum ErrorMessage {
    INVALID_LOTTO_COUNT("[ERROR] 로또 구매 개수는 1~100개만 가능합니다."),
    INVALID_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    NEGATIVE_OR_ZERO_AMOUNT("[ERROR] 금액은 0보다 커야합니다."),
    INVALID_UNIT_AMOUNT("[ERROR] 금액은 1000원 단위로 입력해야 합니다."),
    MINIMUM_AMOUNT("[ERROR] 금액은 최소 1000원 이상이어야 합니다."),
    MAXIMUM_AMOUNT("[ERROR] 금액은 10만원 이하여야 합니다(1인당 100매까지 가능).");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
