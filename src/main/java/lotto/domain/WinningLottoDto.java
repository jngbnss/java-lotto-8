package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoDto {
    private final String lottoWinningnumbersInput;
    private final int bonusNumber;


    public WinningLottoDto(String lottoWinningnumbersInput, int bonusNumber) {
        this.lottoWinningnumbersInput = lottoWinningnumbersInput;
        this.bonusNumber = bonusNumber;
    }

    public Lotto toLotto() {
        // 문자열을 List<Integer>로 변환
        List<Integer> numbers = Arrays.stream(lottoWinningnumbersInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList(); // Java 16+는 collect(Collectors.toList()) 대신 toList() 가능

        // 정렬과 검증은 Lotto 생성자가 담당
        return new Lotto(numbers);
    }
//
//    public Lotto toLotto() {
//        List<Integer> numbers = Arrays.stream(lottoWinningnumbersInput.split(","))
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        return new Lotto(numbers);
//    }

    public int getBonusNumber() {
        return bonusNumber;
    }

//    //여기 애매리송
//    public WinningLotto toWinningLotto() {
//        Lotto lotto = new Lotto(lottoWinningnumbersInput); // 문자열 → Lotto 변환 + 검증
//        return new WinningLotto(lotto, bonusNumber);      // WinningLotto 생성
//    }

}
