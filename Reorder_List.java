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

// TC : O(n)
// SC : O(n)
class Solution {
    private ListNode helper(ListNode mid) {
        ListNode cur = mid, next = mid.next, prev = null;
        
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)
            return;
        
        ListNode temp = head;
        //ListNode d = new ListNode(-1);
        //d.next = head;
        ListNode slow = head, fast = head;
        ListNode rev;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
                
       rev = helper(fast);
        
        ListNode d = new ListNode(-1);
        while(temp != null) {
            ListNode temp1 = temp;
            temp = temp.next;
            temp1.next = null;
            ListNode revTemp = rev;
            if(rev != null) {
                rev = rev.next;
                revTemp.next = null;
            }
            d.next = temp1;
            d = d.next;
            d.next = revTemp;
            d = d.next;
        }
    }
}
