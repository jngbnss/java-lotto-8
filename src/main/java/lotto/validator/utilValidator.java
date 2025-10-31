package lotto.validator;

public class utilValidator {
    public static int validateNumber(String input){
        //if (!input.matches("\\d+")) { // 정규식: 숫자로만 구성된 문자열인지
        // throw new
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
