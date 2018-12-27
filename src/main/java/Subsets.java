package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Id: 78
 * Two methods are provided: 1,recursion method; 2, bit Operation
 *
 *
 */
public class Subsets {

    // Method 2 Bit operation
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int setValue = 1 << nums.length;

        for (int i = 0; i < setValue; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 <<j)) == (1 <<j)) {
                    item.add(nums[j]);
                }
            }
            result.add(item);
        }

        return result;
    }




    //method 1 recursion method
    /*public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();
        ArrayList<Integer> firstItem = new ArrayList<>();
        results.add(firstItem);
        generateResults(0, nums, item, results);
        return results;
    }

    void generateResults(int i, int[] nums, ArrayList<Integer> inItem, List<List<Integer>> result) {
        if (i >= nums.length) return;
        ArrayList<Integer> item = new ArrayList<>(inItem);
        item.add(nums[i]);
        result.add(item);
        generateResults(i + 1, nums, item, result);
        ArrayList<Integer> item2 = new ArrayList<>(inItem);
        generateResults(i+1, nums, item2, result);
    }*/

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] a = {1,2,3};
        subsets.subsets(a);

    }
}
