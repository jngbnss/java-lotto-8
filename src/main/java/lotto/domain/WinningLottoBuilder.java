//package lotto.domain;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class WinningLottoBuilder {
//    private List<Integer> numbers;
//    private int bonusNumber;
//
//    public WinningLottoBuilder inputNumbers(String numbersInput) {
//        this.numbers = Arrays.stream(numbersInput.split(","))
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        return this;
//    }
//
//    public WinningLottoBuilder inputBonusNumber(int bonusNumber) {
//        this.bonusNumber = bonusNumber;
//        return this;
//    }
//
//    public WinningLotto build() {
//        return new WinningLotto(numbers, bonusNumber);
//    }
//}
