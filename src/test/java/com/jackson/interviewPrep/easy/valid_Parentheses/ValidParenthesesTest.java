package com.jackson.interviewPrep.easy.valid_Parentheses;

import com.jackson.interviewPrep.easy.twoSum.TwoSum;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    private static ValidParentheses mValidParenthese = new ValidParentheses();

    @Test
    void validParenthesesCase1ShouldSuccess() {
        assertTrue(mValidParenthese.validParentheses("()"));
    }

    @Test
    void validParenthesesCase2ShouldSuccess() {
        assertTrue(mValidParenthese.validParentheses("()[]{}"));
    }

    @Test
    void validParenthesesCase3ShouldReturnFalse() {
        assertFalse(mValidParenthese.validParentheses("(]"));
    }

    @Test
    void validParenthesesCase4ShouldReturnFalse() {
        assertFalse(mValidParenthese.validParentheses("([)]"));
    }

    @Test
    void validParenthesesCase5ShouldSuccess() {
        assertTrue(mValidParenthese.validParentheses("{[]}"));
    }

    @Test
    void validParenthesesCase6ShouldSuccess() {
        assertFalse(mValidParenthese.validParentheses("(){}}{"));
    }
}