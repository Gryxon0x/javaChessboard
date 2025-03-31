package junit5;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class KnightTest {

    @Test
    void testValidMovesOnEmptyBoard() {
        char[][] board = new char[8][8];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, '□'));
        Knight knight = new Knight(4, 4);
        assertThat(knight.getValidMoves(board), hasSize(8));
    }

    @Test
    void testValidMovesNearEdge() {
        char[][] board = new char[8][8];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, '□'));
        Knight knight = new Knight(0, 0);
        assertThat(knight.getValidMoves(board), hasSize(2));
    }

    @Test
    void testValidMovesBlockedByObstacles() {
        char[][] board = new char[8][8];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, '□'));
        board[2][3] = 'X';
        board[3][2] = 'X';
        Knight knight = new Knight(4, 4);
        assertThat(knight.getValidMoves(board), hasSize(6));
    }

    @Test
    void testNoValidMovesWhenSurrounded() {
        char[][] board = new char[8][8];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, 'X'));
        board[4][4] = '□';
        Knight knight = new Knight(4, 4);
        assertThat(knight.getValidMoves(board), is(empty()));
    }

    @Test
    void testKnightPosition() {
        Knight knight = new Knight(3, 5);
        assertThat(knight.getX(), is(3));
        assertThat(knight.getY(), is(5));
    }
}
