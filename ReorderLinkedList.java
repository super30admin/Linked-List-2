// Time Complexity - O(n) for finding middle + O(n) for reversing second half + O(n) for making final list -- hence combined O(n)
// Space Cmplexity - O(1) -- as done in place without using extra space -- check once
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
        if(head==null || head.next==null || head.next.next==null) return;
        ListNode slow = head;
        ListNode fast = head;
        // find middle
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the second half
        ListNode prev = null;
        ListNode curr = slow.next;
        fast = slow.next.next;
        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        slow.next = null;
        slow = head;
        
        //Make final list
        ListNode temp = slow.next;
        while(curr!=null){
            slow.next = curr;
            curr = curr.next;
            slow.next.next = temp;
            slow = temp;
            temp = temp.next;
        }
        

    }
}