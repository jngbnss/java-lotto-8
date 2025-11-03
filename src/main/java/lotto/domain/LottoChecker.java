package lotto.domain;

public class LottoChecker {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public LottoChecker(Lotto winningNumber, int bonusNumber) {
        // 당첨번호를 저장
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto randomlyGeneratedNumber) {
        // 랜덤으로 발행된 로또들을 당첨번호와 비교하면서 등수 계산
        int matchCount = (int) randomlyGeneratedNumber.getNumbers().stream()
                .filter(winningNumber.getNumbers()::contains)
                .count();
        boolean bonusMatch = randomlyGeneratedNumber.getNumbers().contains(bonusNumber);

        return Rank.valueOf(matchCount, bonusMatch);
        //ex : if (matchCount == 5 && bonusMatch) → Rank.SECOND
    }
}
