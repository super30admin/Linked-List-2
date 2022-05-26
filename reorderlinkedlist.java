/**Time Complexity : O(n)
Space Complexity: O(1)
Did your code run on leetcode : yes
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
        if(head == null || head.next == null ||  head.next.next == null)
                    return;

        ListNode slow = head;
        ListNode fast = head;
        
        //finding middle
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reversing second half of linked list
        fast = reverse(slow.next);
        slow.next = null;
        
        slow = head;
        //merging
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
    }
    
    //reverse second half of linked list
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(fast != null)
        {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
       curr.next = prev;
        return curr;
    }
}
