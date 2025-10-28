package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public String makeNumbers(){
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        integers.sort(Comparator.naturalOrder());
        // 리스트를 문자열로 변환하고 ,로 연결
        String randomNumbers = integers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return randomNumbers;
    }

    public void makeAnswers(String input) {
        String[]parts = input.split(",");
        List<Integer> inputnumbers=new ArrayList<>();

        for (String part : parts) {
            String trimmed = part.trim();
            if (trimmed.isEmpty()) continue; // ✅ 빈 문자열 무시

            try{
                inputnumbers.add(Integer.parseInt(part.trim()));
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }

        }
        validate(inputnumbers);
        this.numbers = inputnumbers;

    }

    public void makeBonusnumber(String input) {
        int bonusnumber = Integer.parseInt(input);
    }
}
