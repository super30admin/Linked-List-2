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
    //Time O(N)
    //Space O(1)
    public void reorderList(ListNode head) {
        if(head == null)
        {
            return;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode S = head , T = null , next_S = null;
        T = Reverse(slow.next);
        slow.next = null;
        while(T != null)
        {
            next_S = S.next;
            S.next = T;
            T = T.next;
            S.next.next = next_S;
            S = next_S;
        }
    }
    public ListNode Reverse(ListNode head)
    {
        ListNode prev = null , curr = head , next = null;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}