package homework02;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(checkBalance(new int[] {2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(checkBalance(new int[] {1, 1, 1, 2, 1}));
        System.out.println(checkBalance(new int[] {3, 5}));
        System.out.println(checkBalance(new int[] {1, 2, 0, 0, 3}));
    }

    private static boolean checkBalance(int[] arr) {
        boolean result = false;
        int leftSum = 0;
        int rightSum = sum(arr, 0, arr.length);
        for (int i = 1; i < arr.length; i++) {
            leftSum += arr[i - 1];
            rightSum -= arr[i - 1];

            if (leftSum == rightSum) {
                System.out.println("Сумма левой и правой части массива равны = " + leftSum + "; index = " + i);
                result = true;
            }
        }
        System.out.println("========");
        return result;
    }

    private static int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
