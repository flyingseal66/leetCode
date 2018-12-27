package main.java;

import java.util.*;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        subsets(nums, set);
        List<List<Integer>> lists = new ArrayList<>(set);
        return lists;
    }

    public void subsets(int[] nums, Set<List<Integer>> set) {
        int setValue = 1 << nums.length;
        for (int i = 0; i < setValue; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 <<j)) == (1 <<j)) {
                    item.add(nums[j]);
                }
            }
            set.add(item);
        }
    }
    public static void main(String[] args) {
        SubsetsII subsets = new SubsetsII();
        int[] a = {2,1,2,2};
        subsets.subsetsWithDup(a);

    }
}
