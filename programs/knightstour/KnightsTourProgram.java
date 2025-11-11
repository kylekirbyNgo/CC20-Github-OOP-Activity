package programs.knightstour;

import java.util.Scanner;
import core.ProgramInterface;

/**
 * Simple Knight's Tour demonstration.
 * This program attempts to visit all squares of an N×N chessboard
 * using the movement pattern of a knight.
 *
 * Author: Michael Martin T. Pagaran
 * Description: Demonstrates backtracking using the knight's movement.
 */

public class KnightsTourProgram implements ProgramInterface {

    public String getName() { return "Knight's Tour"; }

    public String getDescription() {
        return "Solves Knight's Tour using backtracking (visits all squares).";
    }

    public String getAuthor() { return "Example Author"; }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter board size (e.g., 5 for 5x5): ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = -1; // unvisited

        // Moves of a knight
        int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

        // Start position
        board[0][0] = 0;

        if (solveTour(0, 0, 1, board, moveX, moveY, n)) {
            printBoard(board, n);
        } else {
            System.out.println("No solution exists for board size " + n);
        }
    }

    // Recursive backtracking function
    private boolean solveTour(int x, int y, int moveCount,
                              int[][] board, int[] moveX, int[] moveY, int n) {
        if (moveCount == n * n) return true;

        for (int i = 0; i < 8; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if (isSafe(nextX, nextY, board, n)) {
                board[nextX][nextY] = moveCount;
                if (solveTour(nextX, nextY, moveCount + 1, board, moveX, moveY, n))
                    return true;
                else
                    board[nextX][nextY] = -1; // backtrack
            }
        }
        return false;
    }

    // Checks if the move is inside the board and not yet visited
    private boolean isSafe(int x, int y, int[][] board, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == -1);
    }

    // Prints the final solution
    private void printBoard(int[][] board, int n) {
        System.out.println("\nKnight's Tour solution:");
        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
    }
}
