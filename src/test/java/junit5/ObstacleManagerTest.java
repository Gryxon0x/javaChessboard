package junit5;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Arrays;

public class ObstacleManagerTest {

    @Test
    void testPlaceObstacle() {
        char[][] board = new char[8][8];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, '□'));
        ObstacleManager manager = new ObstacleManager(board);
        manager.placeObstacle(2, 3);
        assertThat(board[2][3], is('X'));
    }

    @Test
    void testPlaceObstacleInvalidPosition() {
        char[][] board = new char[8][8];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, '□'));
        ObstacleManager manager = new ObstacleManager(board);
        manager.placeObstacle(-1, -1);
        assertThat(board[0][0], is('□'));
    }

    @Test
    void testPlaceRandomObstacles() {
        char[][] board = new char[8][8];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, '□'));
        ObstacleManager manager = new ObstacleManager(board);
        manager.placeRandomObstacles(5);
        long count = Arrays.stream(board)
                .flatMapToInt(row -> new String(row).chars())
                .filter(c -> c == 'X')
                .count();
        assertThat(count, is(5L));
    }

    @Test
    void testPlaceObstacleOnOccupiedCell() {
        char[][] board = new char[8][8];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, '□'));
        board[2][2] = 'X';
        ObstacleManager manager = new ObstacleManager(board);
        manager.placeObstacle(2, 2);
        assertThat(board[2][2], is('X'));
    }
}
