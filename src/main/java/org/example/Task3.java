package org.example;

public class Task3 {

    public static void main(String[] args) {

        int a = 21321230;

        System.out.println(Integer.toBinaryString(Task3.lastBitRevers(a)));
    }

    static int lastBitRevers(int x) {
     return   x = ( x >> 1) << 1 | 1; }
}
