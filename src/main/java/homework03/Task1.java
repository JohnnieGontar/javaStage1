package homework03;

import java.util.Random;
import java.util.Scanner;

public class Task1 {

    private static final int ATTEMPT_NUM = 3;
    private static final int MAX_VAL = 9;

    public static void main(String[] args) {
        while (true) {
            playGame();
            if (repeatGame() == 0) {
                break;
            }
        }
    }

    public static boolean playGame() {
        System.out.printf("Загаданное число от 0 до %d; Количество попыток: %d%n", MAX_VAL, ATTEMPT_NUM);

        int hiddenNum = new Random().nextInt(MAX_VAL + 1);
        int num = 0;
        boolean result = false;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < ATTEMPT_NUM; i++) {
            num = checkUserVal(scanner);

            if(i == 2 && num != hiddenNum) {
                break;
            }

            if (num > hiddenNum) {
                System.out.printf("Загаданное число меньше; Осталость попыток: %d%n", (ATTEMPT_NUM - i - 1));
            } else if(num < hiddenNum) {
                System.out.printf("Загаданное число больше; Осталость попыток: %d%n", (ATTEMPT_NUM - i - 1));
            } else {
                System.out.println("Угадал!");
                result = true;
                break;
            }
        }

        if(!result) {
            System.out.printf("Проиграл; Число было %d", hiddenNum);
        }

        return result;
    }

    public static int checkUserVal(Scanner scanner) {
        int result = -1;
        while (result == -1) {
            try {
                String consoleLine = scanner.nextLine();
                int value = Integer.parseInt(consoleLine);
                if (value < 0 || value > MAX_VAL) {
                    System.out.println("Число вне диапазона, введи ещё раз!");
                    continue;
                }
                result = value;
            } catch (NumberFormatException e) {
                System.out.println("Это не число, введи ещё раз");
            }
        }
        return result;
    }

    public static int repeatGame() {
        System.out.println("\nПовторить игру еще раз? 1 – да / 0 – нет");
        Scanner scanner = new Scanner(System.in);
        int result = checkUserRepeatVal(scanner);
        if(result == 0) {
            System.out.println("Спасибо за игру!");
            scanner.close();
        }
        return result;
    }

    public static int checkUserRepeatVal(Scanner scanner) {
        int result = 0;
        String errorMsg = "Некорректный формат ответа. Введите 1, если да и 0, если нет";
        while (true) {
            if(!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println(errorMsg);
                continue;
            } else {
                result = Integer.parseInt(scanner.nextLine());
                if(result != 0 && result != 1) {
                    System.out.println(errorMsg);
                    continue;
                } else {
                    return result;
                }
            }
        }
    }

}