package com.jackson.interview.coding.Grokking.SlidingWindow.introduction;

import com.jackson.interviewPrep.easy.twoSum.TwoSum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class ArrayOfSubarrayOfSizeK {

    /**
     * Let’s understand this problem with a real input:
     *
     * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
     * Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array. Let’s solve this:
     *
     * For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
     * The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
     * For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4
     * …
     * Here is the final output containing the averages of all contiguous subarrays of size 5:
     *
     * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
     * A brute-force algorithm will calculate the sum of every 5-element contiguous subarray of the given array and divide the sum by ‘5’ to find the average. This is what the algorithm will look like:
     */

    @Test
    void bruteForceSolution(){

        /**
         * Time complexity: Time complexity of the above algorithm will be O(N*K)O(N∗K) where ‘N’ is the number of elements in the input array.
         */
        double[] result = findAverage(5, new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println(Arrays.toString(result));
    }

    private static double[] findAverage(int k, int[] array){
        double[] result = new double[array.length + 1 - k];
        for (int i = 0; i <= array.length - k ; i++){
            double sum = 0.0;
            for(int j = i ; j < i + k ; j++){
                sum += array[j];
            }
            result[i] = sum/k;
        }


        return result;
    }
}