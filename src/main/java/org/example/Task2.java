package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Task2 {

    public static void main(String[] args) {

         String expression = "12[3б,][б  ([)] ]{}()45";

         System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }


    public static boolean isBalanced(String expression) {

        expression = expression.replaceAll("[!\"#$%&'*+,-./:;<=>?@_~\\s]","")
                               .replaceAll("[0-9]","")
                               .replaceAll("[а-яА-Я]","");


        char[] braces = expression.toCharArray();
        if (braces.length % 2 != 0) {
            return false;
        }

        Map<Character, Character> endbrackets = new HashMap<>();
        endbrackets.put('{', '}');
        endbrackets.put('[', ']');
        endbrackets.put('(', ')');
        if (endbrackets.get(braces[0]) == null) {
            return false;
        }
        Stack <Character> stack = new Stack<>();
        for (Character c : braces) {
            if (stack.isEmpty() && endbrackets.get(c) == null) {
                return false;
            } else if (stack.isEmpty() || endbrackets.get(c) != null) {
                stack.push(c);
            } else if (!stack.isEmpty() && endbrackets.get(stack.peek()).equals(c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.size() == 0;
    }


}


