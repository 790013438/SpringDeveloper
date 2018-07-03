public class DivideBox {

    private static void divide(int length, int width) {
        if (width == 0) {
            System.out.println("划分结束");
        } else {
            int min = length > width ? width : length;
            int max = length < width ? width : length;
            int boxCount = max / min;
            System.out.println("大的方格：" + min + ", " + boxCount + "个");
            divide(min, max - boxCount * min);
        }
    }

    public static void main(String[] args) {
        divide(1680, 640);
    }
}
