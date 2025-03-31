package junit5;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class KnightTest {

    @Test
    void testValidMovesOnEmptyBoard() {
        char[][] board = new char[8][8];
        for (char[] row : board) {
            java.util.Arrays.fill(row, '□');
        }

        Knight knight = new Knight(4, 4);
        List<int[]> moves = knight.getValidMoves(board);

        assertThat(moves, hasSize(8)); // Powinno być 8 możliwych ruchów
    }

    @Test
    void testValidMovesNearEdge() {
        char[][] board = new char[8][8];
        for (char[] row : board) {
            java.util.Arrays.fill(row, '□');
        }

        Knight knight = new Knight(0, 0);
        List<int[]> moves = knight.getValidMoves(board);

        assertThat(moves, hasSize(2)); // Powinny być tylko 2 możliwe ruchy
    }
}