import java.util.*;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */
    public int romanToInt(String s) {
        int sum = 0; // the integer
        // defining the values of roman characters
        String[] romanChars = {"IV", "IX", "XL", "XC", "CD", "CM", "I", "V", "X", "L", "C", "D", "M"};
        int[] romanCharValues = {4, 9, 40, 90, 400, 900, 1, 5, 10, 50, 100, 500, 1000};
        Map<String, Integer> romanToIntDict = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < 13; i++)
            romanToIntDict.put(romanChars[i], romanCharValues[i]);

        for (Map.Entry mapElement : romanToIntDict.entrySet()) {
            while (s.contains((String)mapElement.getKey())) {
                sum += (int)mapElement.getValue();
                s = s.replaceFirst((String)mapElement.getKey(), "");
            }
        }
        return sum;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */
    public static void recurPer(List<List<Integer>> ls, List<Integer> tmp, List<Integer> remaining, int size){
        // add a permutations to list
        if (tmp.size() == size)
            ls.add(tmp);

        else {
            for (int i = 0; i < remaining.size(); i++) {
                // adding all elements of tmp to tmp2
                List<Integer> tmp2 = new ArrayList<>();
                for (Integer I : tmp){
                    tmp2.add(I);
                }
                // adding a number to tmp2
                tmp2.add(remaining.get(i));

                // adding all elements of remaining to remaining2
                List<Integer> remaining2 = new ArrayList<>();
                for (Integer I : remaining){
                    remaining2.add(I);
                }
                // removing the number
                remaining2.remove(i);

                recurPer(ls, tmp2, remaining2, size);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        // to save all permutations
        List<List<Integer>> ls = new ArrayList<>();

        // current permutation
        List<Integer> tmp = new ArrayList<>();

        // putting all numbers to a list
        List<Integer> remaining =  new ArrayList<>();
        for (int num : nums) {
            remaining.add(num);
        }

        // a recursive method to find all permutations and put them
        // to the ls
        recurPer(ls, tmp, remaining, nums.length);

        return ls;
    }

    public static void main(String[] args) {}
}