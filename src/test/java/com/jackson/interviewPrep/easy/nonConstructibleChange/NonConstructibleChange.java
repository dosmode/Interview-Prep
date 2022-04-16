package com.jackson.interviewPrep.easy.nonConstructibleChange;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Template {
    @Test
    public void TestCase1() {
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        int expected = 20;
        var actual = new Program().nonConstructibleChange(input);

        assertTrue(expected == actual);
    }
}

class Program {
    public int nonConstructibleChange(int[] coins) {
        int[] sortedList =  Arrays.stream(coins).sorted().toArray();
        int createdChanges = 0;
        for(int element : sortedList){
            if(element > createdChanges + 1){
                return createdChanges + 1;
            }
            createdChanges += element;
        }
        return createdChanges +1;
    }
}

