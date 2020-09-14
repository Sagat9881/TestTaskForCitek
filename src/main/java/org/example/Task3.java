package org.example;

public class Task3 {

    public static void main(String[] args) {

        int a = 21321230;
        Task3.lastBitRevers(a);
    }

    static void lastBitRevers(int a) {

        if (!(a % 10 == 0)) System.out.println("Введите корректное число");

        int b = a + 1;

         a = b | 1;
        System.out.println(a);
    }
}
