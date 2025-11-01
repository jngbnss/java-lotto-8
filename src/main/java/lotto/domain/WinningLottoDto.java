//package lotto.domain;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class WinningLottoDto {
//    private final List<Integer> numbers;
//    private final int bonusNumber;
//
//
//    public WinningLottoDto(String numbersInput, int bonusNumber) {
//        this.numbers = Arrays.stream(numbersInput.split(","))
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        this.bonusNumber = bonusNumber;
//    }
//
//    public List<Integer> getNumbers() {
//        return numbers;
//    }
//
//    public int getBonusNumber() {
//        return bonusNumber;
//    }
//}
