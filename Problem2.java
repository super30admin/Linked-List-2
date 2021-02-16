// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Create two seperate list using slow/fast. Reverse second half. Merge with first half
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
        if(head==null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = head;
        ListNode toReverse = slow.next;
        slow.next = null;
        ListNode reverse = reverse(toReverse);

        while(curr!=null && reverse!=null){
            ListNode temp = curr.next;
            curr.next = reverse;
            ListNode temp1 = reverse.next;
            reverse.next = temp;
            curr = temp;
            reverse = temp1;
        }
    }

    private ListNode reverse(ListNode start){
        ListNode reverse = null;
        while(start!=null){
            ListNode temp = start.next;
            start.next = reverse;
            reverse = start;
            start = temp;
        }

        return reverse;
    }
}