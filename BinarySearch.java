public class BinarySearch {

    public static void main(String[] args) {
        Integer list[] = new Integer[]{1, 3, 5, 7, 9};
        System.out.println(binarySearch(list, 1));
        System.out.println(binarySearch(list, -1));
    }

    static Integer binarySearch(Integer[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        while(low <= high) {
            int mid = low + (high - low);
            int guess = list[mid];
            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }
}
