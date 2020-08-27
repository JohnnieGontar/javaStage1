package homework02;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        int last = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = arr[i][last - i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
