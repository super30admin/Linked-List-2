// Time Complexity : O(n)
// Space Complexity : O(1)

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
        
        //find middle
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;
        
        while(slow.next != null){
            ListNode temp1 = slow.next;
            ListNode temp2 = fast.next;
            slow.next = fast;
            fast.next = temp1;
            slow = temp1;
            fast = temp2;
        }   
        
        slow.next = fast;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode fast = head.next;
        while(fast != null){
            cur.next = prev;
            prev = cur;
            cur = fast;
            fast = fast.next;
        }
        cur.next = prev;
        return cur;
    }
}