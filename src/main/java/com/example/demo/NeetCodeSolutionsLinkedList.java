package com.example.demo;

public class NeetCodeSolutionsLinkedList {
    /**
     * Definition for singly-linked list.*/
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {

        //Find the half point of the list
        ListNode slow = head;
        ListNode fast = slow.next;
        while(fast.next != null) {
            slow = slow.next;
            fast=fast.next;
            if(fast.next != null) {
                fast=fast.next;
            }

        }

        //Reverse the second half
        ListNode secondHalf = slow.next;
        ListNode previous = slow.next = null;
        while(secondHalf!=null) {
            ListNode tmp = secondHalf.next;
            secondHalf.next = previous;
            previous = secondHalf;
            secondHalf = tmp;
        }

        //Reorder by shifting between first half and second half
        ListNode first = head;
        secondHalf = previous;
        while (secondHalf != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = secondHalf.next;
            first.next = secondHalf;
            secondHalf.next = tmp1;
            first = tmp1;
            secondHalf = tmp2;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode far = head;
        //Move far pointer n spaces ahead of slow
        for(int i=0; i<n+1; i++) {
            far = far.next;
        }

        //Move both far and slow until far reaches end of linked list
        while(far.next!=null) {
            slow = slow.next;
            far = far.next;
        }

        ListNode nodeToRemove = slow.next;
        ListNode nodeToConnect = nodeToRemove.next;
        slow.next = nodeToConnect;

        return head;

    }
}
