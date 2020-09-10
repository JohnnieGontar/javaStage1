package homework04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTakCopy {

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 3;
    private static final char[][] map = new char[SIZE][SIZE];

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    public static final String PLAYER_WIN_MESSAGE = "Пользователь победил!";
    public static final String AI_WIN_MESSAGE = "Победил Искуственный Интеллект!";

    public static void main(String[] args) {
        prepareGame();
        playGame();
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkEnd(DOT_X, PLAYER_WIN_MESSAGE))
                break;

            aiTurn();
            printMap();
            if (checkEnd(DOT_O, AI_WIN_MESSAGE))
                break;
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

        int rowCount = 0;                  // количество символов в строке
        int[] columnCount = new int[SIZE]; // количество символов в колонке
        int[] numRowOfColumn = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == symbol) {
                    rowCount++;
                    columnCount[j]++;
                    numRowOfColumn[i]++;
                    if(rowCount == DOTS_TO_WIN) return true;
                }
            }
            rowCount = 0;
        }

        int leftToRight = 0;
        int rightToLeft = 0;

        for (int i = 0; i < SIZE; i++) {
            if(columnCount[i] == DOTS_TO_WIN) return true;

            for(int j = 0; j < SIZE; j++) {
                if(i == j && columnCount[i] != 0 && numRowOfColumn[j] != 0) {
                    leftToRight++;
                }
            }
        }

        if(leftToRight == DOTS_TO_WIN) return true;

        System.out.println(Arrays.toString(columnCount));
        System.out.println(Arrays.toString(numRowOfColumn));

//        if(map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
//        if(map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
//        if(map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;
//
//        if(map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
//        if(map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
//        if(map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;
//
//        if(map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
//        if(map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) return true;

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

    private static boolean checkEnd(char symbol, String winMessage) {
        if (checkWin(symbol)) {
            System.out.println(winMessage);
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    public static void initMap() {
        for (char[] row : map) {
            Arrays.fill(row, DOT_EMPTY);
        }
    }

}
