import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortVsQuickSort {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = Stream
                .of("stream", "algorithm", "Algorithms")
                .collect(Collectors.toList());
        for (String str : list) {
            System.out.println(str);
        }
        list.forEach(System.out::println);

        for (String str : list) {
            Thread.sleep(1000);
            System.out.println(str);
        }
        list.forEach(i -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            });
    }

}
