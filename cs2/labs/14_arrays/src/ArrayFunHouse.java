import java.lang.System;
import java.lang.Math;

public class ArrayFunHouse {
//instance variables and constructors could be used, but are not really needed

    //getSum() will return the sum of the numbers from start(inclusive) to stop(inclusive)
    public static int getSum(int[] numArray, int start, int stop) {
        int sum = 0;
        for (int i = start; i <= stop; i++) {
            sum += numArray[i];
        }
        return sum;
    }

    //getCount() will return number of times val is present
    public static int getCount(int[] numArray, int val) {
        int count = 0;
        for (int i : numArray) {
            if (i == val) {
                count++;
            }
        }
        return count;
    }

    public static int[] removeVal(int[] numArray, int val) {
        int count = 0;
        int[] array = new int[numArray.length - getCount(numArray, val)];
        for (int a : numArray) {
            if (a != val) array[count++] = a;
        }
        return array;
    }
}
