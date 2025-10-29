//package lotto.domain;
//
//import camp.nextstep.edu.missionutils.Randoms;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class UserLottos {
//    private final List<Lotto> lottos;
//
//    // 생성자에서 count만 받아서 내부에서 랜덤 로또 생성
//    public UserLottos(int count) {
//        this.lottos = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
//                    .stream()
//                    .sorted()
//                    .collect(Collectors.toList());
//            this.lottos.add(new Lotto(numbers));
//        }
//    }
//
//    public List<Lotto> getLottos() {
//        return lottos;
//    }
//
//    public void printLottos() {
//        System.out.println(lottos.size() + "개를 구매했습니다.");
//        for (Lotto lotto : lottos) {
//            System.out.println(lotto.getNumbers());
//        }
//    }
//}
