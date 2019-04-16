package rocks.zipcode.io.arrays;

import java.util.Arrays;

/**
 * @author leon on 24/01/2019.
 */
public class ArrayUtils {
    /**
     * @param start - value to begin counting
     * @param end   - value to stop counting
     * @return array of all integers between `start` and `stop`
     */
    public static Integer[] getRange(Integer start, Integer end) {
        Integer[] range = new Integer[1 + end - start];
        for (int i = start; i < end+1; i++) {
            range[i-start] = i;
        }
        return range;
    }

    /**
     * @param array - array to be unboxed
     * @return array with identical contents in primitive-array form
     */
    public static char[] unbox(Character[] array) {
        char[] output = new char[array.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = array[i];
        }


        return output;
    }

    /**
     * @param array - array to be boxed
     * @return array with identical contents in nonprimitive-array form
     */
    public static Character[] box(char[] array) {
        Character[] output = new Character[array.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = array[i];
        }


        return output;
    }
}
