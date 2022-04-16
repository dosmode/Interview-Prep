package com.jackson.interviewPrep.easy.MergeTwoSortedLists;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    private MergeTwoSortedLists mergeTwoSortedLists;
    @BeforeEach
    void setup(){
        mergeTwoSortedLists = new MergeTwoSortedLists();
    }
    @Test
    void mergeTwoLists() {
        mergeTwoSortedLists.mergeTwoLists(new MergeTwoSortedLists.ListNode(1 , new MergeTwoSortedLists.ListNode(3)), new MergeTwoSortedLists.ListNode(2));
    }
}