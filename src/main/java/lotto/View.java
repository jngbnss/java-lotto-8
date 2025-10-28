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

    public void showCalculate() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - 1개");
        System.out.println("4개 일치 (50,000원) - 0개");
        System.out.println("5개 일치 (1,500,000원) - 0개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        System.out.println("6개 일치 (2,000,000,000원) - 0개");
        System.out.println("총 수익률은 62.5%입니다.");

    }
}
