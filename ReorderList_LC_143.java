//Time complexity - O(N)
//Space complexity - O(1)
public class ReorderList_LC_143 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //finding middle
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;

        //Merger
        while(fast != null) {
            ListNode tmp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = tmp;
            slow = tmp;
        }
        //return head;
    }

    private ListNode reverseList(ListNode current) {
        ListNode tmp = null;
        ListNode prev = null;
        while(current != null){
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }
}
