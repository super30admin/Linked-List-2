

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
class Solution {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head.next;

        // find middle element of linkedlist
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = head;

        // reverse linkedList from middle
        ListNode head2 = reverse(slow.next);
        slow.next = null;

        // merge two linkedlists
        while(head1 != null && head2 != null){
            ListNode temp = head2.next;
            head2.next = head1.next;
            head1.next = head2;
            head1 = head2.next;
            head2 = temp;
        }
    }

    private ListNode reverse(ListNode curr){

        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr= temp;

        }
        return prev;
    }
}
