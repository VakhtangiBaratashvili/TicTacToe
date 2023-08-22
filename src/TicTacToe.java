import java.util.Scanner;

public class TicTacToe {
    private static void play() {
        char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        printBoard(board);
        char currentPlayer = 'X';
        boolean gameRunning = true;
        while (gameRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Position for " + currentPlayer + ": ");
            try {
                int position = scanner.nextInt();
                while ((position < 1 || position > 9) || board[position - 1] != ' ') {
                    System.out.print("Invalid input, try again: ");
                    position = scanner.nextInt();
                }
                board[position - 1] = currentPlayer;
                printBoard(board);
                if (checkWin(board)) {
                    System.out.println(currentPlayer + " Wins!");
                    gameRunning = false;
                }
                else if (checkTie(board)) {
                    System.out.println("Tie!");
                    gameRunning = false;
                }
                else {
                    currentPlayer = changePlayer(currentPlayer);
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    private static void printBoard(char[] board) {
        System.out.println(" _________________");
        System.out.println("|     |     |     |");
        System.out.println("|  "+board[0]+"  |  "+board[1]+"  |  "+board[2]+"  |");
        System.out.println("|_____|_____|_____|");
        System.out.println("|     |     |     |");
        System.out.println("|  "+board[3]+"  |  "+board[4]+"  |  "+board[5]+"  |");
        System.out.println("|_____|_____|_____|");
        System.out.println("|     |     |     |");
        System.out.println("|  "+board[6]+"  |  "+board[7]+"  |  "+board[8]+"  |");
        System.out.println("|_____|_____|_____|");
    }

    private static boolean checkWin(char[] board) {
        return ((board[0]==board[1]) && (board[1] == board[2]) && board[0] != ' ')||
                ((board[3]==board[4]) && (board[4] == board[5]) && board[3] != ' ')||
                ((board[6]==board[7]) && (board[7] == board[8]) && board[6] != ' ')||
                ((board[0]==board[3]) && (board[3] == board[6]) && board[0] != ' ')||
                ((board[1]==board[4]) && (board[4] == board[7]) && board[1] != ' ')||
                ((board[2]==board[5]) && (board[5] == board[8]) && board[2] != ' ')||
                ((board[0]==board[4]) && (board[4] == board[8]) && board[0] != ' ')||
                ((board[2]==board[4]) && (board[4] == board[6]) && board[2] != ' ');
    }

    private static boolean checkTie(char[] board) {
        for (char i: board) {
            if (i == ' ') {
                return false;
            }
        }
        return true;
    }

    private static char changePlayer(char currentPlayer) {
        return currentPlayer == 'X' ? 'O' : 'X';
    }

    private static void playAgain() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine();
            while (!playAgain.equalsIgnoreCase("yes") && !playAgain.equalsIgnoreCase("no")) {
                System.out.print("Enter 'yes' or 'no': ");
                playAgain = scanner.nextLine();
            }
            if (playAgain.equalsIgnoreCase("yes")) {
                play();
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        play();
        playAgain();
    }
}