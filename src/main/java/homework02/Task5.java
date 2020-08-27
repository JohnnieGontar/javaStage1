package homework02;

public class Task5 {
    public static void main(String[] args) {
        int[] arr = {17, 2, 8, 11, 9, 15, 6};
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
}
