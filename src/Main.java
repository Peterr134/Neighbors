import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        Dice d10 = new Dice(10);
        int timesPlaced = 0;
        while(timesPlaced < 25) {
            board.printBoard();
            int roll = d10.roll();
            System.out.println("The dice rolls " + roll);
            System.out.println("Where do you want to place the number? (r,c)");
            System.out.println("If you're playing with someone else, then add a 3rd comma to input the dice roll they got");
            String input2 = scanner.nextLine();
            if(input2.equals("fill")){
                board.fillBoard();
                timesPlaced = 25;
            }else {
                String[] input = input2.split(",");
                try{
                    roll = Integer.parseInt(input[2]);
                }catch(ArrayIndexOutOfBoundsException e){}
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