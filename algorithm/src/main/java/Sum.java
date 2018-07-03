public class Sum {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(sum(array));

        // 递归求和
        System.out.println(recursiveSum(array, array.length - 1));
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int anArr : arr) {
            sum += anArr;
        }
        return sum;
    }

    private static int recursiveSum(int[] arr, int stopIndex) {
        if (stopIndex < 0) {
            return 0;
        } else {
            return arr[stopIndex] + recursiveSum(arr, stopIndex - 1);
        }

    }
}
