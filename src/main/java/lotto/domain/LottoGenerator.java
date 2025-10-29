//package lotto.domain;
//
//import camp.nextstep.edu.missionutils.Randoms;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class LottoGenerator {
//
//    public static UserLottos generateUserLottos(int count) {
//        List<Lotto> lottos = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
//                    .stream()
//                    .sorted()
//                    .collect(Collectors.toList());
//            lottos.add(new Lotto(numbers)); // 바로 Lotto 객체 생성 후 리스트에 추가
//        }
//        return new UserLottos(lottos); // 리스트를 UserLottos로 전달
//    }
//}
