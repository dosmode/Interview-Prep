package com.jackson.interviewPrep.Grokking.SlidingWindow.MaximumSumSubarrayOfSizeK;

import org.junit.jupiter.api.Test;


class ArrayOfSubarrayOfSizeK {

    /**
     Problem Statement#
     Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.

     Example 1:

     Input: [2, 1, 5, 1, 3, 2], k=3
     Output: 9
     Explanation: Subarray with maximum sum is [5, 1, 3].
     Example 2:

     Input: [2, 3, 4, 1, 5], k=2
     Output: 7
     Explanation: Subarray with maximum sum is [3, 4].
     */


    @Test
    void slidingWindowSolution(){
        int result = findMaxSumSubArrayOfSizeK(3, new int[] {2, 1, 5, 1, 3, 2});
        System.out.println(result);
    }

    private static int findMaxSumSubArrayOfSizeK(int k, int[] array){
       int windowSum = 0;
       int maxSum = 0;
       int windowStart =0;
       for(int windowEnd = 0 ; windowEnd < array.length-1 ; windowEnd++){
           windowSum += array[windowEnd];
           if(windowEnd >= k-1){
               maxSum = Math.max(maxSum,windowSum);
               windowSum -= array[windowStart];
               windowStart++;
           }
       }
       return maxSum;
    }
}