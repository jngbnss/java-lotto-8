package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    public String makeNumbers(){
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        integers.sort(Comparator.naturalOrder());
        // 리스트를 문자열로 변환하고 ,로 연결
        String randomNumbers = integers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return randomNumbers;
    }
}
