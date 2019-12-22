/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
Leet Code Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)

The idea is to divide this problem in three parts. 1) find middle part of the list 2) Reverse list from middle part of the list 3) Merge the two lists. The main issue is merging which i faced earlier in my code but rest is okay.
**/

class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)
            return;
        
        //Find the middle of the list
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        //Reverse from middle position
        //Assign it to fast pointer
        fast = reverseList(slow.next);
        
        
        //Iterate fast and slow pointers of both list as per required output
        //Create two lists
        slow.next = null;
        slow      = head;
        
        //Now generate results;
        while(slow != null && fast != null){
            ListNode temp  = slow.next;
            slow.next      = fast;
            //fast.next      = temp;
            fast           = fast.next;
            slow.next.next = temp;
            slow           = temp;
        }
        
        
    }
    
    private ListNode reverseList(ListNode node){
        ListNode current = node;
        ListNode prev    = null;
        ListNode fast    = node.next;
        
        while(fast != null){
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        current.next = prev;
        return current;
    }
}
