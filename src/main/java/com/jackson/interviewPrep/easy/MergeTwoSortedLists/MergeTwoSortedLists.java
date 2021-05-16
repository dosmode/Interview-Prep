package com.jackson.interviewPrep.easy.MergeTwoSortedLists;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MergeTwoSortedLists {
    final String QuestionName = "Merge Two Sorted Lists";
    @Autowired
    void twoSumResult(){
        System.out.println(QuestionName);
        //test case one
        final ListNode l1 = new ListNode(1, new ListNode(3));
        final ListNode l2 = new ListNode(2,new ListNode(4));
        ListNode result;
        result = mergeTwoLists(l1,l2);
        System.out.println(result);
    }
//      Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0), current = newHead;
        while( l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null) current.next = l1;
        if(l2 != null) current.next = l2;
        return newHead.next;

    }

}
