package com.jackson.interview.coding.Grokking.SlidingWindow.ProblemChallenge1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SmallestSubarrayWithGivenSum {

    /**
     Permutation in a String (hard)#
     Given a string and a pattern, find out if the string contains any permutation of the pattern.

     Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

     abc
     acb
     bac
     bca
     cab
     cba
     If a string has ‘n’ distinct characters, it will have n!n! permutations.

     Example 1:

     Input: String="oidbcaf", Pattern="abc"
     Output: true
     Explanation: The string contains "bca" which is a permutation of the given pattern.
     Example 2:

     Input: String="odicf", Pattern="dc"
     Output: false
     Explanation: No permutation of the pattern is present in the given string as a substring.
     Example 3:

     Input: String="bcdxabcdy", Pattern="bcdyabcdx"
     Output: true
     Explanation: Both the string and the pattern are a permutation of each other.
     Example 4:

     Input: String="aaacb", Pattern="abc"
     Output: true
     Explanation: The string contains "acb" which is a permutation of the given pattern.
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