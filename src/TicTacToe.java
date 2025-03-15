public class TicTacToe {
    public static void main(String[] args) {
        char [][] gameBoard = {{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
        };

        for(char [] row: gameBoard){
            for(char col : row){
                System.out.print(col);
            }
            System.out.println();
        }

    }
}
