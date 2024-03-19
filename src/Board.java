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

    public boolean place(int r, int c, int value){
        if(board[r][c] == 0) {
            board[r][c] = value;
            return true;
        }else{
            System.out.println("Invalid Move");
            return false;
        }
    }

    public int calcPoints(){
        int points = 0;
        //horizontal points
        int streak = 0;
        int streakNum = 0;
        for(int r = 0; r < board.length; r++){
            streak = 0;
            streakNum = 0;
            for(int c = 0; c < board[0].length-1; c++){
                if(board[r][c] == board[r][c+1]){
                    streak++;
                    streakNum = board[r][c];
                }else{
                    streak++;
                    if(streak != 1) {
                        points += streak * streakNum;
                    }
                    streak = 0;
                }
                if(c == board[0].length-2){
                    streak++;
                    if(streak != 1) {
                        points += streak * streakNum;
                    }
                }
            }
        }
        //vertical points
        for(int c = 0; c < board[0].length; c++){
            streak = 0;
            streakNum = 0;
            for(int r = 0; r < board.length-1; r++){
                if(board[r][c] == board[r+1][c]){
                    streak++;
                    streakNum = board[r][c];
                }else{
                    streak++;
                    if(streak != 1) {
                        points += streak * streakNum;
                    }
                    streak = 0;
                }
                if(r == board.length-2){
                    streak++;
                    if(streak != 1) {
                        points += streak * streakNum;
                    }
                    streak = 0;
                }
            }
        }
        return points;
    }

    public void fillBoard(){
        for(int r = 0; r < 5; r++){
            for(int c = 0; c < 5; c++){
                board[r][c] = 1;
            }
        }
    }
}
