import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 7};
        System.out.println(binarySearch(array, 1));
        System.out.println(binarySearch(array, 3));
        System.out.println(binarySearch(array, 5));
        System.out.println(binarySearch(array, 4));
    }

    static int binarySearch(Integer[] array, int target) {
        int low = 0;
        int high = array.length;

        while(low <= high) {
            int mid = (high - low) / 2 + low;
            int guess = array[mid];
            if (guess == target) {
                return mid;
            }
            if (guess < target) {
                low = mid + 1;
            }
            if (guess > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
