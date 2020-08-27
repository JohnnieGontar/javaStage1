package homework02;

import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) {
        shiftArray(new int[] {1, 2, 3, 4, 5}, 0);
        shiftArray(new int[] {1, 2, 3, 4, 5}, 1);
        shiftArray(new int[] {1, 2, 3, 4, 5}, 2);
        shiftArray(new int[] {1, 2, 3, 4, 5}, 5);
        shiftArray(new int[] {1, 2, 3, 4, 5}, 6);
        shiftArray(new int[] {1, 2, 3, 4, 5}, -1);
        shiftArray(new int[] {1, 2, 3, 4, 5}, -2);
        shiftArray(new int[] {1, 2, 3, 4, 5}, -5);
        shiftArray(new int[] {1, 2, 3, 4, 5}, -6);
    }


    private  static void shiftArray(int[] arr, int n) {
        int shiftNumber = n % arr.length;
        if(shiftNumber < 0) {
            shiftLeft(arr, Math.abs(shiftNumber));
        } else {
            shiftRight(arr, shiftNumber);
        }
        System.out.println(Arrays.toString(arr) + "; shiftNumber = " + n);
    }

    private static void shiftRight(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int lastValue = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = lastValue;
        }
    }

    private static void shiftLeft(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int firstValue = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = firstValue;
        }
    }

}
