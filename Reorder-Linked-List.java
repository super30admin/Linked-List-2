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
        if(head == null) return;
        ListNode slow = head; ListNode fast = head;
        //find the middle of the linked list
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headB = slow.next;
        slow.next = null;
        
        //if second linked list is null, we do not need to reverse or merge
        if(headB == null) return;
        
        //reverse second half of the linked list
        ListNode prev = null;
        ListNode curr = headB;
        fast = headB.next;
        
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        headB = curr;
        
        //merge both the linked lists
        slow = head; fast = headB;
        
        while(fast!=null){
            curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
}
