//Time complexity: O(n)
//Space complexity: O(1)
//Executed on leetcode.

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
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
        }                           //Dividing list to 2 halves.
        fast = reverse(slow.next);  //Second half will be stored in reverse.
        slow.next = null;
        slow = head;                 //Now merging first and second list.
        while(fast!=null && slow!=null)
        {
            ListNode slowNext = slow.next;
            ListNode fastNext = fast.next;
            slow.next = fast;
            fast.next= slowNext;
            
            fast = fastNext;
            slow = slowNext;
        }

    }
    
    ListNode reverse(ListNode slow)
    {
        if(slow==null)
            return null;
        ListNode temp = null;
        ListNode result = slow.next;
        while(slow.next!=null)
        {
            slow.next = temp;
            temp = slow;
            slow =result;
            result = result.next;
        }     
        slow.next = temp;
        return slow;
    }
}