/**
 * Time: O(n) n-nodes in the list
 * Space: O(1)
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
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr = slow.next,prev=null;
        slow.next = null;
        while(curr!=null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }


        ListNode first = head, sec = prev;
        while(sec!=null){
            ListNode fnxt = first.next;
            first.next = sec;
            sec = sec.next;
            first.next.next = fnxt;
            first = fnxt;
        }
    }
}