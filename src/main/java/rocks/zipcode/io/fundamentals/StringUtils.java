package rocks.zipcode.io.fundamentals;


import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import com.google.common.collect.Collections2;
import rocks.zipcode.io.arrays.ArrayUtils;
import rocks.zipcode.io.collections.PowerSet;

/**
 * @author leon on 10/01/2019.
 */
public class StringUtils {
    /**
     * @param string - string to be evaluated
     * @return collection containing all permutations of casing of this string
     */
    public static Collection<String> getAllCasings(String string) {
        Collection<String> output = new ArrayList<>();
        // get length of string
        Integer length = string.length();
        // get range of length
        Integer[] range = ArrayUtils.getRange(0,length-1);
        // get power-set of range
        PowerSet<Integer> powerSet = new PowerSet<>(range);
        // for every set in power-set
        powerSet.permute().forEach(set -> output.add(upperCaseIndices(string,set.toArray(new Integer[0]))));
            // uppercase indices of string using set


        return output;
    }

    /**
     * @param string  - string to be evaluated
     * @param indices - indices to be evaluated
     * @return near-identical string whose characters at specified indices are capitalized
     */
    public static String upperCaseIndices(String string, Integer... indices) {
        StringBuilder sb = new StringBuilder(string);
        for(Integer index:indices){
            sb.setCharAt(index,Character.toUpperCase(sb.charAt(index)));
        }
        return sb.toString();
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param valueToBeInserted     - value to insert into string
     * @param index                 - string-index at which to insert value into string
     * @return near-identical string with `valueToBeInserted` inserted at `index`
     */
    public static String insertAtIndex(String stringToBeManipulated, String valueToBeInserted, Integer index) {
        StringBuilder sb = new StringBuilder(stringToBeManipulated);
        sb.insert(index,valueToBeInserted);
        return sb.toString();
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param replacementValue      - value to insert at `index`
     * @param index                 - position of string to be manipulated
     * @return near-identical string with character at `index` replaced with `replacementValue`
     */
    public static String replaceAtIndex(String stringToBeManipulated, Character replacementValue, Integer index) {
        StringBuilder sb = new StringBuilder(stringToBeManipulated);
        sb.setCharAt(index,replacementValue);
        return sb.toString();
    }
}