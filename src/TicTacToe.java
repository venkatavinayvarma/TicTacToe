import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> computerPositions = new ArrayList<Integer>();


    public static void main(String[] args) {

        // creating layout for the game board
        char[][] gameBoard = {{' ', '|', ' ', '|', ' ' },
                {'-', '+', '-', '+', '-' },
                {' ', '|', ' ', '|', ' ' },
                {'-', '+', '-', '+', '-' },
                {' ', '|', ' ', '|', ' ' },
        };

        printGameBoard(gameBoard);  // printing the board layout


        // checking the board numbers if it empty it will ask user to enter number
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number in between (1 to 9): ");
            int playerPosition = scanner.nextInt();
            while(playerPositions.contains(playerPosition) || computerPositions.contains(playerPositions)) {
                System.out.println("Player position already taken. Enter another position!");
                playerPosition = scanner.nextInt();

            }

            placePiece(gameBoard, playerPosition,"player");

            Random random = new Random();
            int computerPosition = random.nextInt(9)+ 1;
            while(playerPositions.contains(computerPosition) || computerPositions.contains(computerPosition)) {
                System.out.println("Player position already taken. Enter another position!");
                computerPosition = random.nextInt(9)+ 1;

            }
            placePiece(gameBoard, computerPosition,"computer");
            printGameBoard(gameBoard);


            String result = checkWinner();
            System.out.println(result);
        }

    }

    // method used for printing the game board
    public static  void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }


    // method used for placing the input from user in to the game board
    public static void placePiece(char[][] gameBoard, int position, String user) {

        // assigns character for player and computer
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(position);
        }
        else if (user.equals("computer")) {
            symbol = 'O';
            computerPositions.add(position);
        }


        // we take the input from the user and place the symbol based on the input user provided
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


    // method used for checking the winner
    public static String checkWinner() {

        // created a list with all the possibilities of the winner sequences
        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftColumn = Arrays.asList(1,4,7);
        List middleColumn = Arrays.asList(2,5,8);
        List rightColumn = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);

        // adding the list to the array list
        List<List> winners = new ArrayList<List>();
        winners.add(topRow);
        winners.add(middleRow);
        winners.add(bottomRow);
        winners.add(leftColumn);
        winners.add(middleColumn);
        winners.add(rightColumn);
        winners.add(cross1);
        winners.add(cross2);

        // checking if the winner criteria is met and printing the person who win or tied.
        for (List row : winners) {
            if (playerPositions.containsAll(row)) {
                return "Player wins!";
            }
            else if (computerPositions.containsAll(row)) {
                return "Computer wins!";
            }
            else if(playerPositions.size()+ computerPositions.size() == 9){
                return "Match is Drawn!";
            }
        }


        return " ";
    }
}
