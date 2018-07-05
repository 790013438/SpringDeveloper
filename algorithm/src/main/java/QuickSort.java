import java.util.Arrays;
import java.util.stream.Stream;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 2, 1, 5, 4, 6, 7, 8};
        System.out.println(Arrays.toString(quickSort(array)));
    }

    private static Integer[] quickSort(Integer[] array) {
        if (array.length < 2) {
            return array;
        } else {
            Integer pivot = array[0];
            Integer[] lessArray = Stream
                    .of(array)
                    .filter(value -> value < pivot)
                    .toArray(Integer[]::new);
            Integer[] largeArray = Stream
                    .of(array)
                    .filter(value -> value > pivot)
                    .toArray(Integer[]::new);
            return Stream.of(quickSort(lessArray),
                    new Integer[]{pivot},
                    quickSort(largeArray))
                    .flatMap(Stream::of)
                    .toArray(Integer[]::new);
        }
    }
}
