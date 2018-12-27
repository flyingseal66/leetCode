package main.java;

class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        int[] totalNums = new int[totalLength];

        boolean odevityFlag = (totalLength % 2) != 1;
        double middleNum1 = 0;
        double middleNum2 = 0;

        int stopNum1 = 0;
        int stopNum2 = 0;
        int pointer = 0;
        if(length1 > 0 && length2 > 0) {
            pointer = nums1[stopNum1] < nums2[stopNum2] ? 1 : 2;
        } else if (length2 == 0) {
            if (odevityFlag) return (nums1[length1/2] + nums1[(length1-1)/2])/2;
            return nums1[length1/2];
        } else if (length1 == 0){
            if (odevityFlag) return (nums2[length2/2] + nums2[(length2-1)/2])/2;
            return nums2[length2/2];
        }


        for (int i = 0; i < totalLength; i++) {
            if ((stopNum1 + stopNum2) == (totalLength)) {
                break;
            }
            if (pointer == 1) {
                if((stopNum1 == length1-1 && stopNum2 < length2) || (nums1[stopNum1] >= nums2[stopNum2] && stopNum2 < length2-1)) {
                    //stopNum1--;
                    pointer =2;
                }
                totalNums[i] = nums1[stopNum1];
                stopNum1++;

            } else {
                if((stopNum2 == length2-1 && stopNum1 < length1) || (nums2[stopNum2] >= nums1[stopNum1] && stopNum1 < length1-1)) {
                    //stopNum2--;
                    pointer = 1;
                }
                totalNums[i] = nums2[stopNum2];
                stopNum2++;
            }
        }

        System.out.println(totalNums);
        if (odevityFlag) {
            return (totalNums[totalLength/2] + totalNums[(totalLength-1)/2])/2;
        } else {
            return totalNums[totalLength/2];
        }




        /*for (int i = 0; i < totalLength; i++) {
            if (odevityFlag && (totalLength-1)/2 == i) {
                middleNum1 = pointer == 1 ? nums1[stopNum1] : nums2[stopNum2];
            }
            if (odevityFlag && (totalLength)/2 == i) {
                middleNum2 = pointer == 1 ? nums1[stopNum1] : nums2[stopNum2];
            }
            if (!odevityFlag && (totalLength)/2 == i) {
                if(pointer == 1 && nums1 != null) {
                    middleNum1 = nums1[stopNum1];
                }
                if(pointer == 2 && nums2 != null) {
                    middleNum1 = nums2[stopNum2];
                }
                middleNum2 = middleNum1;
            }

            if (nums1[stopNum1] < nums2[stopNum2] && stopNum1 < length1-1) {
                if(stopNum1 > 0) {
                    stopNum1++;
                }
                pointer = 1;

            } else if (stopNum2 < length2-1){
                if (stopNum2 > 0) {
                    stopNum2++;
                }
                pointer = 2;

            }
        }*/

    }


    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2};

        MedianofTwoSortedArrays median = new MedianofTwoSortedArrays();
        System.out.println(median.findMedianSortedArrays(arr1, arr2));
    }
}