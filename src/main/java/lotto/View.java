package lotto;

public class View {
    public void showPrice(){
        System.out.println("구입금액을 입력해주세요.");
    }
    public void showTickets(int ticketCount){

        System.out.println("\n"+ticketCount+"개를 구매했습니다.");
    }
    public void showNumber(String numbers){
        System.out.println("["+numbers+"]");
    }

    public void showInputAnswerNumberMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요");
    }

    public void showInputBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요");
    }
}
