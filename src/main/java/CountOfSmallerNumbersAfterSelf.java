package main.java;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Pair<Integer, Integer>> vec = new ArrayList<>();
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            vec.add(new Pair<>(nums[i], i));
            count[i] = 0;
        }
        mergeSort(vec, count);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }
        return result;
    }


    void mergeSort(List<Pair<Integer, Integer>> list, int[] count) {
        List<Pair<Integer, Integer>> list2 = new ArrayList<>(list);
        int mid = list2.size()/2;
        List<Pair<Integer, Integer>> left = new ArrayList<>();
        List<Pair<Integer, Integer>> right = new ArrayList<>();
        int[] count2 = deepCopySingle(count);
        int[] count3 = deepCopySingle(count);
        if (list2.size() <= 1) {
            return;
        }

        int i = 0;
        for (; i < mid; i++) {
            left.add(list2.get(i));
        }
        for (; i < list2.size(); i++) {
            right.add(list2.get(i));
        }
        mergeSort(left, count);
        mergeSort(right, count);
        list.removeAll(list);
        mergeSortTwoArray(left, right, list, count);
    }

    void mergeSortTwoArray(List<Pair<Integer, Integer>> arr1, List<Pair<Integer, Integer>> arr2,
                           List<Pair<Integer, Integer>> result, int[] count) {
        int[] count2 = deepCopySingle(count);
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i).getKey() <= arr2.get(i).getKey()) {
                count[arr1.get(i).getValue()] += j;
                result.add(arr1.get(i));
                i++;
            } else {
                result.add(arr2.get(j));
                j++;
            }
        }
        for (; i < arr1.size(); i ++) {
            count[arr1.get(i).getValue()] += j;
            result.add(arr1.get(i));
        }
        for (; j < arr2.size(); j ++) {
            result.add(arr2.get(j));
        }
    }

    public static int[] deepCopySingle(int[] original) {
        int[] nv = new int[original.length];
        for (int i = 0; i < nv.length; i++) {
            nv[i] = original[i];
        }
        return  nv;
    }


    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf self = new CountOfSmallerNumbersAfterSelf();
        int[] list1 = new int[10];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        list1[0] = 1;
        list1[1] = 9;
        list1[2] = 9;
        list1[3] = 9;
        list1[4] = 5;
        list1[5] = 2;
        list1[6] = 4;
        list1[7] = 3;
        list1[8] = 5;
        list1[9] = 3;

        self.countSmaller(list1);
        System.out.println(list1);
    }
}
