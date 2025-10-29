package lotto.domain;

public class WinningLotto {
    // 당첨번호 + 보너스 번호 보관 / 비교가능 제공
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        // 보너스 넘버 검증
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto userLotto){
        int matchCount = (int) userLotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
        boolean bonusMatch = userLotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount,bonusMatch);
    }
}
