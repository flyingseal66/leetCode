package main.java;

import java.util.*;

/**
 * Combination Sum II (40)
 *
 *
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> item = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        generateResults2(0, candidates, item, set, target, 0);
        return  new ArrayList<>(set);
    }

    void generateResults2(int i, int[] nums, ArrayList<Integer> inItem, Set<List<Integer>> set, int target, int sum) {
        if (i >= nums.length || sum > target) return;
        ArrayList<Integer> item = new ArrayList<>(inItem);
        sum += nums[i];
        item.add(nums[i]);
        if (sum == target && !set.contains(item)) {
            set.add(item);
        }
        generateResults2(i + 1, nums, item, set, target, sum);
        sum -= nums[i];
        ArrayList<Integer> item2 = new ArrayList<>(inItem);
        generateResults2(i + 1, nums, item2, set, target, sum);
    }

    public static void main(String[] args) {
        CombinationSumII subsets = new CombinationSumII();
        int[] a = {10,1,2,7,6,1,5};
        subsets.combinationSum2(a, 8);

    }
}
