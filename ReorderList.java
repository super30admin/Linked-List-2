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
class ReorderList {
    public void reorderList(ListNode head) {
        // find the middle of the list
        // fast and slow pointer
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!= null && fast.next != null) {
            prev = slow;
            slow= slow.next;
            fast= fast.next.next;
        }
        // got the middle
        // slow is the middle
        
        if(fast!=null && fast.next== null) {// for odd.            
            prev=slow;
            slow = slow.next;
            
        }
        // remove the cycle in linked list. otherwise it will be a cycle(loop.)
        prev.next = null;
        // reverse the second half
        ListNode dummy = null;
        
        while(slow!=null) {
            ListNode ahead = slow.next;
            slow.next = dummy;
            dummy = slow;
            slow = ahead;
        }
        // dummy is the start of the reversed list.
        // combine
        ListNode curr = head;
        while(dummy!=null) {
            ListNode temp = curr.next; // 2
            curr.next = dummy; //1->5
            dummy = dummy.next; // 4
            curr.next.next = temp; // 5->2
            curr = temp; // 
        }
    }
}