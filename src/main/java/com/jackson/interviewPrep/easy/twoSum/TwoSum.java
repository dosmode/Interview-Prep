package com.jackson.interviewPrep.easy.twoSum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwoSum {
    final String QuestionName = "TwoSum";

    @Autowired
    void twoSumResult(){
        System.out.println(QuestionName);
        //test case one
        final int[] nums = {2,7,11,15};
        final int target = 9;
        int[] result;
        result = twoSum(nums,9);
        for(int i : result){
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int initialCounter = 0 ;  initialCounter < nums.length -1 ; initialCounter++){
            for(int secondCounter = initialCounter + 1 ; secondCounter  < nums.length  ; secondCounter++){
                if (nums[initialCounter] + nums[secondCounter] == target ){
                    result[0] = initialCounter;
                    result[1] = secondCounter;
                }
            }
        }
        return result;
    }

}
