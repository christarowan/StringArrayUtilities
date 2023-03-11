package com.zipcodewilmington;

import java.util.Arrays;
import java.util.*;




/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {

        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {

        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO

        public static String getSecondToLastElement(String[] array) {

            return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(String position : array){
            if (position.equals(value)){


            return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] result = new String[array.length];
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            String reverse = array[left];
            array[left] = array[right];
            array[right] = reverse;
            left++;
            right--;
        }
        return array;


    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String[] arr = array.clone();       //still playing with this to figure out how to get the correct result using .copy
        String[] reverse =(reverse(arr));

        if(Arrays.equals(reverse, array)) {
            return true;
        }
        return false;


    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Set<Character> alphaSet = new HashSet<Character>();
        for (char a : alphabet) {
            alphaSet.add(a);
        }

        Set<Character> inputSet = new HashSet<Character>();
        for(String s : array){
            for(char c : s.toCharArray()) {     // look at each character of array and evaluate whether every letter of
                if (c != ' ') { inputSet.add(Character.toLowerCase(c)); }
            }
        }

        if (alphaSet.equals(inputSet)) {
            return true;
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }

        }
        return count;
    }
    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO



    public static String[] removeValue(String[] array, String valueToRemove) {

        String[] result = new String[array.length];

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                result[j++] = array[i];
            }
        }

        return  Arrays.copyOf(result, j);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        //iterate through array, find duplicate chars, remove, return array of strings with dups removed
        List<String> result = new ArrayList<>();
        result.add(array[0]);
        for (int i = 1; i<array.length; i++) {
            if((array[i] != array[i - 1])){
                result.add(array[i]);
            }
        }
        return result.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<array.length; i++) {
            if (i == 0) {sb.append(array[i]);}
            else if (array[i].equals(array[i-1])) {
                sb.append(array[i]);

            }
            else {
                result.add(sb.toString());
                sb.setLength(0);
                sb.append(array[i]);

            }

        }
        result.add(sb.toString());
        return result.toArray(new String[0]);
    }



}
