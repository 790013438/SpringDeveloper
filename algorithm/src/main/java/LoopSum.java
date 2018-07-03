public class LoopSum {

    private static int sum(int[] arr) {
        int total = 0;
        for (int anArr : arr) {
            total += anArr;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 2, 3, 4})); //10
    }

}
