package lotto.domain;

public class WinningLotto {
    // 당첨번호 저장 클래스
    private final Lotto winningNumbers;
    private final int bonusNumber;



    public WinningLotto(Lotto numbers, int bonusNumber) {
        this.winningNumbers = numbers;
        validateBonusNumberNotDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberNotDuplicate(int bonusNumber) {

        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    ErrorMessage.BONUS_NUMBER_NOT_DUPLICATE.getMessage());
        }
    }
    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
