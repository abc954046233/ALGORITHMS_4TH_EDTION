package one.three.exercises.e11;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class EvaluatePostfix {

    private static Stack<Integer> numbers = new Stack<>();

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) {
                numbers.push(numbers.pop() + numbers.pop());
            }
            else if (s.equals("*")) {
                numbers.push(numbers.pop() * numbers.pop());
            }
            else {
                int n = Integer.parseInt(s);
                numbers.push(n);
            }
        }
        System.out.println(numbers.pop());
    }
}
