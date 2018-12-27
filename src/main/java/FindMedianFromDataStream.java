package main.java;

import java.util.*;


public class FindMedianFromDataStream {
    PriorityQueue<Integer> bigQueue;
    PriorityQueue<Integer> smallQueue;


    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        bigQueue = new PriorityQueue<>(Collections.reverseOrder());
        smallQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (bigQueue.size() == 0) {
            bigQueue.add(num);
            return;
        }
        if (smallQueue.size() == 0) {
            if (num > bigQueue.peek()) {
                smallQueue.add(num);
            } else {
                smallQueue.add(bigQueue.poll());
                bigQueue.add(num);
            }
            return;
        }

        int bigTop = bigQueue.peek();
        int smallTop = smallQueue.peek();
        int bigSize = bigQueue.size();
        int smallSize = smallQueue.size();
        if (bigSize == smallSize) {
            if (num > bigTop) {
                smallQueue.add(num);
            } else {
                bigQueue.add(num);
            }
        } else if (bigSize > smallSize) {
            if (num > bigTop) {
                smallQueue.add(num);
            } else {
                smallQueue.add(bigQueue.poll());
                bigQueue.offer(num);
            }
        } else {
            if (num > smallTop) {
                bigQueue.add(smallQueue.poll());
                smallQueue.add(num);
            } else {
                bigQueue.add(num);
            }
        }


    }

    public double findMedian() {
        int bigSize = bigQueue.size();
        int smallSize = smallQueue.size();

        if ((bigSize + smallSize) % 2 ==0) {
            return (bigQueue.peek() + smallQueue.peek())/2.0;
        } else if(bigSize > smallSize) {
            return bigQueue.peek();
        } else if (bigSize < smallSize) {
            return smallQueue.peek();
        }
        return 0;
    }


    // array method, which has a very high time complexity
    /*public void addNum(int num) {
        if(list.size() == 0) {
            list.add(num);
            return;
        }
        int length = list.size();
        for (int i = 0; i < length; i++) {
            if (list.get(i) > num) {
                if (i == 0) {
                    list.add(0, num);
                    return;
                } else {
                    list.add(i, num);
                    return;
                }
            }
        }
        list.add(num);
    }

    private double findMedian() {
        int length = list.size();
        if (length % 2 == 0) {
            return (double) (list.get(length/2) + list.get(length/2 - 1))/2;
        } else {
            return (double) list.get((length-1)/2);
        }
    }
    */



    public static void main(String[] args) {
        /*FindMedianFromDataStream stream = new FindMedianFromDataStream();
        stream.addNum(-1);

        stream.addNum(-2);

        stream.addNum(-3);

        stream.addNum(-4);
        System.out.println(stream.findMedian());
        stream.addNum(-5);
        System.out.println(stream.findMedian());*/

        int[][] a = new int[1][1];
        int[][] b = new int[1][1];
        a[0][0] = 0;
        b = a.clone();
        a[0][0] =8;
        int[] c = new int[4];
        System.out.println(c[0]);
    }
}
