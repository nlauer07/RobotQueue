/*
 * Written by Nick Lauer
 */
public class Board {
    private static final int BOARD_SIZE = 10;
    private static final char OBSTACLE_CHAR = 'X';
    private char[][] board;

    public Board(String[] lines) {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = lines[i].charAt(j);
            }
        }
    }

    public boolean isValidMove(int x, int y) {
        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
            return false;
        }
        return board[y][x] != OBSTACLE_CHAR;
    }

    public void printBoard(Robot robot) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i == robot.getY() && j == robot.getX()) {
                    System.out.print('O');
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }
}