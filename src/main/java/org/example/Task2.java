package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Task2 {

    public static void main(String[] args) {

        String expression = "12[3б,][б  ([)] ]{}()45";

        System.out.println((isBalanced(expression)) ? "YES" : "NO");
    }


    public static boolean isBalanced(String expression) {

        expression = expression.replaceAll("[!\"#$%&'*+,-./:;<=>?@_~\\s]", "")  // удаляем из строки все символы, кроме скобок
                .replaceAll("[0-9]", "")
                .replaceAll("[а-яА-Я]", "");


        char[] braces = expression.toCharArray();                   // превращаем нормализованную строку в массив Char'ов
        if (braces.length % 2 != 0) {                               // Если длинна массива из нормализованной строки нечетная, значит одной парной скобки не хватает
            return false;
        }

        Map<Character, Character> endbrackets = new HashMap<>();   // буферный список, в котором мы связываем открывающую и закрывающую скобки для удобства проверки
        endbrackets.put('{', '}');
        endbrackets.put('[', ']');
        endbrackets.put('(', ')');
        if (endbrackets.get(braces[0]) == null) {                  // если первый элемент нормализованного массива не открывающая скобка, значит нарушена парность скобок и дальнейшие проверки не имеют смысла
            return false;
        }
        Stack<Character> stack = new Stack<>();                                          // иницируем создание стека
        for (Character c : braces) {                                                     // обходим каждый эелемент исходного нормализованного массива
            if (stack.isEmpty() && endbrackets.get(c) == null) {                         // если стек пустой или значение из нормализованного массива, используемое в качестве ключа к буферному списку, возвращает null
                return false;                                                            // то возвращаем false т.к. первый элемент нормализованного массива - открывающая скобка
            } else if (stack.isEmpty() || endbrackets.get(c) != null) {                  // стек пустой, но значение массива, используемое в качестве ключа к буферному списку не возвращает null
                stack.push(c);                                                           // значит, это открывающая скобка и мы кладем ее на вершину стека
            } else if (!stack.isEmpty() && endbrackets.get(stack.peek()).equals(c)) {    // стек не пустой, ключ с вершины стека возвращает значение, которое является закрывающей скобко.
                stack.pop();                                                             // которое сравнивается с элементом массива braces [c]
            } else {                                                                     // если возвращается true, значит braces [c] - закрывающая скобка, парность сохраняется
                return false;                                                            // если возвращается false, значит braces [c] - другая закрывающая скобка. Парность нарушена
            }
        }
        return stack.size() == 0;
    }


}


