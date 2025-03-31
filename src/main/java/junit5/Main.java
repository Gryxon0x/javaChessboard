package junit5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Pobieramy rozmiar planszy
        System.out.print("Podaj rozmiar planszy: ");
        while(!scanner.hasNextInt()){
            System.out.println("Błędne dane! Wprowadź liczbę całkowitą.");
            scanner.next(); // Odrzucenie błędnego wejścia
        }
        int size = scanner.nextInt();


        Chessboard chessboard = new Chessboard(size);

        // Pobieramy pozycję skoczka (x i y osobno)
        int knightCount;

        do {
            System.out.print("Podaj ilość skoczków: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Błędne dane! Wprowadź liczbę całkowitą większą od zera.");
                scanner.next(); // Odrzucenie błędnego wejścia
            }
            knightCount = scanner.nextInt();

            if (knightCount < 1 || knightCount > size * size) {
                System.out.println("Błędne dane! Wprowadź liczbę całkowitą większą od zera i mniejszą lub równą " + (size * size) + ".");
            }
        } while (knightCount < 1 || knightCount > size * size);

        List<Knight> knights = new ArrayList<>();
        List<int[]> knightPositions = new ArrayList<>();

        // Pobieramy współrzędne skoczków
        for (int i = 0; i < knightCount; i++) {
            int knightX, knightY = 0;
            boolean positionTaken;
            do {
                positionTaken = false;
                System.out.print("Podaj współrzędną X skoczka " + (i + 1) + " (dodatnia liczba): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("To nie jest liczba! Podaj poprawną wartość.");
                    scanner.next();
                }
                knightX = scanner.nextInt();

                // Walidacja, aby skoczek nie wyszedł poza planszę
                if (knightX < 0 || knightX >= size) {
                    System.out.println("Współrzędna X musi być w zakresie od 0 do " + (size - 1) + "!");
                    continue; // Jeżeli współrzędna jest niepoprawna, ponownie poproś o wpisanie
                }

                System.out.print("Podaj współrzędną Y skoczka " + (i + 1) + " (dodatnia liczba): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("To nie jest liczba! Podaj poprawną wartość.");
                    scanner.next();
                }
                knightY = scanner.nextInt();

                // Walidacja, aby skoczek nie wyszedł poza planszę
                if (knightY < 0 || knightY >= size) {
                    System.out.println("Współrzędna Y musi być w zakresie od 0 do " + (size - 1) + "!");
                    continue; // Jeżeli współrzędna jest niepoprawna, ponownie poproś o wpisanie
                }

                // Sprawdzamy, czy te współrzędne nie są już zajęte
                for (int[] pos : knightPositions) {
                    if (pos[0] == knightX && pos[1] == knightY) {
                        positionTaken = true;
                        System.out.println("Te współrzędne są już zajęte przez innego skoczka!");
                        break;
                    }
                }
            } while (knightX < 0 || knightY < 0 || knightX >= size || knightY >= size || positionTaken);

            knightPositions.add(new int[]{knightX, knightY});
            knights.add(new Knight(knightX, knightY));
        }

        for (Knight knight : knights) {
            chessboard.placeKnight(knight.getX(), knight.getY());
        }


        int obstacleCount;

        do {
            System.out.print("Podaj liczbę przeszkód (maksymalnie " + (size * size - knightCount) + "): ");
            while(!scanner.hasNextInt()){
                System.out.println("Błędne dane! Wprowadź liczbę całkowitą.");
                scanner.next(); // Odrzucenie błędnego wejścia
            }
            obstacleCount = scanner.nextInt();

            if (obstacleCount > (size * size - knightCount)) {
                System.out.println("Za duża liczba przeszkód! Spróbuj ponownie.");
            }
        } while (obstacleCount > (size * size - knightCount));

        chessboard.placeRandomObstacles(obstacleCount);

        // Wyświetlamy planszę
        System.out.println("\nPlansza z przeszkodami i ruchami skoczka:");
        chessboard.displayBoard();

        // Wypisujemy możliwe ruchy każdego skoczka
        System.out.println("\nMożliwe ruchy dla skoczków:");
        for (int i = 0; i < knights.size(); i++) {
            System.out.println("Skoczek " + (i + 1) + " (" + knightPositions.get(i)[0] + ", " + knightPositions.get(i)[1] + "):");
            List<int[]> moves = knights.get(i).getValidMoves(chessboard.getBoard());
            if (moves.isEmpty()) {
                System.out.println("Brak dostępnych ruchów.");
            } else {
                for (int[] move : moves) {
                    System.out.println("(" + move[0] + ", " + move[1] + ")");
                }
            }
            System.out.println();
        }

    }
}