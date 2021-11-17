// 143 Reorder List
// solved on Leetcode
// Time complexity -- O(n)
// Space complexity -- O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            
            prev = head;
            head = temp;
        }
        
        return prev;
    }
    public void reorderList(ListNode head) {
        int length = 0;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        ListNode secondList = reverseList(slowPtr.next);
        slowPtr.next=null;
        
        while(secondList != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = secondList.next;
            
            head.next = secondList;
            secondList.next = temp1;
            head = temp1;
            secondList = temp2;
            
        
            //temp1.next = temp2;
        }
        
        
        
    }
}