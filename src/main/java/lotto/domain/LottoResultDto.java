package lotto.domain;

public class LottoResultDto {
    private final int matchCount;
    private final boolean bonus;
    private final int prize;
    private final int count;
    private final double profitRate; // 수익률 추가

    public LottoResultDto(int matchCount, boolean bonus, int prize, int count, double profitRate) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
        this.count = count;
        this.profitRate = profitRate;
    }

    public int getMatchCount() { return matchCount; }
    public boolean isBonus() { return bonus; }
    public int getPrize() { return prize; }
    public int getCount() { return count; }
    public double getProfitRate() { return profitRate; }
}
