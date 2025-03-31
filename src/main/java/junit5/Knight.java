package junit5;

import java.util.ArrayList;
import java.util.List;

public class Knight {
    private int x, y;
    private static final int[][] MOVES = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
    };

    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<int[]> getValidMoves(char[][] board) {
        int size = board.length;
        List<int[]> validMoves = new ArrayList<>();

        for (int[] move : MOVES) {
            int newX = x + move[0];
            int newY = y + move[1];

            if (isValidMove(newX, newY, board, size)) {
                validMoves.add(new int[]{newX, newY});
            }
        }
        return validMoves;
    }

    private boolean isValidMove(int x, int y, char[][] board, int size) {
        return x >= 0 && x < size && y >= 0 && y < size && board[x][y] == '□';
    }

    public void displayPossibleMoves(char[][] board) {
        List<int[]> moves = getValidMoves(board);
        board[x][y] = 'K';

        for (int[] move : moves) {
            board[move[0]][move[1]] = '*';
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}