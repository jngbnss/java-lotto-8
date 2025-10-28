package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    private int ticket =0;
    View view = new View();

    public void run(){
        getPrice();
        giveTickets(ticket);
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
}
