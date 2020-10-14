package homework08;

import java.util.Arrays;
import java.util.Random;

public class TicTacToe {

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    private static final int SIZE = 5;
    private static final int DOTS_TO_WIN = 4;

    private static final char[][] map = new char[SIZE][SIZE];
    private static final Random random = new Random();
    public static final String PLAYER_WIN_MESSAGE = "Пользователь победил!";
    public static final String AI_WIN_MESSAGE = "Победил Искуственный Интеллект!";


    public static void prepareGame() {
        initMap();
    }

    private static boolean isMapFull() {
        for (char[] row : map) {
            for (char cell : row) {
                if (cell == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int checkEnd(char symbol) {
        if (checkWin(symbol)) {
            return 1;
        }
        if (isMapFull()) {
            return 2;
        }
        return 3;
    }

    private static boolean checkWin(char symbol) {
        if (checkRowsAndCols(symbol)) return true;
        return checkDiagonals(symbol);
    }

    private static boolean checkDiagonals(char symbol) {
        int mainDiagCounter = 0;
        int sideDiagCounter = 0;
        for (int i = 0; i < SIZE; i++) {
            mainDiagCounter = (map[i][i] == symbol) ? mainDiagCounter + 1 : 0;
            sideDiagCounter = (map[i][map.length - 1 - i] == symbol) ? sideDiagCounter + 1 : 0;
            if (mainDiagCounter == DOTS_TO_WIN || sideDiagCounter == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRowsAndCols(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int rowCounter = 0;
            int colCounter = 0;
            for (int j = 0; j < SIZE; j++) {
                rowCounter = (map[i][j] == symbol) ? rowCounter + 1 : 0;
                colCounter = (map[j][i] == symbol) ? colCounter + 1 : 0;
                if (rowCounter == DOTS_TO_WIN || colCounter == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] aiTurn() {
        int[] cell = getCellToBlockOpponent(DOT_O);
        if (cell == null) {
            cell = getCellToBlockOpponent(DOT_X);
            if (cell == null) {
                cell = getRandomEmptyCell();
            }
        }
        int rowIndex = cell[0];
        int colIndex = cell[1];
        setCell(rowIndex, colIndex, DOT_O);

        return cell;
    }

    private static int[] getRandomEmptyCell() {
        int rowIndex, colIndex;
        do {
            rowIndex = random.nextInt(SIZE);
            colIndex = random.nextInt(SIZE);
        } while (!isCellValid(rowIndex, colIndex));
        return new int[] {rowIndex, colIndex};
    }

    @SuppressWarnings("SameParameterValue")
    private static int[] getCellToBlockOpponent(char opponentSymbol) {
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
                if (map[rowIndex][colIndex] == DOT_EMPTY && isGameMoveWinning(rowIndex, colIndex, opponentSymbol)) {
                    return new int[]{rowIndex, colIndex};
                }
            }
        }

        return null;
    }

    private static boolean isGameMoveWinning(int rowIndex, int colIndex, char opponentSymbol) {
        setCell(rowIndex, colIndex, opponentSymbol);
        boolean result = checkWin(opponentSymbol);
        setCell(rowIndex, colIndex, DOT_EMPTY);
        return result;
    }

    private static void setCell(int rowIndex, int colIndex, char symbol) {
        map[rowIndex][colIndex] = symbol;
    }

    public static void humanTurn(String row, String col) {
        int rowIndex = Integer.parseInt(row);
        int colIndex = Integer.parseInt(col);

        setCell(rowIndex, colIndex, DOT_X);
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private static boolean isCellValid(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= SIZE || colIndex < 0 || colIndex >= SIZE) {
            return false;
        }

        return map[rowIndex][colIndex] == DOT_EMPTY;
    }


    private static void initMap() {
        for (char[] row : map) {
            Arrays.fill(row, DOT_EMPTY);
        }
    }

}
