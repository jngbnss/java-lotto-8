package lotto.domain;

public class ProfitCalculator {
    public static double calculate(long totalPrize,int purchaseAmount){
        return ((double) totalPrize/purchaseAmount)*100;
    }
}
