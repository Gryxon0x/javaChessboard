package junit5;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ObstacleManagerTest {

    @Test
    void testPlaceObstacle() {
        // Tworzymy planszę 8x8 wypełnioną pustymi polami ('□')
        char[][] board = new char[8][8];
        for (char[] row : board) {
            java.util.Arrays.fill(row, '□');
        }

        // Inicjalizujemy ObstacleManager
        ObstacleManager manager = new ObstacleManager(board);

        // Umieszczamy przeszkodę na (2, 3)
        manager.placeObstacle(2, 3);

        // Sprawdzamy, czy w miejscu (2, 3) znajduje się 'X'
        assertThat(board[2][3], is('X'));
    }

    @Test
    void testPlaceObstacleInvalidPosition() {
        // Tworzymy planszę 8x8 wypełnioną pustymi polami ('□')
        char[][] board = new char[8][8];
        for (char[] row : board) {
            java.util.Arrays.fill(row, '□');
        }

        // Inicjalizujemy ObstacleManager
        ObstacleManager manager = new ObstacleManager(board);

        // Próba umieszczenia przeszkody poza planszą (-1, -1)
        manager.placeObstacle(-1, -1);

        // Sprawdzamy, że plansza nie została zmieniona w miejscu (-1, -1)
        assertThat(board[0][0], is('□'));  // Zamiast tego, nie powinno dojść do zmiany
    }

    @Test
    void testPlaceRandomObstacles() {
        // Tworzymy planszę 8x8 wypełnioną pustymi polami ('□')
        char[][] board = new char[8][8];
        for (char[] row : board) {
            java.util.Arrays.fill(row, '□');
        }

        // Inicjalizujemy ObstacleManager
        ObstacleManager manager = new ObstacleManager(board);

        // Umieszczamy 5 losowych przeszkód
        manager.placeRandomObstacles(5);

        // Sprawdzamy, że na planszy znajduje się dokładnie 5 przeszkód ('X')
        int count = 0;
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 'X') {
                    count++;
                }
            }
        }

        assertThat(count, is(5));
    }

    @Test
    void testPlaceRandomObstaclesNoOverlap() {
        // Tworzymy planszę 8x8 wypełnioną pustymi polami ('□')
        char[][] board = new char[8][8];
        for (char[] row : board) {
            java.util.Arrays.fill(row, '□');
        }

        // Inicjalizujemy ObstacleManager
        ObstacleManager manager = new ObstacleManager(board);

        // Umieszczamy 10 losowych przeszkód
        manager.placeRandomObstacles(10);

        // Sprawdzamy, czy nie ma żadnych nakładających się przeszkód
        int count = 0;
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 'X') {
                    count++;
                }
            }
        }

        assertThat(count, is(10)); // Sprawdzamy, czy na pewno umieściło 10 przeszkód
    }
}
