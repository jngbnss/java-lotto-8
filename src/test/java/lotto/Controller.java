package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    View view = new View();

    public void run(){
        getPrice();
    }

    public void getPrice(){
        view.showPrice();
        String input = Console.readLine();
        int price = Integer.parseInt(input);

    }
}
