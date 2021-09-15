package com.jackson.interview.coding.Grokking.SlidingWindow.SmallestSubarrayWithGivenSum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SmallestSubarrayWithGivenSum {

    /**
     Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

     Example 1:

     Input: [2, 1, 5, 2, 3, 2], S=7
     Output: 2
     Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
     Example 2:

     Input: [2, 1, 5, 2, 8], S=7
     Output: 1
     Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
     Example 3:

     Input: [3, 4, 1, 1, 6], S=8
     Output: 3
     Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
     or [1, 1, 6].
     */

    @BeforeEach
    void setup(){
        System.out.println("SmallestSubarrayWithGivenSum.setup");
    }

    @Test
    void slidingWindowSolution(){
        int result = SmallestSubarrayWithGivenSum(7, new int[] {2, 1, 5, 2, 3, 2});
        System.out.println(result);
    }
    @Test
    void slidingWindowSolution1(){
        int result = SmallestSubarrayWithGivenSum(7, new int[] {2, 1, 5, 2, 8});
        System.out.println(result);
    }
    @Test
    void slidingWindowSolution2(){
        int result = SmallestSubarrayWithGivenSum(8, new int[] {3, 4, 1, 1, 6});
        System.out.println(result);
    }

//    @Test
//    void answer(){
//        int result = findMinSubArray(7, new int[] {1, 1, 1, 1, 1});
//        System.out.println(result);
//    }
    private static int SmallestSubarrayWithGivenSum(int k, int[] array){
        //in order to initialize the max value, use Integer.MAX_VALUE!
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int windowStart = 0;
        for(int windowEnd =0  ; windowEnd < array.length ; windowEnd++){
            sum += array[windowEnd];
            while(sum >=k){     //this was tricky..
                result = Math.min(result, windowEnd - windowStart +1);
                sum -= array[windowStart];
                windowStart++;
            }
        }
        return result;
    }

        public static int findMinSubArray(int S, int[] arr) {
            int windowSum = 0, minLength = Integer.MAX_VALUE;
            int windowStart = 0;
            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                windowSum += arr[windowEnd]; // add the next element
                // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
                while (windowSum >= S) {
                    minLength = Math.min(minLength, windowEnd - windowStart + 1);
                    windowSum -= arr[windowStart]; // subtract the element going out
                    windowStart++; // slide the window ahead
                }
            }

            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }
}