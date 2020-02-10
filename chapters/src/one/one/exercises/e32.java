package one.one.exercises;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Scanner;

public class e32 {

    private static class Range {
        private static double left;
        private static double right;
        private static double low;
        private static double high;

        public static double getLeft() {
            return left;
        }

        public static double getRight() {
            return right;
        }

        public static double getLow() {
            return low;
        }

        public static double getHigh() {
            return high;
        }

        static void setLeft(double left) {
            Range.left = left;
        }

        static void setRight(double right) {
            Range.right = right;
        }

        static void setLow(double low) {
            Range.low = low;
        }

        static void setHigh(double high) {
            Range.high = high;
        }
    }

    private static int N;
    private static double l, r;

    private static double[] numbers;
    private static int[] count;
    private static int quantity;
    private static double space;
    private static double countPerHeight;

    private static void getNumbers() {
        for (int i = 0; i < quantity; i++) {
            numbers[i] = StdRandom.uniform((double) 0, (double) 100);
        }
    }

    private static void showNumbers() {
        for (double number : numbers) {
            System.out.println(number);
        }
    }
    private static void showCounts() {
        for (int i = 0; i < count.length; i++) {
            System.out.println((i + 1) + " " + count[i]);
        }
    }
    private static void showBasic() {
        System.out.println("N: " + N);
        System.out.println("l: " + l);
        System.out.println("r: " + r);
        System.out.println("space: " + space);
        System.out.println("quantity: " + quantity);
    }
    private static void printSplitLine() {
        System.out.println("------------------------------------------------------");
    }

    private static boolean isLegal(int index) {
        return index >= 0 && index < N;
    }
    private static int findIndex(double number) {
        double space = (r - l) / N;
        double distanceToL = number - l;
        int index = (int) (distanceToL / space);
        return index;
    }
    private static void updateCountWith(double number) {
        int index = findIndex(number);
        if (isLegal(index)) count[index]++;
    }

    private static void updateCount() {
        for (double number : numbers) {
            updateCountWith(number);
        }
    }

    private static void initialize() {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        l = scanner.nextDouble();
        r = scanner.nextDouble();

        Range.setLeft(0.1);
        Range.setRight(0.9);
        Range.setLow(0.1);
        Range.setHigh(0.9);

        quantity = 10000;
        numbers = new double[quantity];
        count = new int[N];

        updateSpace();
        getNumbers();
        updateCount();
    }

    private static void updateSpace() {
        space = (Range.getRight() - Range.getLeft()) / N;
    }
    private static void updateCountPerHeight() {
        double height = Range.high - Range.low;
        countPerHeight = (double) quantity / height;
        countPerHeight *= 0.05;
    }
    private static double getX(final int index) {
        double x = Range.getLeft() + space / 2 + index * space;
        return x;
    }
    private static double getY(final int index) {
        updateCountPerHeight();
        double high = Range.low + count[index] / countPerHeight;
        double y = (high + Range.low) / 2;
        return y;
    }
    private static void drawRectangular(final int index) {
        double x = getX(index);
        double y = getY(index);
        double halfWidth = space / 4;
        double halfHeight = y - Range.low;
        StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
    }
    private static void draw() {
        for (int index = 0; index < count.length; index++) {
            drawRectangular(index);
        }
    }

    public static void main(String[] args) {
        initialize();
        showNumbers();
        printSplitLine();
        showCounts();
        printSplitLine();
        updateSpace();
        showBasic();
        draw();
    }
}
