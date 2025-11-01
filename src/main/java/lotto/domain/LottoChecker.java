package lotto.domain;

public class LottoChecker {
    // 당첨번호 + 보너스 번호 보관 / 비교가능 제공
    private final Lotto checkNumber;
    private final int bonusNumber;

    public LottoChecker(Lotto checkNumber, int bonusNumber) {
        // 보너스 넘버 검증
        // 지금 이러면 안되는게 보너스넘버가 끝나고 진행돼
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
