package one.one.exercises;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Scanner;

public class e31 {

    private static int N;
    private static double p;
    // 用两个一维数组存储第i个点的横纵坐标
    private static double[] x;
    private static double[] y;
    private static double angle;    // 每一份的角度，数值上等于2pi / N

    private static void initialize() {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        p = scanner.nextDouble();
        x = new double[N];
        y = new double[N];
        angle = (double) 2 * Math.PI / N;
    }

    private static void printInfo() {
        System.out.println("N: " + N);
        System.out.println("P: " + p);
        System.out.println("angle: " + angle);
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }
    // currentAngle代表当前点与圆心连线和x轴的夹角，nextAngle为下一个要画点与圆心连线和x轴的夹角
    // centerX, centerY, radius代表题目中所规定圆的圆心，半径
    private static double[] drawNextPoint(double currentAngle, double centerX, double centerY, double radius) {
        double nextX, nextY;
        double nextAngle;
        // 更新下一个点的横纵坐标
        nextAngle = currentAngle + angle;
        nextX = centerX + radius * Math.cos(nextAngle);
        nextY = centerY + radius * Math.sin(nextAngle);
        // 以下一个点为圆心画大小为0.05的点
        StdDraw.circle(nextX, nextY, 0.05);
        // 返回该点横纵坐标用于更新数组xy
        double[] position = new double[2];
        position[0] = nextX;
        position[1] = nextY;
        return position;
    }
    private static void upDatePoints(double x, double y, int i) {
        e31.x[i] = x;
        e31.y[i] = y;
    }
    private static void drawNPoints() {
        final double centerX = 0.5;
        final double centerY = 0.5;
        final double radius = 0.25;

        double currentAngle = 0;
        double[] position;
        for (int i = 0; i < N; i++) {
            position = drawNextPoint(currentAngle, centerX, centerY, radius);
            upDatePoints(position[0], position[1], i);
            currentAngle += angle;
        }
    }

    private static void drawLines() {
        StdDraw.setPenColor(StdDraw.GRAY);
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (i == j) continue;
                else {
                    if (StdRandom.bernoulli(p)) {
                        StdDraw.line(x[i], y[i], x[j], y[j]);
                    }
                }
            }
        }
        StdDraw.setPenColor(StdDraw.BLACK); // 避免方法的副作用
    }

    public static void main(String[] args) {
        initialize();
        drawNPoints();
        drawLines();
        printInfo();
    }
}
