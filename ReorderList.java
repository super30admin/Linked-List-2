// Time Complexity : O(n) where n is number of elemets in original linkedList
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
        if(head == null || head.next == null) return;

        //1. find middle of the linkedList
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //2. Reverse the half linkedList
        fast = reverse(slow.next);
        slow.next = null;

        //3. Remerging for solution
        slow = head;
        ListNode temp = slow.next;
        while(fast!=null){
            slow.next = fast;
            fast = fast.next;
            slow.next.next=temp;
            slow = temp;
            if(temp !=null)
                temp = temp.next;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while(fast!=null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }

        curr.next = prev;
        return curr;
    }
}