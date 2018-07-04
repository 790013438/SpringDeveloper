import java.util.Arrays;

public class Compare {

    public static void main(String[] args) {
        System.out.println(max(new int[]{1, 3, 5, 7}));
    }

    private static int max (int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return arr[0] > arr[1] ? arr[0] : arr[1];
        } else {
            int i = max(Arrays.copyOfRange(arr, 1, arr.length));
            return arr[0] > i ? arr[0] : i;
        }
    }
}
