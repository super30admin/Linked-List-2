// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We traverse through LL once to get count of nodes. Then we a start pointer which we will push ahead till counter is less than count / 2.
 * Then from start.next we will reverse the Linked List. And we will make start.next = null
 * Now we have 2 LL, so we merge them. As Strainght LL node points to 1st node of reversed LL and we go ahead.
 * This merging process will continue till, Reverse LL has nodes left
 * 
*/

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)return;
        int count = 0;
        ListNode start = head;
        
        while(start != null){
            start = start.next;
            count++;
        }
        
        // System.out.println(count);
        start = head;
        for(int i = 0; i < count/2;i++){
            start = start.next;
        }
        
        ListNode reverse = reverse(start.next);
        if(reverse == null)return;
        start.next = null;   
        ListNode curr = head;
        ListNode next = head.next;
        ListNode rev_next = reverse.next;
        while(rev_next != null){
            curr.next = reverse;
            reverse.next = next;
            curr = next;
            next = next.next;
            reverse = rev_next;
            rev_next = rev_next.next;
        }
        curr.next = reverse;
        reverse.next = next;
    }
    
    private ListNode reverse(ListNode curr){
        if(curr == null || curr.next == null)return curr;
        ListNode prev = null;
        ListNode next = curr.next;
        
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        
        curr.next = prev;
        
        return curr;
    }
}