import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Dice d10 = new Dice(10);
        int timesPlaced = 0;
        while(timesPlaced < 25) {
            board.printBoard();
            int roll = d10.roll();
            System.out.println("The dice rolls " + roll);
            System.out.println("Where do you want to place the number? (r,c)");
            Scanner scanner = new Scanner(System.in);
            String input2 = scanner.nextLine();
            if(input2.equals("fill")){
                board.fillBoard();
                timesPlaced = 25;
            }else {
                String[] input = input2.split(",");
                if (board.place(Integer.parseInt(input[0]), Integer.parseInt(input[1]), roll)) {
                    timesPlaced++;
                }
            }
        }
        System.out.println("Placing complete! Now calculating points");
        board.printBoard();
        System.out.println("You earned " + board.calcPoints() + " points this game");
    }
}