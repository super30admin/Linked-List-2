//o(n) time and o(1) space
//passed all leetcode cases
// used approach discussed in class

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null &&fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        ListNode curr = slow.next;
        while(fast!=null){
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
            curr = curr.next;
        }

    }
    private ListNode reverse(ListNode head){
        if(head==null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode nex = head.next;
        while(nex!=null){
            curr.next = prev;
            prev = curr;
            curr = nex;
            nex = nex.next;
        }
        curr.next = prev;
        return curr;
    }
}