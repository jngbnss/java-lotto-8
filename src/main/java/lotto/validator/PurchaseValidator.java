//package lotto.validator;
//
//public class PurchaseValidator {
//    private static final int MIN_COUNT = 1;   // 최소 구매 가능 개수
//    private static final int MAX_COUNT = 100; // 최대 구매 가능 개수
//
//    public static void validateAmount(int amount) {
//        if ( amount % 1000 != 0) {
//            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
//        }
//        if(amount<0){
//            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야합니다.");
//        }
//        if (amount < 1000 ) {
//            throw new IllegalArgumentException("[ERROR] 금액은 1000보다 커야합니다.");
//        }
//
//        if (amount > 100000 ) {
//            throw new IllegalArgumentException("[ERROR] 금액은 십만원 이하여야 합니다(1인당 100매까지 가능).");
//        }
//
////        if (amount < MIN_COUNT) {
////            throw new IllegalArgumentException("[ERROR] 로또 구매 개수는 최소 " + MIN_COUNT + "개 이상이어야 합니다.");
////        }
////        if (amount > MAX_COUNT) {
////            throw new IllegalArgumentException("[ERROR] 로또는 최대 " + MAX_COUNT + "개까지만 구매할 수 있습니다.");
////        }
//
//    }
//}
