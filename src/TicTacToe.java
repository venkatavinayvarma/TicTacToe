import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // creating layout for the game board
        char[][] gameBoard = {{' ', '|', ' ', '|', ' ' },
                {'-', '+', '-', '+', '-' },
                {' ', '|', ' ', '|', ' ' },
                {'-', '+', '-', '+', '-' },
                {' ', '|', ' ', '|', ' ' },
        };

        printGameBoard(gameBoard);



        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number in between (1 to 9): ");
            int playerPosition = scanner.nextInt();
            placePiece(gameBoard, playerPosition,"player");

            Random random = new Random();
            int computerPosition = random.nextInt(9)+ 1;
            placePiece(gameBoard, computerPosition,"computer");
            printGameBoard(gameBoard);
        }

    }
    public static  void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int position, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
        }
        else if (user.equals("computer")) {
            symbol = 'O';
        }
        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;

            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
}
