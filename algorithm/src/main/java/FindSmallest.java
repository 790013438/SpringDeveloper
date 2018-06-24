import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSmallest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 5, 1, 2, 6, 7, 10, -1));
        System.out.println(selectionSort(list));
    }

    private static <T extends Comparable<T>> int findSmallest(List<T> list) {
        T smallest = list.get(0);
        int smallest_index = 0;
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i).compareTo(smallest) < 0) {
                smallest = list.get(i);
                smallest_index = i;
            }
        }
        return smallest_index;
    }

    private static <T extends Comparable<T>> List<T> selectionSort(List<T> arrayList) {
        List<T> newList = new ArrayList<T>();
        int size = arrayList.size();
        for (int i = 0; i < size; ++i) {
            int smallest_index = findSmallest(arrayList);
            newList.add(arrayList.remove(smallest_index));
        }
        return newList;
    }

}
