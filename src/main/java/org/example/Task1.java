package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    public static void main(String[] args) {

            Integer[] mass = {3, 5, 23, 54, 123, 54, 23, 12, 43, 6, 324, 12, 34, 2, 44, 1, 3, 56, 7, 2,
                    54, 6, 423, 435, 213, 2, 4, 2, 6, 7, 8, 9, 73, 64, 8, 6, 90, 0,3};

            Map<Integer, AtomicInteger> map= new HashMap<>();

            for (int i = 0; i < mass.length; i++) {
                if(map.containsKey(mass[i])){
                    map.get(mass[i]).incrementAndGet();
                } else{
                    map.put(mass[i], new AtomicInteger(1));
                }
            }
            List<Map.Entry<Integer, AtomicInteger>> entries = new ArrayList<>(map.entrySet());
            Collections.sort(entries, new Comparator<Map.Entry<Integer, AtomicInteger>>() {
                public int compare(Map.Entry<Integer, AtomicInteger> a, Map.Entry<Integer, AtomicInteger> b) {
                    return Long.compare(
                            a.getValue().get() * ((long) Integer.MAX_VALUE) + a.getKey(),
                            b.getValue().get() * ((long) Integer.MAX_VALUE) + b.getKey());
                }
            });
            for (Map.Entry<Integer, AtomicInteger> entry : entries) {
                System.out.println(entry.getKey() + "\t" + entry.getValue());
            }
        }
}

