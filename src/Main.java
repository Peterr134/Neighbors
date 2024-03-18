import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Dice d10 = new Dice(10);
        board.printBoard();
        int roll = d10.roll();
        System.out.println("The dice rolls " + roll);
        System.out.println("Where do you want to place the number? (r,c)");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        board.place(Integer.parseInt(input[0]),Integer.parseInt(input[1]),roll);
    }
}