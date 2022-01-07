https://leetcode.com/submissions/detail/615140415/
Time: O(n)
Space: O(1)

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
        ListNode head2 = null;
        ListNode slow = head;
        ListNode fast = head;
        
        //Finding mid
        while(fast.next != null && fast.next.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        head2 = slow.next;
        slow.next = null;
        
        //reversing linked list
        if(head2 != null)
         head2 = reverse(head2);
        
        //Merge
        while(head2 != null){
            
            ListNode temp = head.next;
            head.next = head2;
            head2 = head2.next;
            head.next.next = temp;
            head = temp;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode fast = head.next;
        
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = fast; 
            if(fast != null)
                fast = fast.next;
        }    
        return prev;
    }
}