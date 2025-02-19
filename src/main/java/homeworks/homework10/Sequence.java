package homeworks.homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Sequence implements ByCondition {


    public static int[] filter(int[] array, ByCondition condition) {

        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (condition.isOk(array[i])) {
                result[i] = array[i];

            }
        }
        return result;
    }

    @Override
    public boolean isOk(int number) {
        return true;
    }




}
