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

// T.C - O(N)   S.C - O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        //Find the middle element
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //Reverse the second part
        fast = reverse(slow.next);
        
                      // assign last_element.next in first part to null & move slow pointer to head
        slow.next = null;
        slow = head;
        
        //Merge both the parts
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next; 
        }
        
        curr.next = prev;
        
        return curr;
    }
}
