package homework04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 3;
    private static final char[][] map = new char[SIZE][SIZE];

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        prepareGame();
        playGame();
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек!");
                break;
            }

            if(isMapFull()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил искусственный интеллект!");
                break;
            }

            if(isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
        }

        System.out.println("Игра закончена!");
    }

    private static void prepareGame() {
        initMap();
        printMap();
    }

    private static boolean isMapFull() {
        for (char[] row : map) {
            for (char cell : row) {
                if(cell == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    @SuppressWarnings("RedundantIfStatement")
    private static boolean checkWin(char symbol) {
        if(map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
        if(map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
        if(map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;

        if(map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
        if(map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
        if(map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;

        if(map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
        if(map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) return true;

        return false;
    }

    private static void aiTurn() {
        int rowIndex, colIndex;
        do {
            rowIndex = random.nextInt(SIZE);
            colIndex = random.nextInt(SIZE);
        } while (!isCellValid(rowIndex, colIndex));

        map[rowIndex][colIndex] = DOT_O;
    }

    private static void humanTurn() {
        int rowIndex = -1, colIndex = -1;
        do {
            System.out.println("Введите координаты в формате '<номер строки> <номер колонки>'");
            String[] stringData = scanner.nextLine().split(" ");
            if(stringData.length != 2) {
                continue;
            }
            try {
                rowIndex = Integer.parseInt(stringData[0]) - 1;
                colIndex = Integer.parseInt(stringData[1]) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Были введены неккоректные данные!");
            }
        } while (!isCellValid(rowIndex, colIndex));

        map[rowIndex][colIndex] = DOT_X;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private static boolean isCellValid(int rowIndex, int colIndex) {
        if(rowIndex < 0 || rowIndex >= SIZE || colIndex < 0 || colIndex >= SIZE) {
            return false;
        }
        return map[rowIndex][colIndex] == DOT_EMPTY;
    }

    public static void printMap() {
        printColumnNumbers();
        printRows();
        System.out.println();
    }

    private static void printRows() {
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printColumnNumbers() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void initMap() {
        for (char[] row : map) {
            Arrays.fill(row, DOT_EMPTY);
        }
    }

}
