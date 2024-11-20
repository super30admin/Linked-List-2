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
// Approach : 
// Step 1 : Find the middle of LL
// Step 2: Reverse the linkedlist from middle
// Step 3: Merge the LL's
// Time : O(n) + O(n/2) + O(n/2)
// Space : O(1)
class Solution {
    public void reorderList(ListNode head) {
        // Step 1 : Middle of LL
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverseLL(slow.next); // first reverse it and then loose the connection
        slow.next = null; 

        // reset pointer for LL1
        slow = head;

        // Now Merging the lists
        while(fast!=null){
            ListNode curr = slow.next;
            slow.next = fast;
            fast=fast.next;
            slow.next.next =curr;
            slow= curr;
        }
        
    }
    public ListNode reverseLL(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode fast = head.next;

        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next = prev;

        return curr;

    }
}