//time n
//space constant

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
    public void reorderList(ListNode head)
    {

        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode revhead = reverse(slow);

        while(head!=null)
        {

            ListNode next1 = head.next;
            ListNode next2 = revhead.next;

            head.next = revhead;
            if(next1 == null) return;
            revhead.next = next1;

            head = next1;
            revhead = next2;
        }

    }

    private ListNode reverse(ListNode head)
    {
        ListNode temp = head;
        ListNode prevs = null;

        while(temp!=null)
        {
            ListNode next = temp.next;
            temp.next = prevs;
            prevs = temp;
            temp = next;
        }

        return prevs;
    }


}
