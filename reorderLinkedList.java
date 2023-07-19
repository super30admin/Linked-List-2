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
        ListNode fast = head;
        ListNode slow = head;
        if(head==null ||head.next==null ||head.next.next==null) return;
        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;

        slow = head;
        
        while(fast!=null){
            ListNode temp = slow.next;    
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    public ListNode reverse(ListNode head){
        if(head ==null ||head.next==null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode prev = null;

        while(fast!=null){
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }
        slow.next = prev;
        return slow;
    }
}
