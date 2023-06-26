// Time Complexity : O(n)
// Space Complexity : O(1)
    // n is the number of nodes present in the linked list.

// Your code here along with comments explaining your approach
    //We first have to find the middle and break it there. We have the 2 halves. Reverse the second half. Merge it with first half, one node from each half.
    //We use 2 pointers, slow and fast. The slow moves by 1 node, fast moves b 2 nodes. When fast reaches null, slow points to the middle. Make the "slow.next" null.
    //Reverse the second half. Then merge it one node from each linked list.
    
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
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode slowNext = slow.next;
        slow.next = null;
        ListNode secondHead = reverseLL(slowNext);
        slow = head;
        fast = secondHead;
        while(slow!=null&&fast!=null)
        {
            ListNode next1 = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = next1;
            slow = next1;
        }
        return;
    }

    private ListNode reverseLL(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}