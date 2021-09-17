package com.jackson.interview.coding.Grokking.SlidingWindow.MaxFruitCountOf2Types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class MaxFruitCountOf2Types {

    /**
     Problem Statement#
     Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

     You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

     Write a function to return the maximum number of fruits in both baskets.

     Example 1:

     Input: Fruit=['A', 'B', 'C', 'A', 'C']
     Output: 3
     Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
     Example 2:

     Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
     Output: 5
     Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
     This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
     */

    @BeforeEach
    void setup(){
        System.out.println("LongestSubstringKDistinct.setup");
    }

    @Test
    void slidingWindowSolution(){
        int result = findLength(new char[] {'A', 'B', 'C', 'A', 'C'});
        System.out.println(result);
    }
    @Test
    void slidingWindowSolution1(){
        int result = findLength(new char[] {'A', 'B', 'C', 'B', 'B', 'C'});
        System.out.println(result);
    }

    private static int findLength(char[] arr) {
        int result = 0;
        int windowStart = 0;
        Map<Character, Integer> collector = new HashMap<>();
        for(int endWindow =0 ; endWindow < arr.length ; endWindow++){
            collector.put(arr[endWindow], collector.getOrDefault(arr[endWindow],0)+1);
            while(collector.size()>2){
                collector.put(arr[windowStart], collector.get(arr[windowStart]) -1 );
                if(collector.get(arr[windowStart])==0){
                    collector.remove(arr[windowStart]);
                }
                windowStart++;
            }
            result = Math.max(result, endWindow - windowStart +1);
        }

        return result;
    }


}