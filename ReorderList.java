/** Given a singly linked list L: L0→L1→…→Ln-1→Ln,
* reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
* TC O(2N) = O(N). SC O(N) for recursion
*
/
class Solution {
    public void reorderList(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null || fast.next!= null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        fast = helper(fast, fast, fast.next);
        
    }
    
    ListNode helper(ListNode head, ListNode prev, ListNode temp) {
        if (prev == null || prev.next == null) {
            return head;
        }
            prev.next = temp.next;
            temp.next = head;
            head = temp;
            return helper(head, prev, prev.next);  
    }
}
