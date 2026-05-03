package recursion;

public class Example {
    public static void countdown(int i) {

        if (i <= 1) {
            System.out.println("Done!");
        } else {
            System.out.println(i);
            countdown(i - 1);
        }
    }

    public static int fact(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x * fact(x-1);
        }
    }
}
