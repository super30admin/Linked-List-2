// Time Complexity : O(n) Going through half linked list and then reversing half linked list
// Space Complexity : O(1) No extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next==null || head.next.next==null) return;
        ListNode slow = head;
        ListNode fast = head;
        //Going to mid of linkedlist.
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is at the middle
        fast = reverse(slow.next);
        slow.next = null;
        //merge the lists
        //System.out.println(fast.val);
        slow = head;
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}