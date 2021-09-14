// TIME: O(n)
// SPACE: O(1)
// SUCCESS on LeetCode

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        ListNode prev = null;
        while (sp != null && fp != null) {
            if (fp.next == null) break;
            prev = sp;
            sp = sp.next;
            fp = fp.next.next;
        }
        if (prev == null) {
            return;
        }
        prev.next = null;
        ListNode reverse = reverseList(sp);
        head = mergeLists(head, reverse);
    }
    
    private ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode temp = l1.next;
        l1.next = l2;
        l1.next.next = mergeLists(temp, l2.next);
        return l1;
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
