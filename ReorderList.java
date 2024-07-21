//Time - O(n)
//Space - O(1)
class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        //Find middle of LL
        ListNode slow = head, fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse second half of the LL
        fast = reverse(slow.next);

        //Merge two LLs
        slow.next = null;
        slow = head;

        ListNode temp = null;
        while(fast != null) {
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, curr = head, next = head.next;
        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;

        return curr;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}