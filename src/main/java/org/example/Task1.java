package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    public static void main(String[] args) {

            Integer[] mass = {3, 5, 23, 54, 123, 54, 23, 12, 43, 6, 324, 12, 34, 2, 44, 1, 3, 56, 7, 2,
                    54, 6, 423, 435, 213, 2, 4, 2, 6, 7, 8, 9, 73, 64, 8, 6, 90, 0,3};

            Map<Integer, AtomicInteger> map= new HashMap<>();  // иницируем создание буферного списка, в котором будем сохранять число и количество вхождений

            for (int i = 0; i < mass.length; i++) {            // заполняем буфер значениями из исходного массива по типу: число-ключ, количество вхождений - значение
                if(map.containsKey(mass[i])){
                    map.get(mass[i]).incrementAndGet();        // Если буфер уже содержит число-ключ mass[i], то увеличиваем кол-во вхождения на 1
                } else{
                    map.put(mass[i], new AtomicInteger(1)); // Помещаем в буфер число-ключ(mass[i]), устанавливая количество вхождений на "1"
                }
            }
            List<Map.Entry<Integer, AtomicInteger>> entries = new ArrayList<>(map.entrySet());  // Иницируем создание итогового списка
            Collections.sort(entries, new Comparator<Map.Entry<Integer, AtomicInteger>> () {     // сортируем итоговый список с помощью инициализации анонимного компаратора, используя дефолтную реализацию класса Long
                public int compare(Map.Entry<Integer, AtomicInteger> a, Map.Entry<Integer, AtomicInteger> b) {
                    return Long.compare(
                            a.getValue().get() * ((long) Integer.MAX_VALUE) + a.getKey(),
                            b.getValue().get() * ((long) Integer.MAX_VALUE) + b.getKey());
                }
            });
            for (Map.Entry<Integer, AtomicInteger> entry : entries) {       // распечатка итогового списка
                System.out.println(entry.getKey() + "\t" + entry.getValue());
            }
        }
}

