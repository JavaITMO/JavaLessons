package ru.itmo.popova;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Класс ищет K числе с наибольшим количетсвом вхождений
 * Дан массив и число K. Найдите первые K самых часто встречающихся
 элементов.
 */
public class NumberOccurrences {
    Map<Integer, Integer> occurences = new HashMap<>();
    int lengthMAp = 0;
    /**
     * Ищет колличесво хождений числа
     * @param mass
     * @param n
     * @return
     */
    public static int findNumberOccurences(int[] mass, int n) {
        int result = 0;
        for (int i = 0; i < mass.length; i++) {
            if(mass[i] == n) {
                result++;
            }
        }
        return result;
    }

    /**
     * Создает маппу , если число ещё не встречалось,то кладет .
     * потом сортирует по колличетсву вхождений
     * @param mass
     * @return
     */
    public Map<Integer, Integer> sortRush (int[] mass) {

        for (int i = 0; i < mass.length; i++) {
            if(!occurences.containsKey(mass[i])) {
                occurences.put(mass[i], NumberOccurrences.findNumberOccurences(mass,mass[i]));
                System.out.println(mass[i]+ " " + NumberOccurrences.findNumberOccurences(mass,mass[i]));
                this.lengthMAp++;
            }
        }
        return occurences;
    }

    public Integer[] returnValueSort( Map<Integer, Integer> values) {
        Integer[] result = new Integer[this.lengthMAp];
        int i = 0;
        for( Integer entry : values.values()) {
            result[i++] = entry;
        }
        return result;
    }

    public Integer[] returnNumber(Integer[] sortOccurrences, int n) {
        int[] word = new int[this.lengthMAp];
        int i = 0;
        for( Integer entry : occurences.keySet()) {
            word[i++] = entry;
        }
        Integer[] key = sortOccurrences.clone();
        Arrays.sort(key, Collections.reverseOrder());
        for (int index = 0; index < n; index++ ) {
            for(int indexTw = 0; indexTw < this.lengthMAp; indexTw++) {
                if (key[index].equals(sortOccurrences[indexTw])) {
                    key[index] = word[indexTw];
                    sortOccurrences[indexTw] = -1;
                }
            }
        }

        return Arrays.copyOf(key,n);
    }

    public static void main(String[] args) {
        int[] mass = new int[] {22,33,44,55,22,33,44,44,22,55,66};

        NumberOccurrences result = new NumberOccurrences();
        Map<Integer, Integer> sort = result.sortRush(mass);
        Integer[] quite = result.returnValueSort(sort);
        Integer[] offer = result.returnNumber(quite,4);
        for (int i: offer
                ) {
            System.out.println(i);
        }
    }
}
