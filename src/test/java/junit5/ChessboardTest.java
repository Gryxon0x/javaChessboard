package junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ChessboardTest {
    private Chessboard chessboard;
    @BeforeEach
    void setUp() {
        chessboard = new Chessboard(5);
    }

    @Test
    void shouldThrowExceptionForInvalidSize() {
        assertThrows(IllegalArgumentException.class, () -> new Chessboard(1));
    }

    @Test
    void shouldInitializeEmptyBoard() {
        assertThat(chessboard.getBoard(), arrayWithSize(5));
        assertThat(chessboard.getBoard()[0].length, is (5));
        assertThat(chessboard.getBoard()[0], equalTo(new char[]{'□', '□', '□', '□', '□'}));
    }

    @Test
    void shouldPlaceObstacle() {
        chessboard.placeObstacle(2, 2);
        assertThat(chessboard.getBoard()[2][2], is(not('□')));
    }

    @Test
    void shouldPlaceKnight() {
        chessboard.placeKnight(3, 3);
        assertThat(chessboard.getBoard()[3][3], is('K'));
    }

    @Test
    void shouldNotPlaceKnightOnObstacle() {
        chessboard.placeObstacle(2, 2);
        chessboard.placeKnight(2, 2);
        assertThat(chessboard.getBoard()[2][2], is(not('K')));
    }

    @Test
    void testChessboardInitialization() {
        Chessboard board = new Chessboard(8);
        assertThat(board, notNullValue());
    }

    @Test
    void testPlaceObstacle() {
        Chessboard board = new Chessboard(8);
        board.placeObstacle(3, 3);

        // Sprawdzamy, czy przeszkoda została dodana poprawnie
        board.displayBoard(); // Wizualnie możemy sprawdzić
    }
}