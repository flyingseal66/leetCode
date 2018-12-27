package main.java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    // Time complexity O(nlogk)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i >= k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    // O(nlogn)
    /*public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }*/


    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(100);
        queue.add(1);
        queue.add(10);
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
