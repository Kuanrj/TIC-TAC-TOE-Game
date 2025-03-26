import java.util.Scanner;

public class TicTacToe {
    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';
    private static final char EMPTY = ' ';
    private static final int SIZE = 3;
    private static char[][] board = new char[SIZE][SIZE];
    private static boolean isSinglePlayer = true;
    private static String player1Name;
    private static String player2Name;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            initializeBoard();

            System.out.println("       +------------------------+       ");
            System.out.println("---=<<<| Welcome to TIC TAC TOE |>>>=---");
            System.out.println("       +------------------------+       ");
            System.out.print("Enter Player 1 name: ");
            player1Name = scanner.next();
            System.out.print("Select Game Mode (1: Single Player, 2: Two Player): ");
            int mode = scanner.nextInt();
            isSinglePlayer = (mode == 1);

            if (isSinglePlayer) {
                player2Name = "AI";
            } else {
                System.out.print("Enter Player 2 name: ");
                player2Name = scanner.next();
            }

            printBoard();

            while (true) {
                playerMove(scanner, player1Name, PLAYER1);
                if (isGameOver(PLAYER1, player1Name)) break;

                if (isSinglePlayer) {
                    aiMove();
                    if (isGameOver(PLAYER2, player2Name)) break;
                } else {
                    playerMove(scanner, player2Name, PLAYER2);
                    if (isGameOver(PLAYER2, player2Name)) break;
                }
            }

            System.out.print("Play again ? ( Yes / No ): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard() {
        System.out.println("Current board:");
        System.out.println("+-----------+");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < SIZE - 1) System.out.print("|");
            }
            System.out.print("|");
            System.out.println();
            if (i < SIZE - 1) System.out.println("+---+---+---+");

        }
        System.out.println("+-----------+");
    }

    private static void playerMove(Scanner scanner, String playerName, char player) {
        int row, col;
        while (true) {
            System.out.print(playerName + " (" + player + ") enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY) {
                board[row][col] = player;
                break;
            } else {
                System.out.println("This move is not valid");
            }
        }
        printBoard();
    }

    private static void aiMove() {
        int[] bestMove = findBestMove();
        board[bestMove[0]][bestMove[1]] = PLAYER2;
        System.out.println("AI move: (" + bestMove[0] + ", " + bestMove[1] + ")");
        printBoard();
    }

    private static int[] findBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[2];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = PLAYER2;
                    int score = minimax(board, 0, false);
                    board[i][j] = EMPTY;
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }

        return bestMove;
    }

    private static int minimax(char[][] board, int depth, boolean isMaximizing) {
        if (checkWin(PLAYER2)) return 10 - depth;
        if (checkWin(PLAYER1)) return depth - 10;
        if (isDraw()) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = PLAYER2;
                        bestScore = Math.max(bestScore, minimax(board, depth + 1, false));
                        board[i][j] = EMPTY;
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = PLAYER1;
                        bestScore = Math.min(bestScore, minimax(board, depth + 1, true));
                        board[i][j] = EMPTY;
                    }
                }
            }
            return bestScore;
        }
    }

    private static boolean isGameOver(char player, String playerName) {
        if (checkWin(player)) {
            printBoard();
            System.out.println(playerName + " (" + player + ") wins!");
            return true;
        }
        if (isDraw()) {
            printBoard();
            System.out.println("It's a draw!");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char player) {
        // check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;  // i=0
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    private static boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) return false;
            }
        }
        return true;
    }
}
