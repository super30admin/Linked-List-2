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

Leetcode: 143 
Time: O(Max(m,n))
Space: O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;     
        ListNode s = head;
        ListNode f = head;
        while(f.next !=null && f.next.next != null){
         s = s.next;
         f = f.next.next;
        }
        f = reverse(s.next);
        s.next = null;
        s = head;
        ListNode curr;
        while(f!=null){
            curr = s.next;
            s.next = f;
            f = f.next;
            s.next.next = curr;  
            s = curr;
        }     
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode reverse = reverse(head.next);
        head.next.next = head;
        head.next = null; 
        return reverse;
    }
}
