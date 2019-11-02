/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* 143. Reorder List
Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //Now slow is at the middle

        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;

        ListNode temp;
        while(slow != null && fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode cur = head;
        ListNode temp = cur.next;

        temp = reverseList(temp);
        cur.next.next = cur;
        cur.next = null;
        return temp;
    }
}