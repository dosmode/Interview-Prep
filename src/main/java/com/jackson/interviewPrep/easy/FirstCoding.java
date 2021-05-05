package com.jackson.interviewPrep.easy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FirstCoding {
    final String TEST = "HELLO?";


    @Autowired
    void testCaller(){
        System.out.println(TEST);
    }
}
