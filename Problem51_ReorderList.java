/********************** Time Complexity: O(n) **********************/
/********************** Space Complexity: O(1) **********************/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        //edge case
        //head == null for odd list
        //head.next == null for even list
        if(head == null || head.next == null) return;
        
        //finding middle of list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            //move slow 1x times and fast 2x times
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        ListNode temp;
        while(slow!= null && fast!=null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    //reversing the list
    private ListNode reverse(ListNode head){
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