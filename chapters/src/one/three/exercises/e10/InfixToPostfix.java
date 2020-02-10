package one.three.exercises.e10;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;

public class InfixToPostfix {

    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                stack.push(s);
            }
            else if (s.equals(")")) {
                System.out.print(stack.pop() + " ");
            }
            else if (s.equals("(")) {
                ;
            }
            else {
                System.out.print(s + " ");
            }
        }
    }
}
