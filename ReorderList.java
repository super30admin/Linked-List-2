public class ReorderList {
    public void reorderList(ListNode head) {
        //find mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverseList(slow.next);
        slow.next = null;

        //merge head and head2
        while(head2!=null){
            ListNode temp = head.next;
            head.next = head2;
            head2 = head2.next;
            head.next.next = temp;
            head = temp;
        }

    }
    private ListNode reverseList(ListNode head){
        if(head==null||head.next==null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        head = curr;
        return head;
    }
}
