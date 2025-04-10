

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
class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode curr = head;
        ListNode slow = curr;
        ListNode fast = curr;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHead = reverse(slow.next);
        slow.next = null;
        //Reverse Fast Pointer
        fast = reverseHead;
        slow = curr;

        while(fast != null){
            ListNode slowNext = slow.next;
            slow.next = fast;
            ListNode fastNext = fast.next;
            fast.next = slowNext;
            slow = slowNext;
            fast = fastNext;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}