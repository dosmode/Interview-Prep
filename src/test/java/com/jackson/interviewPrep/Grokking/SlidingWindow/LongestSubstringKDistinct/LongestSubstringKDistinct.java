package com.jackson.interviewPrep.Grokking.SlidingWindow.LongestSubstringKDistinct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class LongestSubstringKDistinct {

    /**
     Problem Statement#
     Given a string, find the length of the longest substring in it with no more than K distinct characters.

     Example 1:

     Input: String="araaci", K=2
     Output: 4
     Explanation: The longest substring with no more than '2' distinct characters is "araa".
     Example 2:

     Input: String="araaci", K=1
     Output: 2
     Explanation: The longest substring with no more than '1' distinct characters is "aa".
     Example 3:

     Input: String="cbbebi", K=3
     Output: 5
     Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
     Example 4:

     Input: String="cbbebi", K=10
     Output: 6
     Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
     */

    @BeforeEach
    void setup(){
        System.out.println("LongestSubstringKDistinct.setup");
    }

    @Test
    void slidingWindowSolution(){
        int result = findLength("araaci", 2);
        System.out.println(result);
    }
    @Test
    void slidingWindowSolution1(){
        int result = findLength("araaci", 1);
        System.out.println(result);
    }
    @Test
    void slidingWindowSolution2(){
        int result = findLength("cbbebi", 3);
        System.out.println(result);
    }
    @Test
    void slidingWindowSolution3(){
        int result = findLength("cbbebi", 10);
        System.out.println(result);
    }
//    @Test
//    void answer(){
//        int result = findMinSubArray(7, new int[] {1, 1, 1, 1, 1});
//        System.out.println(result);
//    }
    private static int findLength(String str, int k) {
        int result = 0;
        int startWindow =0;
        Map<Character,Integer> containerMap = new HashMap<>();
        for(int endWindow =0 ; endWindow < str.length() ; endWindow++){
            containerMap.put(str.charAt(endWindow), containerMap.getOrDefault(str.charAt(endWindow),0) + 1);
            while(containerMap.size()>k){
                containerMap.put(str.charAt(startWindow), containerMap.get(str.charAt(startWindow))-1);
                if(containerMap.get(str.charAt(startWindow)) == 0){
                    containerMap.remove(str.charAt(startWindow));
                }
                startWindow++;
            }
            result = Math.max(result, endWindow - startWindow + 1 );
        }
        return result;
    }

    public static int findLength1(String str, int k) {
//        if (str == null || str.length() == 0)
//            throw new IllegalArgumentException();

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }
}