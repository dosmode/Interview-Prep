package com.jackson.interviewPrep.easy.valid_Parentheses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class ValidParentheses {
    final String QuestionName = "Valid Parentheses";

    @Autowired
    void twoSumResult(){
        System.out.println(QuestionName);
        //test case one
        String test1= "()";
        boolean result = validParentheses("test1");
        System.out.println(result);

    }

    public boolean validParentheses(String s) {
        Stack<Character> parenthese = new Stack<>();
        int i = s.length();
        for(Character c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '[' ){
                parenthese.push(c);
                i--;
            }else if (!parenthese.empty() && c == ')' && parenthese.peek() == '('){
                parenthese.pop();
                i--;
            }else if (!parenthese.empty() && c == '}' && parenthese.peek() == '{'){
                parenthese.pop();
                i--;
            }else if (!parenthese.empty() && c == ']' && parenthese.peek() == '['  ){
                parenthese.pop();
                i--;
            }if(parenthese.empty() && i ==0){
                return true;
            }
        }
        return false;
    }

}
