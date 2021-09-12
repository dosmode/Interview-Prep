package com.jackson.interviewPrep.easy.twoSum;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;



class TwoSumTest {

    @InjectMocks
    private static TwoSum mTwosum;

    private static int[] test1;
    private static int[] test2;
    private static int[] test3;
    private static int target1;
    private static int target2;
    private static int target3;

//    Example 1:
//
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//    Example 2:
//
//    Input: nums = [3,2,4], target = 6
//    Output: [1,2]
//    Example 3:
//
//    Input: nums = [3,3], target = 6
//    Output: [0,1]
    @BeforeAll
    static void setup(){
        mTwosum = new TwoSum();
        test1 = new int[]{2, 7, 11, 15};
        test2 = new int[]{3,2,4};
        test3 = new int[]{3,3};
        target1 = 9;
        target2 = 6;
        target3 = 6;
    }
    @Test
    void twoSumFirstExampleShouldPassTheUnitTest() {
        int[] result = {0,1};
        assertArrayEquals(mTwosum.twoSum(test1, target1), result);
    }

    @Test
    void twoSumSecondExampleShouldPassTheUnitTest() {
        int[] result = {1,2};
        assertArrayEquals(mTwosum.twoSum(test2, target2), result);
    }

    @Test
    void twoSumThirdExampleShouldPassTheUnitTest() {
        int[] result = {0,1};
        assertArrayEquals(mTwosum.twoSum(test3, target3), result);
    }


    @Test
    void test(){
        int[] result = {0,1};

//        2,7,11,15], target = 9
        int[] test =  twoSum(new int[]{2,7,11,15}, 9);
        for(int a : test){
            System.out.println(a);
        }

        assertArrayEquals(mTwosum.twoSum(new int[]{2,7,11,15}, 9), result);

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