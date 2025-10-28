package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private  List<Integer> numbers;
    private  int bonusNumber;



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
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void makeBonusNumber(int input){
        this.bonusNumber = input;
    }
}
