//Accepted on LT
//Idea is to break the linkedlist and reverse the other part and play with links

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode l2 = reverse(slow.next);
        slow.next = null;
        while (l2!=null) {
            ListNode temp1 = head.next;
            head.next = l2;
            l2=l2.next;
            head.next.next = temp1;
            head = temp1;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode p = null, current = head, temp;
        while (current!=null) {
            temp = current.next;
            current.next = p;
            p = current;
            current = temp;
        }
        return p;
    }
}