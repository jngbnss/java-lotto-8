package lotto.domain;

public class WinningLotto {
    // 당첨번호 저장 클래스
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto numbers, int bonusNumber) {
        this.winningNumbers = numbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위여야 합니다.");
        }
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
