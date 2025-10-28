package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    private int ticket =0;
    View view = new View();
    Lotto lotto = new Lotto();

    public void run(){
        getPrice();
        giveTickets(ticket);
        makeNumbers(ticket);
        answerNumber();
        bonusNumber();
    }

    public void getPrice(){
        view.showPrice();
        String input = Console.readLine();
        int price = Integer.parseInt(input);
        priceValidate(price);
        ticket = price/1000;
    }

    public void priceValidate(int price){
        if(price%1000!=0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1000으로 나누어 떨어지지 않습니다.");
        }
    }

    public void giveTickets(int ticket){
        view.showTickets(ticket);
    }

    public void makeNumbers(int ticket){
        for (int i = 0; i < ticket; i++) {
            view.showNumber(lotto.makeNumbers());
        }
    }

    public void answerNumber(){
        view.showInputAnswerNumberMessage();
        String input = Console.readLine();
        lotto.makeAnswers(input);
    }

    public void bonusNumber(){
        view.showInputBonusNumberMessage();
        String input = Console.readLine();
        lotto.makeBonusnumber(input);

    }
}
