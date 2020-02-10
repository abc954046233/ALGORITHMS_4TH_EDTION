package one.three.exercises;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class e9 {

    private static Stack<String> numbers = new Stack<>();
    private static Stack<String> operators = new Stack<>();

    private static void judgeAndUpdate(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            operators.push(s);
        }
        else if (s.equals(")")) {
            String a, b, o;
            b = numbers.pop();
            o = operators.pop();
            a = numbers.pop();
            String expression = "(" +  " " + a + " " + o + " " + b + " " + ")";
            numbers.push(expression);
        }
        else {
            numbers.push(s);
        }
    }
    public static void main(String[] args) {
        String s;
        while (!StdIn.isEmpty()) {
            s = StdIn.readString();
            judgeAndUpdate(s);
        }
        assert !numbers.isEmpty();
        System.out.println(numbers.pop());
    }
}
