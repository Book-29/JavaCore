package homeworks.homework10;

import homeworks.homework10.Sequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ByCondition byCondition = number -> {
            return number % 2 == 0;
        };

        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        int[] intArray = Sequence.filter(array, byCondition);
        System.out.println(Arrays.toString(intArray));

        ByCondition byCondition2 = number -> {
            int sum = 0;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum % 2 == 0;
        };

        int[] sumArray = Sequence.filter(array,byCondition2);
        System.out.println(Arrays.toString(sumArray));

        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println("mustBeTrue: " + mustBeTrue);
        System.out.println("mustAlsoBeTrue: " + mustAlsoBeTrue);
        System.out.println("i: " + i);
        System.out.println("s: " + s);


    }
}
