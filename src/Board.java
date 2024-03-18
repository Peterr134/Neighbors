public class Board {
    private int[][] board;

    public Board(){
        board = new int[5][5];
    }

    public void printBoard(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == 0){
                    System.out.print("X ");
                }else{
                    System.out.print(board[r][c] + " ");
                }
            }
            System.out.println();
        }
    }

    public void place(int r, int c, int value){
        if(board[r][c] == 0) {
            board[r][c] = value;
        }else{
            System.out.println("Invalid Move");
        }
    }
}
