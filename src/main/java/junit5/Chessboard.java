package junit5;

import java.util.ArrayList;
import java.util.List;

public class Chessboard {
    private int size;
    private char[][] board;
    private ObstacleManager obstacleManager;
    private List <Knight> knights;

    public Chessboard(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Size must be at least 2");
        }
        this.size = size;
        this.board = new char[size][size];
        this.obstacleManager = new ObstacleManager(board);
        this.knights = new ArrayList<>();
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '□'; // Puste pole
            }
        }
    }

    public void placeObstacle(int x, int y) {
        obstacleManager.placeObstacle(x, y);
    }

    public void placeRandomObstacles(int count) {
        obstacleManager.placeRandomObstacles(count);
    }

    public void placeKnight(int x, int y) {
        if (isValidPosition(x, y)) {
            knights.add(new Knight(x, y));
            board[x][y] = 'K';
        }
    }

    public void displayBoard() {
        char[][] displayBoard = new char[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(board[i], 0, displayBoard[i], 0, size);
        }

        for (Knight knight : knights) {
            knight.displayPossibleMoves(displayBoard);
        }

        for (char[] row : displayBoard) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        showMoves();
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size && board[x][y] == '□';
    }

    private void showMoves(){
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                if(board[x][y]=='*'){
                    System.out.println("("+x+") ("+y+")");
                }
            }
        }
    }

    public char[][] getBoard(){
        return board;
    }
}