public class Countdown {

    public static void main(String[] args) {
        countdown(7);
    }

    private static void countdown(int i) {
        if (i > 0) {
            System.out.println(i);
            countdown(i - 1);
        }
    }
}
