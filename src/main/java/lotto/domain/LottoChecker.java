package lotto.domain;

public class LottoChecker {
    // 당첨번호 + 보너스 번호 보관 / 비교가능 제공
    private final Lotto checkNumber;
    private final int bonusNumber;

    public LottoChecker(Lotto checkNumber, int bonusNumber) {
        this.checkNumber = checkNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto userLotto){
        int matchCount = (int) userLotto.getNumbers().stream()
                .filter(checkNumber.getNumbers()::contains)
                .count();
        boolean bonusMatch = userLotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount,bonusMatch);
    }
}
