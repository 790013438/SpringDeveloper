public class Countdown {

    public static void main(String[] args) {
        countdown(7);
    }

    private static void countdown(int i) {
        System.out.println(i);
        if (i <= 0) {
            return;
        } else {
            countdown(i - 1);
        }
    }
}
