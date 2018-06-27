import java.util.Arrays;
import java.util.Date;

public class SelectionSort2 {

    // this version uses raw arrays instead of ArrayList
    private static int[] selectionSort(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < newArr.length; ++i) {
            int smallestIndex = findSmallest(arr);
            newArr[i] = arr[smallestIndex];

            arr = getNewArrWithoutSmallest(arr, smallestIndex);
        }

        return newArr;
    }

    private static int[] getNewArrWithoutSmallest(int[] arr, int smallestIndex) {
        int[] newArrayWithoutSmallest = new int[arr.length - 1];
        for (int i = 0; i < arr.length && smallestIndex != 0; ++i) {
            if (i < smallestIndex) {
                newArrayWithoutSmallest[i] = arr[i];
            } else if (i > smallestIndex){
                newArrayWithoutSmallest[i - 1] = arr[i];
            }
        }
        return newArrayWithoutSmallest;
    }

    private static int findSmallest(int[] arr) {
        int smallest = arr[0];
        int smallestIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
}
