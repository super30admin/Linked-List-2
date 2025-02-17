// Problem4 (https://leetcode.com/problems/intersection-of-two-linked-lists/)

// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, the lengths of two linked lists are found and the one with highest length should start from the nodes that are extra. While traversing
 * the place where they meet is the intersection. If they dont meet slow will return null.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = 0;
        ListNode slow = headA;
        while(slow!=null){
            slow=slow.next;
            count1++;
        }
        ListNode fast = headB;
        int count2 = 0;
        while(fast!=null){
            fast=fast.next;
            count2++;
        }
        slow = headA;
        fast = headB;
        if(count2>count1){
            int count = 0;
            while(count<(count2-count1)){
            fast = fast.next;
            count++;
        }
        }
        if(count1>count2){
            int count = 0;
            while(count<(count1-count2)){
            slow = slow.next;
            count++;
            }
        }
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        
        return slow;

    }
}