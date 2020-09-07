package homework03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public static final int PLUS_FAKE_WORD = 5;
    public static String tip = "";
    public static final String[] WORDS = new String[] {
            "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
            "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};
    public static final int LONGEST_WORD = longestWord(WORDS);


    public static void main(String[] args) {
        System.out.printf("Отгадай загаданное слово из списка:\n%s\n", Arrays.toString(WORDS));

        for (int i = 0; i < LONGEST_WORD; i++) {
            tip += "#";
        }

        Random random = new Random();
        int randomNum = random.nextInt(WORDS.length);
        String userIn = "";
        String hiddenWord = WORDS[randomNum];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            userIn = scanner.nextLine();
            if(Arrays.asList(WORDS).contains(userIn)) {
                if(hiddenWord.equals(userIn)) {
                    System.out.println("Отгадал!");
                    break;
                } else {
                    for (int i = 0; i < hiddenWord.length(); i++) {
                        isConsidence(i, hiddenWord.charAt(i), userIn);
                    }
                    System.out.println(tip);
                }
            } else {
                System.out.println("Такого слова нет в списке");
            }
        }
    }


    public static void isConsidence(int numSymbol, char symbol, String userIn) {
        String[] arrTip = tip.split("");
        for (int i = 0; i < userIn.length(); i++) {
            if(userIn.charAt(i) == symbol) {
                arrTip[numSymbol] = userIn.charAt(i) + "";
                tip = String.join("", arrTip);
                break;
            }
        }
    }

    public static int longestWord(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            int lengthWord = words[i].length();
            if (max < lengthWord) {
                max = lengthWord;
            }
        }
        return max + PLUS_FAKE_WORD;
    }

}
























