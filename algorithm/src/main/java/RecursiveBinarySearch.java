import java.util.Arrays;

public class RecursiveBinarySearch {

    private static int recursiveBinarySearch(int[] array, int item, int low ,int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >>> 1);
        int guess = array[mid];
        if (guess == item) {
            return mid;
        }

        if (guess < item) {
            return recursiveBinarySearch(array, item, mid + 1, high);
        } else {
            return recursiveBinarySearch(array, item, low, mid - 1);
        }
    }

    private static int binarySearch(int[] array, int item) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            int guess = array[mid];
            if (guess == item) {
                return mid;
            }
            if (guess < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 9}, 5));
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 9}, 4));
        System.out.println();

        int[] array = new int[]{1, 3, 5, 7, 9};
        System.out.println(recursiveBinarySearch(array, 5, 0, array.length - 1));
        System.out.println(recursiveBinarySearch(array, 4, 0, array.length - 1));
        array = new int[]{1, 3, 5, 6, 7, 9};
        System.out.println(recursiveBinarySearch(array, 6, 0, array.length - 1));
        System.out.println(binarySearch(new int[]{1, 3, 5, 6, 7, 9}, 6));
    }
}
