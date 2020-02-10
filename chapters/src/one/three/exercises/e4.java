package one.three.exercises;

import edu.princeton.cs.algs4.Stack;

import java.util.Scanner;

public class e4 {

    private static String s = new Scanner(System.in).next();
    private static boolean isRight = true;

    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '(' ||
                character == '[' ||
                character == '{') {
                stack.push(character);
            }
            else {
                char top = stack.pop();
                if (character == ')') {
                    if (stack.isEmpty()) isRight = false;
                    if (top != '(') isRight = false;
                }
                if (character == ']') {
                    if (stack.isEmpty()) isRight = false;
                    if (top != '[') isRight = false;
                }
                if (character == '}') {
                    if (stack.isEmpty()) isRight = false;
                    if (top != '{') isRight = false;
                }
            }
        }
        if (!stack.isEmpty()) isRight = false;
        System.out.println(isRight);
    }
}
