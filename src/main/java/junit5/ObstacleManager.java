package junit5;

import java.util.Random;

public class ObstacleManager {
    private char[][] board;
    private int size;
    private Random random;

    public ObstacleManager(char[][] board) {
        this.board = board;
        this.size = board.length;
        this.random = new Random();
    }

    public void placeObstacle(int x, int y) {
        if (isValidPosition(x, y)) {
            board[x][y] = 'X';
        }
    }

    public void placeRandomObstacles(int count) {
        int placed = 0;
        while (placed < count) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);

            if (board[x][y] == '□') {
                board[x][y] = 'X';
                placed++;
            }
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size && board[x][y] == '□';
    }
}